package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysLog;
import com.nem.pro.modules.sys.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 用户角色接口
 * CreateTime:2021/06/20
 */
@Mapper
public interface SysUserRoleMapper {
    /**
     * 根据id删除角色
     *
     * @param userId 查询参数
     *
     * @return {@link SysLog}
     * */
    Integer deleteByUserId(String userId);

    /**
     * 批量插入
     * @param sysUserRoles
     * @return
     */
    Integer batchInsert(List<SysUserRole> sysUserRoles);

    Integer deleteByUserIds(Collection<? extends Serializable>  userIds);

    Integer deleteByRoleId(String roleId);

    Integer deleteByRoleIds(Collection<? extends Serializable> roleIds);

    List<SysUserRole> selectByUserId(String userId);

}
