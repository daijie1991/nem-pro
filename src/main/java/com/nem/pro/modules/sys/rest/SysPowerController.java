package com.nem.pro.modules.sys.rest;

import com.nem.pro.common.aop.annotation.Log;
import com.nem.pro.common.constant.ControllerConstant;
import com.nem.pro.common.web.base.BaseController;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.service.SysPowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限控制器
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/27
 * */
@Api(tags = {"权限"})
@RestController
@RequestMapping(ControllerConstant.PREFIX_SYS + "power")
public class SysPowerController extends BaseController {

    @Autowired
    private SysPowerService sysPowerService;

    /**
     * 查询权限
     */
    @GetMapping("tree")
    @Log(title = "查询权限")
    @ApiOperation(value = "查询权限")
    public Result tree(){
        return success(sysPowerService.tree());
    }

    /**
     * 新增权限
     *
     * @param sysPower 权限实体
     *
     * @return {@link Boolean}
     */
    @PostMapping("save")
    @Log(title = "新增权限")
    @ApiOperation(value = "新增权限")
    public Result save(@RequestBody SysPower sysPower){
        return auto(sysPowerService.save(sysPower));
    }

    /**
     * 修改权限
     *
     * @param sysPower 权限实体
     *
     * @return {@link Boolean}
     */
    @PutMapping("edit")
    @Log(title = "修改权限")
    @ApiOperation(value = "修改权限")
    public Result edit(@RequestBody SysPower sysPower){
        return auto(sysPowerService.updateById(sysPower));
    }

    /**
     * 删除权限
     *
     * @param id 权限编号
     *
     * @return {@link Boolean}
     */
    @DeleteMapping("remove")
    @Log(title = "删除权限")
    @ApiOperation(value = "删除权限")
    public Result remove(String id){
        return auto(sysPowerService.removeById(id));
    }

}
