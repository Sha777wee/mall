package com.atguigu.mall.search.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author Shawee
 * @Date 2023/11/22
 */

@Data
public class SearchParam {

    /**
     * 全文匹配的关键字
     */
    private String keyword;

    /**
     * 三级分类Id
     */
    private Long catalogId;

    /**
     * 排序条件
     * saleCount_asc/desc 销量排序
     * skuPrice_asc/desc 价格排序
     * hotScore_asc/desc 热度排序
     */
    private String sort;

    /**
     * 是否有货
     * 1/0
     */
    private Integer hasStock = 1;

    /**
     * 价格区间
     * 0_500/_500/500_
     */
    private String skuPrice;

    /**
     * 品牌Id
     */
    private List<Long> brandId;

    /**
     * 属性
     * 2_5寸：6寸
     * 2代表属性键，5寸、6寸代表属性值
     */
    private List<String> attrs;

    /**
     * 页码
     */
    private Integer pageNum = 1;
}
