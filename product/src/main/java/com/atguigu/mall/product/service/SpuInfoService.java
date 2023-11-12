package com.atguigu.mall.product.service;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void up(Long spuId);
}

