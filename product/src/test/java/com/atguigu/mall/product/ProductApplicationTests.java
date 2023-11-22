package com.atguigu.mall.product;

import com.atguigu.mall.product.entity.BrandEntity;
import com.atguigu.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductApplicationTests {

    @Resource
    private BrandService brandService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("key1", "value1");
    }

    @Test
    public void testInsertBrand() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
    }


}
