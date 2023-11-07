package com.atguigu.mall.product.service.impl;

import com.atguigu.mall.common.utils.PageUtils;
import com.atguigu.mall.common.utils.Query;
import com.atguigu.mall.product.dao.CategoryDao;
import com.atguigu.mall.product.entity.CategoryEntity;
import com.atguigu.mall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1. 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);


        // 2. 组装成父子的树形结构
        List<CategoryEntity> level1Menus = entities.stream()
                .filter(menu -> menu.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                })
                .sorted((menu1, menu2) -> (null == menu1.getSort() ? 0 : menu1.getSort() - (null == menu2.getSort() ? 0 : menu2.getSort())))
                .collect(Collectors.toList());

        return level1Menus;
    }

    /**
     * 递归查找所有菜单的子菜单
     *
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream()
                .filter(menu -> menu.getParentCid().equals(root.getCatId()))
                .map(menu -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                .sorted((menu1, menu2) -> (null == menu1.getSort() ? 0 : menu1.getSort() - (null == menu2.getSort() ? 0 : menu2.getSort())))
                .collect(Collectors.toList());
        return children;
    }

    @Override
    public void removeMenuByIds(List<Long> list) {
        // TODO 1.检查当前删除的菜单，是否被别的地方引用

        // 逻辑删除
        baseMapper.deleteBatchIds(list);
    }
}