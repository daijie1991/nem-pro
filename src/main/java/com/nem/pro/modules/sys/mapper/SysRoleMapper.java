package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysRole;
import com.nem.pro.modules.sys.param.SysRoleRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Describe: 用户角色接口层
 * CreateTime: 2019/10/23
 * */
@Mapper
public interface SysRoleMapper {

    /**
     * 获取用户角色
     *
     * @param userId 用户编号
     *
     * @return {@link SysRole}
     * */
    List<SysRole> selectByUserId(String userId);

    /**
     * Describe: 根据 username 查询用户权限
     * Param: username
     * Return: SysPower
     * */
    List<SysRole> selectByUsername(String username);
    /**
     * Describe: 查询角色列表
     * Param: SysRole
     * Return: List<SysRole>
     * */
    List<SysRole> selectList(SysRole param);

    /**
     * 获取用户列表
     *
     * @param request 查询参数
     *
     * @return {@link SysRole}
     * */
    List<SysRole> selectRole(@Param("request") SysRoleRequest request);

    /**
     * Describe: 添加角色数据
     * Param: SysRole
     * Return: 执行结果
     * */
    Integer insert(SysRole sysRole);

    /**
     * Describe: 根据 Id 查询角色
     * Param: id
     * Return: SysRole
     * */
    SysRole selectById(@Param("id") String id);

    /**
     * Describe: 根据 Id 修改角色
     * Param: SysRole
     * Return: Integer
     * */
    Integer updateById(SysRole sysRole);

    /**
     * Describe: 根据 Id 删除用户
     * Param: id
     * Return: Integer
     * */
    Integer deleteById(String id);

    /**
     * Describe: 根据 Id 批量删除
     * Param: ids
     * Return: Integer
     * */
    Integer deleteByIds(String[] ids);

}
