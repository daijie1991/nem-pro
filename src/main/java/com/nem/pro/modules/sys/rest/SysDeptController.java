package com.nem.pro.modules.sys.rest;

import com.nem.pro.common.aop.annotation.Log;
import com.nem.pro.common.constant.ControllerConstant;
import com.nem.pro.common.web.base.BaseController;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.modules.sys.domain.SysDept;
import com.nem.pro.modules.sys.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/27
 * */
@Api(tags = {"部门"})
@RestController
@RequestMapping(ControllerConstant.PREFIX_SYS + "dept")
public class SysDeptController extends BaseController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 查询部门列表
     *
     * @return {@link Result}
     */
    @GetMapping("tree")
    @Log(title = "查询部门")
    @ApiOperation(value = "查询部门")
    public Result tree(){
        return success(sysDeptService.tree());
    }

    /**
     * 新增部门
     *
     * @param sysDept 部门实体
     */
    @PostMapping("save")
    @Log(title = "新增部门")
    @ApiOperation(value = "新增部门")
    public Result save(@RequestBody SysDept sysDept){
        return auto(sysDeptService.save(sysDept));
    }

    /**
     * 修改部门
     *
     * @param sysDept 部门实体
     */
    @PutMapping("edit")
    @Log(title = "修改部门")
    @ApiOperation(value = "修改部门")
    public Result edit(@RequestBody SysDept sysDept){
        return auto(sysDeptService.updateById(sysDept));
    }

    /**
     * 删除部门
     *
     * @param id 部门编号
     */
    @DeleteMapping("remove")
    @Log(title = "删除部门")
    @ApiOperation(value = "删除部门")
    public Result remove(String id){

        /// 检 测 是 否 存 在 子 部 门
        if(sysDeptService.selectDeptByParentId(id).size() > 0) return failure();

        return auto(sysDeptService.removeById(id));
    }

    /**
     * 删除部门
     *
     * @param ids 部门编号
     */
    @DeleteMapping("removeBatch")
    public Result removeBatch(List<String> ids) { return auto(sysDeptService.removeByIds(ids)); }
}