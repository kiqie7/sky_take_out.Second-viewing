package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishiService {


    /**
     * 新增菜品和对应口味
     */

    public void saveWithFavor(DishDTO dishDTO);
}
