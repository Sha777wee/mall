package com.atguigu.mall.order.dao;

import com.atguigu.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:27:01
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
