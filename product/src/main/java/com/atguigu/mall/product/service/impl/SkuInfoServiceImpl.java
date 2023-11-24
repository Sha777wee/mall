package com.atguigu.mall.product.service.impl;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.Query;
import com.atguigu.mall.product.dao.SkuInfoDao;
import com.atguigu.mall.product.entity.SkuImagesEntity;
import com.atguigu.mall.product.entity.SkuInfoEntity;
import com.atguigu.mall.product.entity.SkuItemVo;
import com.atguigu.mall.product.entity.SpuInfoDescEntity;
import com.atguigu.mall.product.service.AttrGroupService;
import com.atguigu.mall.product.service.SkuInfoService;
import com.atguigu.mall.product.service.SpuInfoDescService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Resource
    private SkuImagesServiceImpl skuImagesService;

    @Resource
    private SpuInfoDescService spuInfoDescService;

    @Resource
    private AttrGroupService attrGroupService;

    @Autowired
    private ThreadPoolExecutor executor;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        return this.list(new QueryWrapper<SkuInfoEntity>().eq("spuId", spuId));
    }

    @Override
    public SkuItemVo item(String skuId) {
        SkuItemVo skuItemVo = new SkuItemVo();
        CompletableFuture<SkuInfoEntity> infoFuture = CompletableFuture.supplyAsync(() -> {
            // 1. 获取sku的基本信息 pm_sku_info
            SkuInfoEntity info = getById(skuId);
            skuItemVo.setInfo(info);
            return info;
        }, executor);

        CompletableFuture<Void> attrFuture = infoFuture.thenAcceptAsync((res) -> {
            // 3. 获取spu的销售属性组合

        }, executor);

        CompletableFuture<Void> descFuture = infoFuture.thenAcceptAsync((res) -> {
            // 4. 获取spu的介绍
            Long spuId = res.getSpuId();
            SpuInfoDescEntity desc = spuInfoDescService.getById(spuId);
            skuItemVo.setDesc(desc);
        }, executor);

        CompletableFuture<Void> baseAttrFuture = infoFuture.thenAcceptAsync((res) -> {
            // 5. 获取spu规格参数信息
            skuItemVo.setGroupVos(attrGroupService.getAttrGroupWithAttrsBySpuId(res.getSpuId()));
        }, executor);


        CompletableFuture<Void> imageFuture = CompletableFuture.runAsync(() -> {
            // 2. sku的图片信息 pm_sku_images
            List<SkuImagesEntity> images = skuImagesService.getImagesBySkuId(skuId);
            skuItemVo.setImages(images);
        }, executor);

        // 等待所有任务都执行完成
        CompletableFuture.allOf(infoFuture, attrFuture, descFuture, baseAttrFuture, imageFuture).join();
        return skuItemVo;
    }
}