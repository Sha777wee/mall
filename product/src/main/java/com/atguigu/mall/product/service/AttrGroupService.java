package com.atguigu.mall.product.service;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.product.entity.AttrGroupEntity;
import com.atguigu.mall.product.entity.SkuItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuItemVo.SpuItemSalAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId);
}

