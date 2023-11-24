package com.atguigu.mall.product.controller;

import com.atguigu.mall.common.utils.R;
import com.atguigu.mall.product.service.SkuInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Shawee
 * @Date 2023/11/23
 */
@RestController
public class ItemController {

    @Resource
    private SkuInfoService skuInfoService;

    @RequestMapping("/getSku/{skuId}")
    public R skuItem(@PathVariable("skuId") Long skuId) {
        skuInfoService.item("skuId");
        return R.ok();
    }
}
