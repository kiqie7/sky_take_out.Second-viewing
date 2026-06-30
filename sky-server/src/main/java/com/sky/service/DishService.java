package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {


    /**
     * 新增菜品和对应口味
     */

    public void saveWithFavor(DishDTO dishDTO);


    /**
     * 菜品分页查询
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);


    /**
     * 批量删除菜品
     */
    void delete(List<Long> ids);

    /**
     * 根据id查菜品
     */
    DishVO getByIdWithFlavor(Long id);


    /**
     * 修改菜品
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 根据分类id查菜品
     */
    List<Category> listByCategoryId(Long categoryId);

    /**
     * 菜品起售、停售
     */
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
}
