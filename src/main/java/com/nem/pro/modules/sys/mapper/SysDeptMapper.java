package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 用户部门
 */
@Mapper
public interface SysDeptMapper {
    /**
     * 根据 roleId 获取部门列表
     *
     * @param roleId 角色编号
     * @return {@link SysDept}
     */
    List<SysDept> selectDeptByRoleId(String roleId);

    /**
     * 根据 parentId 获取部门列表
     *
     * @param parentId 父级编号
     * @return {@link SysDept}
     */
    List<SysDept> selectDeptByParentId(String parentId);

    /**
     * 获取部门列表
     *
     * @return {@link SysDept}
     */
    List<SysDept> selectDept();

    /**
     * Describe: 根据 Id 修改
     * Param: username
     * Return: Integer
     */
    Integer updateById(SysDept sysDept);

    /**
     * Describe: 根据 Id 删除
     * Param: username
     * Return: Integer
     */
    Integer deleteById(String id);

    /**
     * Describe: 根据 Id 批量删除
     * Param: username
     * Return: Integer
     */
    Integer deleteByIds(Collection<? extends Serializable> ids);

    /**
     * Describe: 添加数据
     * Param: username
     * Return: Integer
     */
    Integer insert(SysDept sysDept);
}