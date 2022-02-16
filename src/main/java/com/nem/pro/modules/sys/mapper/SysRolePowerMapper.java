package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysRolePower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRolePowerMapper {

    /**
     * Describe: 根据 Id 删除用户
     * Param: username
     * Return: Integer
     * */
    Integer deleteByRoleId(String id);


    /**
     * 批量插入
     * @param sysRolePowers
     * @return
     */
    int batchInsert(List<SysRolePower> sysRolePowers);
}
