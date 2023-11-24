package com.atguigu.mall.product.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/23
 */

@Data
public class SkuItemVo {

    // sku基本信息
    private SkuInfoEntity info;
    // sku图片信息
    private List<SkuImagesEntity> images;
    // spu的销售组合
    private List<SkuItemSalAttrVo> salAttrs;
    // spu的介绍
    private SpuInfoDescEntity desc;
    // spu的参数规格信息
    private List<SpuItemSalAttrGroupVo> groupVos;

    @Data
    public static class SpuItemSalAttrGroupVo {
        private String groupName;

        private List<SpuBaseAttrVo> attrs;
    }

    @Data
    public static class SpuBaseAttrVo {
        private String attrName;

        private String attrValues;
    }

    @Data
    public static class SkuItemSalAttrVo {
        private Long attrId;

        private String attrName;

        private List<String> attrValues;
    }
}
