package com.atguigu.mall.search.controller;

import com.atguigu.mall.search.service.MallSearchService;
import com.atguigu.mall.search.vo.SearchParam;
import com.atguigu.mall.search.vo.SearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Shawee
 * @Date 2023/11/22
 */

@RestController
public class SearchController {

    @Resource
    private MallSearchService mallSearchService;

    @GetMapping("list")
    public SearchResult listPage(SearchParam param) {
        return mallSearchService.search(param);
    }
}
