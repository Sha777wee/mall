package com.atguigu.mall.coupon.dao;

import com.atguigu.mall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:29:43
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {

}
