package com.atguigu.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:32:03
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

