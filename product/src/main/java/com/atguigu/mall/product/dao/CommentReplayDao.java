package com.atguigu.mall.product.dao;

import com.atguigu.mall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
