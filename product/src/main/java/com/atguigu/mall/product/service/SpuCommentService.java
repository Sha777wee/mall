package com.atguigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

