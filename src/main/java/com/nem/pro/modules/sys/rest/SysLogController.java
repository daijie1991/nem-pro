package com.nem.pro.modules.sys.rest;

import com.nem.pro.common.aop.annotation.Log;
import com.nem.pro.common.aop.enums.Action;
import com.nem.pro.common.constant.ControllerConstant;
import com.nem.pro.common.web.base.BaseController;
import com.nem.pro.common.web.domain.Result;
import com.nem.pro.modules.sys.param.SysLogRequest;
import com.nem.pro.modules.sys.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志控制器
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/27
 * */
@Api(tags = {"日志"})
@RestController
@RequestMapping(ControllerConstant.PREFIX_SYS + "log")
public class SysLogController extends BaseController {

    @Resource
    private SysLogService sysLogService;

    /**
     * 查询日志列表
     *
     * @param request 查询参数
     */
    @GetMapping("page")
    @Log(title = "查询日志")
    @ApiOperation(value = "查询日志")
    public Result page(SysLogRequest request){
        return success(sysLogService.page(request));
    }

    /**
     * 清空日志
     *
     * @param isAuth 日志类型
     */
    @DeleteMapping("clean")
    @Log(title = "清空日志")
    @ApiOperation(value = "清空日志")
    public Result clean(Boolean isAuth){
        if(isAuth) {
            return auto(sysLogService.cleanAuth(Action.AUTH.toString()));
        } else {
            return auto(sysLogService.cleanNotAuth(Action.AUTH.toString()));
        }
    }
}
