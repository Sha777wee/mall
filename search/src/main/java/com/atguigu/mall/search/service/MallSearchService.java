package com.atguigu.mall.search.service;

import com.atguigu.mall.search.vo.SearchParam;
import com.atguigu.mall.search.vo.SearchResult;

/**
 * @Author Shawee
 * @Date 2023/11/22
 */
public interface MallSearchService {


    /**
     * 检索
     *
     * @param param
     * @return
     */
    SearchResult search(SearchParam param);
}
