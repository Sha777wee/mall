package com.atguigu.mall.search.service;

import com.atguigu.mall.common.to.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/12
 */
public interface ProductSaveService {
    void save(List<SkuEsModel> skuEsModels) throws IOException;
}
