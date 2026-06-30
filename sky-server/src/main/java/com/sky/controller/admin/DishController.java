package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜品管理
 */

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {


    @Autowired
    private DishService dishiService;

    /**
     * 新增菜品
     */
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDTO) {

        log.info("新增菜品: {}",dishDTO);
        dishiService.saveWithFavor(dishDTO);
        return null;


    }


    /**
     * 菜品分页查询
     */

    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {


        log.info("菜品分页查询: {}", dishPageQueryDTO);
        PageResult pageResult = dishiService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 批量删除菜品
     */

    @DeleteMapping
    @ApiOperation("批量删除菜品")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("批量删除菜品: {}", ids);
        dishiService.delete(ids);
        return Result.success();
    }

    /**
     * 菜品起售、停售
     */
    @PostMapping("/status/{status}")
    @ApiOperation("菜品起售、停售")
    public Result<String> startOrStop(@PathVariable("status") Integer status, Long id) {
        log.info("菜品起售、停售: {}, {}", status, id);
        dishiService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 根据id查菜品
     */
    @GetMapping("/{id}")
    public Result<DishVO> findById(@PathVariable Long id) {

        DishVO dishVO = dishiService.getByIdWithFlavor(id);

        return Result.success(dishVO);
    }

    /**
     * 修改菜品
     */
    @PutMapping
    @ApiOperation("修改菜品")
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("修改菜品: {}", dishDTO);
        dishiService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 根据分类id查菜品
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查菜品")
    public Result<List<Category>> listByCategoryId(Long categoryId){

        List<Category> list = dishiService.listByCategoryId(categoryId);
        return Result.success(list);

    }

}
