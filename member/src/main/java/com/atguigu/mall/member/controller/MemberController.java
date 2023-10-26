package com.atguigu.mall.member.controller;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.R;
import com.atguigu.mall.member.entity.MemberEntity;
import com.atguigu.mall.member.feign.CouponFeignService;
import com.atguigu.mall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:30:45
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Resource
    private CouponFeignService couponFeignService;

    @RequestMapping("/testFeign")
    public R testFeign() {
        MemberEntity member = new MemberEntity();
        member.setNickname("张三");
        return R.ok().put("member", member).put("coupons", couponFeignService.memberCoupons());
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member) {
        memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member) {
        memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
