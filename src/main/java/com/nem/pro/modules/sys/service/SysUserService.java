package com.nem.pro.modules.sys.service;

import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.domain.SysRole;
import com.nem.pro.modules.sys.domain.SysUser;
import com.nem.pro.modules.sys.param.SysUserRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 用户服务
 * CreateTime:2021/06/20
 */
public interface SysUserService {

    /**
     * 根据用户名称查询
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    SysUser getById(String id);

    /**
     * 获取用户列表
     *
     * @param request 参数实体
     * @return {@link SysUser}
     */
    List<SysUser> list(SysUserRequest request);

    /**
     * 获取用户列表 (分页)
     *
     * @param request 查询参数
     * @return {@link SysUser}
     */
    PageResponse<SysUser> page(SysUserRequest request);

    /**
     * Describe: 根据 id 修改用户数据
     * Param: ids
     * Return: 操作结果
     * */
    Boolean updateById(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean removeById(String id);

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    Boolean removeByIds(Collection<? extends Serializable> ids);

    /**
     * Describe: 保存用户数据
     * Param: SysUser
     * Return: 操作结果
     * */
    Boolean save(SysUser sysUser);

    /**
     * 获取用户菜单
     *
     * @param userId 用户编号
     *
     * @return {@link SysUser}
     * */
    List<SysPower> menu(String userId);

    /**
     * 获取用户权限
     *
     * @param userId 用户编号
     *
     * @return {@link SysPower}
     */
    List<SysPower> power(String userId);

    /**
     * 分配用户角色
     *
     * @param userId 用户编号
     * @param roleIds 角色编号
     *
     * @return {@link Boolean}
     * */
    Boolean give(String userId, List<String> roleIds);

    /**
     * 获取用户角色
     *
     * @param userId 用户编号
     *
     * @return {@link SysRole}
     * */
    List<SysRole> role(String userId);
}
