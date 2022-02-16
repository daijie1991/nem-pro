package com.nem.pro.modules.sys.service;

import com.nem.pro.modules.sys.domain.SysPower;
import java.util.List;

public interface SysPowerService  {

    /**
     * 获取权限树
     * */
    List<SysPower> tree();

    /**
     * Describe: 保存权限数据
     * Param: SysPower
     * Return: 操作结果
     * */
    Boolean save(SysPower sysPower);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean removeById(String id);

    /**
     * Describe: 根据 id 修改
     * Param: ids
     * Return: 操作结果
     * */
    Boolean updateById(SysPower sysPower);

}
