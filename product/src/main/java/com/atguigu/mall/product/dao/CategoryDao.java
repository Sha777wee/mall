package com.atguigu.mall.product.dao;

import com.atguigu.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

}
