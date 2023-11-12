package com.atguigu.mall.common.to;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/12
 */

@Data
public class SkuEsModel {
    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private BigDecimal skuPrice;

    private String skuImg;

    private Long saleCount;

    private Boolean hasStock;

    private Long hotScore;

    private Long brandId;

    private Long catalogId;

    private String brandName;

    private String brandImg;

    private String catalogName;

    private String catalogImg;

    private List<Attrs> attrs;

    @Data
    static class Attrs {
        private Long attrId;

        private String attrName;

        private String attrValue;
    }
}
