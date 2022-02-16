package com.nem.pro.modules.sys.service;

import com.nem.pro.modules.sys.domain.SysDept;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface SysDeptService  {

    List<SysDept> tree();

    /**
     * Describe: 根据 id 修改用户部门
     * Param: ids
     * Return: 操作结果
     * */
    Boolean updateById(SysDept sysDept);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean removeById(String id);

    /**
     * 批量删除部门
     * @param ids
     * @return
     */
    Boolean removeByIds(Collection<? extends Serializable> ids);

    /**
     * Describe: 保存部门数据
     * Param: SysUser
     * Return: 操作结果
     * */
    Boolean save(SysDept sysDept);

    /**
     * 根据父id查询部门信息
     * @param parentId
     * @return
     */
    List<SysDept> selectDeptByParentId(String parentId);
}
