package com.atguigu.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author shawee
 * @email 757221692@qq.com
 * @date 2023-10-26 22:30:45
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

