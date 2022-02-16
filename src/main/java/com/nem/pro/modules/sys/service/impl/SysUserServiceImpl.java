package com.nem.pro.modules.sys.service.impl;

import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.common.web.base.page.Pageable;

import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.domain.SysRole;
import com.nem.pro.modules.sys.domain.SysUser;
import com.nem.pro.modules.sys.domain.SysUserRole;
import com.nem.pro.modules.sys.mapper.SysPowerMapper;
import com.nem.pro.modules.sys.mapper.SysRoleMapper;
import com.nem.pro.modules.sys.mapper.SysUserMapper;
import com.nem.pro.modules.sys.mapper.SysUserRoleMapper;
import com.nem.pro.modules.sys.param.SysUserRequest;
import com.nem.pro.modules.sys.repository.SysUserRepository;
import com.nem.pro.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SysUserServiceImpl  implements SysUserService {

    @Autowired(required = false)
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;


    @Autowired(required = false)
    private SysPowerMapper sysPowerMapper;

    @Autowired(required = false)
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public SysUser getById(String id) {
       return sysUserMapper.selectById(id);
    }

    @Override
    public List<SysUser> list(SysUserRequest request) {
        return sysUserMapper.selectUser(request);
    }

    @Override
    public PageResponse<SysUser> page(SysUserRequest request) {
        return Pageable.of(request, (()-> sysUserMapper.selectUser(request)));
    }

    @Override
    public Boolean updateById(SysUser sysUser) {
        Integer result = sysUserMapper.updateById(sysUser);
        return result > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeById(String id) {
        sysUserRoleMapper.deleteByUserId(id);
        sysUserMapper.deleteById(id);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeByIds(Collection<? extends Serializable> ids) {
        sysUserMapper.deleteByIds(ids);
        sysUserRoleMapper.deleteByUserIds(ids);
        return true;
    }

    @Override
    public Boolean save(SysUser sysUser) {
        int result = sysUserMapper.insert(sysUser);
        return result > 0;
    }

    @Override
    public List<SysPower> power(String userId) {
        return sysPowerMapper.selectPowerByUserId(userId);
    }

    @Override
    public List<SysPower> menu(String userId) {
        return toTree(sysPowerMapper.selectMenu(userId),"0");
    }

    @Override
    @Transactional
    public Boolean give(String userId, List<String> roleIds) {
        sysUserRoleMapper.deleteByUserId(userId);
        List<SysUserRole> userRoles = new ArrayList<>();
        roleIds.forEach(roleId -> {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        });
        return sysUserRoleMapper.batchInsert(userRoles)>0;
    }

    @Override
    public List<SysRole> role(String userId) {
        return sysRoleMapper.selectByUserId(userId);
    }

    public List<SysPower> toTree(List<SysPower> sysMenus, String parent) {
        List<SysPower> list = new ArrayList<>();
        for (SysPower menu : sysMenus) {
            if (parent.equals(menu.getParent())) {
                menu.setChildren(toTree(sysMenus, menu.getId()));
                list.add(menu);
            }
        }
        return list;
    }
}
