package com.atguigu.mall.coupon.controller;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.R;
import com.atguigu.mall.coupon.entity.CouponEntity;
import com.atguigu.mall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;


/**
 * 优惠券信息
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:29:43
 */
@RestController
@RequestMapping("coupon/coupon")
@RefreshScope
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private String age;

    @RequestMapping("/testConfig")
    public R testConfig() {
        return R.ok().put("name", name).put("age", age);
    }

    /**
     * Feign测试返回优惠券
     *
     * @return
     */
    @RequestMapping("/member/list")
    public R memberCoupons() {
        CouponEntity coupon = new CouponEntity();
        coupon.setCouponName("满100减10");
        return R.ok().put("coupons", Collections.singletonList(coupon));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
