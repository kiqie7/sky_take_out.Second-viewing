package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

public interface DishiService {


    /**
     * 新增菜品和对应口味
     */

    public void saveWithFavor(DishDTO dishDTO);


    /**
     * 菜品分页查询
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
