package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleDeptMapper {
    /**
     * Describe: 根据 Id 删除角色
     * Param: id
     * Return: Integer
     * */
    Integer deleteByRoleId(String roleId);

    /**
     * 批量插入
     * @param sysRolePowers
     * @return
     */
    int batchInsert(List<SysRoleDept> sysRolePowers);
}
