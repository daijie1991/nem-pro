package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysLog;
import com.nem.pro.modules.sys.param.SysLogRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogMapper {
    /**
     * 获取日志列表
     *
     * @param request 查询参数
     *
     * @return {@link SysLog}
     * */
    List<SysLog> selectLog(@Param("request") SysLogRequest request);
}
