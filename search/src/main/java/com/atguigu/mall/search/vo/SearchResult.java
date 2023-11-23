package com.atguigu.mall.search.vo;

import com.atguigu.mall.common.to.SkuEsModel;
import lombok.Data;

import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/22
 */

@Data
public class SearchResult {

    /**
     * 查询到的所有商品信息
     */
    private List<SkuEsModel> products;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页码
     */
    private Integer totalPages;

    /**
     * 品牌信息
     */
    private List<BrandVo> brands;

    /**
     * 分类
     */
    private List<CatalogVo> catalogs;

    /**
     * 属性
     */
    private List<AttrVo> attrs;

    @Data
    public static class BrandVo {
        private Integer branId;

        private String brandName;

        private String brandImg;
    }


    @Data
    public static class CatalogVo {
        private Integer catalogId;

        private String catalogName;
    }

    @Data
    public static class AttrVo {
        private Integer attrId;

        private String attrName;

        private List<String> attrValue;
    }
}
