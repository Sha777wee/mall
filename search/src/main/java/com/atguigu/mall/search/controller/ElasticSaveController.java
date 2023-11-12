package com.atguigu.mall.search.controller;

import com.atguigu.mall.common.to.SkuEsModel;
import com.atguigu.mall.common.utils.R;
import com.atguigu.mall.search.service.ProductSaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/12
 */
@RestController
@RequestMapping("/search/save")
public class ElasticSaveController {

    @Resource
    private ProductSaveService productSaveService;

    // 上架商品
    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) throws IOException {
        productSaveService.save(skuEsModels);
        return R.ok();
    }
}
