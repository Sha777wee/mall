package com.atguigu.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:30:45
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

