package com.nem.pro.common.secure.services;

import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.domain.SysUser;
import com.nem.pro.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Security 用户服务实现
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/04/23
 * */
@Component
public class SecureUserService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 加载用户信息
     * */
    @Override
    public SysUser loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser userDetails = sysUserService.selectByUsername(username);

        if(userDetails==null) {
            throw new UsernameNotFoundException("USERNAME NOT SUPPORT");
        }
        userDetails.setAuthorities(loadAuthorities(userDetails.getId()));
        return userDetails;
    }

    /**
     * 加载用户权限
     * */
    public Set<? extends GrantedAuthority> loadAuthorities(String userId){
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        List<SysPower> powers = sysUserService.power(userId);
        for (SysPower power : powers) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(power.getCode());
            authoritySet.add(authority);
        }
        return authoritySet;
    }

}
