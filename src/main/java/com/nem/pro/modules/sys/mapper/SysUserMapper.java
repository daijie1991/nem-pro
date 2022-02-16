package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysUser;
import com.nem.pro.modules.sys.param.SysUserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Describe: 用户接口层
 * CreateTime: 2019/10/23
 * */
@Mapper
public interface SysUserMapper {

    /**
     * Describe: 根据 username 查询用户
     * Param: username
     * Return: SysUser
     * */
    SysUser selectByUsername(@Param("username") String username);

    /**
     * Describe: 根据 Id 查询用户
     * Param: id
     * Return: SysUser
     * */
    SysUser selectById(@Param("id") String id);

    /**
     * Describe: 添加用户数据
     * Param: username
     * Return: Integer
     * */
    Integer insert(SysUser sysUser);

    /**
     * Describe: 根据 Id 修改用户
     * Param: username
     * Return: Integer
     * */
    Integer updateById(SysUser sysUser);

    /**
     * Describe: 根据 Id 删除用户
     * Param: username
     * Return: Integer
     * */
    Integer deleteById(String id);

    /**
     * Describe: 根据 Id 批量删除
     * Param: username
     * Return: Integer
     * */
    Integer deleteByIds(Collection<? extends Serializable> ids);

    /**
     * 获取用户列表
     *
     * @param request 查询参数
     *
     * @return {@link SysUser}
     * */
    List<SysUser> selectUser(@Param("request") SysUserRequest request);


}
