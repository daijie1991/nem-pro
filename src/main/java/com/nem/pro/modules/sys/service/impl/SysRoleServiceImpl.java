package com.nem.pro.modules.sys.service.impl;


import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.common.web.base.page.Pageable;
import com.nem.pro.common.web.interceptor.enums.Scope;
import com.nem.pro.modules.sys.domain.*;
import com.nem.pro.modules.sys.mapper.*;
import com.nem.pro.modules.sys.param.SysRoleGiveRequest;
import com.nem.pro.modules.sys.param.SysRoleRequest;
import com.nem.pro.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired(required = false)
    private SysDeptMapper sysDeptMapper;

    @Autowired(required = false)
    private SysRoleMapper sysRoleMapper;

    @Autowired(required = false)
    private SysRolePowerMapper sysRolePowerMapper;

    @Autowired(required = false)
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Autowired(required = false)
    private SysPowerMapper sysPowerMapper;

    @Autowired(required = false)
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysDept> dept(String roleId) {
        return sysDeptMapper.selectDeptByRoleId(roleId);
    }

    @Override
    public List<SysRole> list(SysRoleRequest request) {
        return sysRoleMapper.selectRole(request);
    }

    @Override
    public PageResponse<SysRole> page(SysRoleRequest request) {
        return Pageable.of(request,() -> sysRoleMapper.selectRole(request));
    }

    @Override
    @Transactional
    public Boolean give(SysRoleGiveRequest request) {

        String roleId = request.getRoleId();
        List<String> powerIds = request.getPowerIds();
        List<String> deptIds = request.getDeptIds();
        Scope scope = request.getScope();

        sysRolePowerMapper.deleteByRoleId(roleId);
        sysRoleDeptMapper.deleteByRoleId(roleId);
        SysRole sysRole=sysRoleMapper.selectById(roleId);
        if(null!=sysRole){
            sysRole.setScope(scope);
            sysRoleMapper.updateById(sysRole);
        }

        List<SysRolePower> rolePowers = new ArrayList<>();
        powerIds.forEach(powerId -> {
            SysRolePower rolePower = new SysRolePower();
            rolePower.setRoleId(roleId);
            rolePower.setPowerId(powerId);
            rolePowers.add(rolePower);
        });

        List<SysRoleDept> roleDepts = new ArrayList<>();
        deptIds.forEach(deptId -> {
            SysRoleDept roleDept = new SysRoleDept();
            roleDept.setRoleId(roleId);
            roleDept.setDeptId(deptId);
            roleDepts.add(roleDept);
        });

        sysRolePowerMapper.batchInsert(rolePowers);
        sysRoleDeptMapper.batchInsert(roleDepts);

        return true;
    }

    @Override
    public List<SysPower> power(String roleId) {
        return sysPowerMapper.selectPowerByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeById(Serializable id) {
        sysRoleMapper.deleteById(id.toString());
        sysRolePowerMapper.deleteByRoleId(id.toString());
        sysUserRoleMapper.deleteByRoleId(id.toString());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.forEach(this::removeById);
        return true;
    }
}
