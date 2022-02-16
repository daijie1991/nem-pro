package com.nem.pro.modules.sys.service;

import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.modules.sys.domain.SysLog;
import com.nem.pro.modules.sys.param.SysLogRequest;

import java.util.List;

/**
 * 日志服务
 * CreateTime:2021/06/20
 */
public interface SysLogService  {

    /**
     * 获取日志列表
     *
     * @param request 查询参数
     * */
    List<SysLog> list(SysLogRequest request);

    /**
     * 获取日志列表
     *
     * @param request 查询参数
     * */
    PageResponse<SysLog> page(SysLogRequest request);

    /**
     * 批量删除
     * @param action
     */
    Boolean cleanAuth(String action);

    /**
     * 批量删除
     * @param action
     */
    Boolean cleanNotAuth(String action);

    /**
     * 创建
     * @param sysLog
     */
    void save(SysLog sysLog);
}
