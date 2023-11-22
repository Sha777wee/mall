package com.atguigu.mall.product.service;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.product.entity.ProductAttrValueEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu属性值
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

