package com.atguigu.mall.product.controller;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.R;
import com.atguigu.mall.product.entity.AttrEntity;
import com.atguigu.mall.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:25:01
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

//    @Resource
//    private Redisson redisson;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId) {
        AttrEntity attr = attrService.getById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrEntity attr) {
        attrService.save(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrEntity attr) {
        attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

//    @RequestMapping("/write")
//    public String write() {
//        RReadWriteLock lock = redisson.getReadWriteLock("rw-lock");
//        // 获取写锁
//        RLock rlock = lock.writeLock();
//        try {
//            rlock.lock();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            rlock.unlock();
//        }
//        return "success";
//    }
//
//    @RequestMapping("/read")
//    public String read() {
//        RReadWriteLock lock = redisson.getReadWriteLock("rw-lock");
//        // 获取读锁
//        RLock rlock = lock.readLock();
//        try {
//            rlock.lock();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            rlock.unlock();
//        }
//        return "success";
//    }
//
//    /**
//     * 模拟车库停车
//     * 3车位
//     */
//    @GetMapping("park")
//    public String park() throws InterruptedException {
//        RSemaphore park = redisson.getSemaphore("park");
//        park.acquire();
//        return "success";
//    }
//
//    @GetMapping("go")
//    public String go() throws InterruptedException {
//        RSemaphore park = redisson.getSemaphore("park");
//        park.release();
//        return "success";
//    }
//
//    /**
//     * 放假 锁门
//     * 5个班全部走完，可以锁大门
//     */
//    @GetMapping("/lockDoor")
//    public String lockDoor() throws InterruptedException {
//        RCountDownLatch door = redisson.getCountDownLatch("door");
//        door.trySetCount(5);
//        door.await();
//        return "放假了...";
//    }
//
//    @GetMapping("/leave")
//    public String leave() {
//        RCountDownLatch door = redisson.getCountDownLatch("door");
//        door.countDown();
//        return "走了一个班";
//    }
}
