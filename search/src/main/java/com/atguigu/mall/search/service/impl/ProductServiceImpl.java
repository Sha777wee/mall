package com.atguigu.mall.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.mall.common.to.SkuEsModel;
import com.atguigu.mall.search.constant.EsConstant;
import com.atguigu.mall.search.service.ProductSaveService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/12
 */
@Service
public class ProductServiceImpl implements ProductSaveService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void save(List<SkuEsModel> skuEsModels) throws IOException {

        // 1. 给es中建立索引,product,建议映射关系

        // 2. 给es中保存这些数据
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel skuEsModel : skuEsModels) {
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(skuEsModel.getSkuId().toString());
            String s = JSON.toJSONString(skuEsModel);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        if (response.hasFailures()) {
            //TODO 上架失败处理
        }
    }
}
