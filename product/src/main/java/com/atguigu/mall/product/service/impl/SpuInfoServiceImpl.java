package com.atguigu.mall.product.service.impl;

import com.atguigu.mall.common.to.SkuEsModel;
import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.Query;
import com.atguigu.mall.product.dao.SpuInfoDao;
import com.atguigu.mall.product.entity.BrandEntity;
import com.atguigu.mall.product.entity.CategoryEntity;
import com.atguigu.mall.product.entity.SkuInfoEntity;
import com.atguigu.mall.product.entity.SpuInfoEntity;
import com.atguigu.mall.product.service.BrandService;
import com.atguigu.mall.product.service.CategoryService;
import com.atguigu.mall.product.service.SkuInfoService;
import com.atguigu.mall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Resource
    private SkuInfoService skuInfoService;

    @Resource
    private BrandService brandService;

    @Resource
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void up(Long spuId) {
        // 1. 查找当前spuId对应的所有sku信息、品牌的名字
        List<SkuInfoEntity> skus = skuInfoService.getSkusBySpuId(spuId);
        // TODO 查询当前sku的所有可以被用来检索的规格属性
        // 2. 封装每个sku的信息
        List<SkuEsModel> uoProducts = skus.stream().map(sku -> {
            SkuEsModel esModel = new SkuEsModel();
            BeanUtils.copyProperties(sku, esModel);
            esModel.setSkuPrice(sku.getPrice());
            esModel.setSkuImg(sku.getSkuDefaultImg());
            BrandEntity brand = brandService.getById(esModel.getBrandId());
            esModel.setBrandName(brand.getName());
            esModel.setBrandImg(brand.getLogo());
            CategoryEntity category = categoryService.getById(esModel.getCatalogId());
            esModel.setCatalogName(category.getName());
            esModel.setCatalogImg(category.getIcon());
            // TODO 发送远程调用，库存系统是否有库存
            esModel.setHasStock(true);
            // TODO 热度评分
            esModel.setHotScore(10L);

            return esModel;
        }).collect(Collectors.toList());

        // TO 将数据发送给es进行保存
        
    }

}