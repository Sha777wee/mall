package com.atguigu.mall.product.service.impl;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.Query;
import com.atguigu.mall.product.dao.SkuImagesDao;
import com.atguigu.mall.product.entity.SkuImagesEntity;
import com.atguigu.mall.product.service.SkuImagesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("skuImagesService")
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesDao, SkuImagesEntity> implements SkuImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuImagesEntity> page = this.page(
                new Query<SkuImagesEntity>().getPage(params),
                new QueryWrapper<SkuImagesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuImagesEntity> getImagesBySkuId(String skuId) {
        SkuImagesDao imagesDao = this.baseMapper;
        return imagesDao.selectList(new QueryWrapper<SkuImagesEntity>().eq("sku_id", skuId));
    }

}