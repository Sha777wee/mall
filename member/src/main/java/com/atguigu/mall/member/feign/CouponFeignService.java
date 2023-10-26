package com.atguigu.mall.member.feign;

import com.atguigu.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Shawee
 * @Date 2023/10/26
 */
@FeignClient("coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
