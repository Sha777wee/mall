package com.atguigu.mall.search;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class SearchApplicationTests {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
        System.out.println(restHighLevelClient);
    }

}
