package com.nem.pro.modules.sys.rest;

import com.nem.pro.common.aop.annotation.Log;
import com.nem.pro.common.constant.ControllerConstant;
import com.nem.pro.common.web.base.BaseController;
import io.swagger.annotations.Api;
import com.nem.pro.common.web.domain.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"测试"})
@RestController
@RequestMapping(ControllerConstant.PREFIX_SYS+"hello")
public class HelloController extends BaseController {

    @GetMapping("jpa")
    @Log(title = "查询部门")
    @ApiOperation(value = "查询部门")
    public Result testHello()
    {
       return success("hello jpa");
    }
}
