package com.nem.pro.modules.sys.repository;
import com.nem.pro.modules.sys.domain.SysLog;
import com.nem.pro.modules.sys.param.SysLogRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Describe: 日 志 接 口
 * CreateTime: 2019/10/23
 * */
public interface SysLogRepository  extends JpaRepository<SysLog,Long>, JpaSpecificationExecutor<SysLog> {

    /**
     * 批量删除
     * @param action
     */
    @Modifying
    @Query(value = "delete from sys_log where action = ?1",nativeQuery = true)
    Boolean cleanAuth(String action);

    /**
     * 批量删除
     * @param action
     */
    @Modifying
    @Query(value = "delete from sys_log where action <> ?1",nativeQuery = true)
    Boolean cleanNotAuth(String action);
}
