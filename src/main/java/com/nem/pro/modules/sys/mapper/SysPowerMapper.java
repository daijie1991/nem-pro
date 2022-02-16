package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysPower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPowerMapper {
    /**
     * 获取权限列表
     *
     * @return {@link SysPower}
     * */
    List<SysPower> selectPower();

    /**
     * 根据 userId 获取权限列表
     *
     * @param userId 用户编号
     * @return {@link SysPower}
     * */
    List<SysPower> selectPowerByUserId(@Param("userId") String userId);

    /**
     * 根据 roleId 获取权限列表
     *
     * @param roleId 角色编号
     * @return {@link SysPower}
     * */
    List<SysPower> selectPowerByRoleId(@Param("roleId") String roleId);

    /**
     * 根据 userId 获取菜单
     *
     * @param userId 用户编号
     * @return {@link SysPower}
     * */
    List<SysPower> selectMenu(String userId);

    /**
     * Describe: 修改权限信息
     * Param: SysPower
     * Return: int
     * */
    int updateById(SysPower sysPower);

    /**
     * Describe: 删除权限信息
     * Param: id
     * Return: int
     * */
    int deleteById(String id);

    /**
     * Describe: 保存 SysPower 权限数据
     * Param: SysPower
     * Return: SysPower
     * */
    Integer insert(SysPower sysPower);
}
