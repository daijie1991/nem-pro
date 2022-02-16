package com.nem.pro.common.secure.services;

import com.nem.pro.common.web.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.Collection;
import java.util.Set;

/**
 * 基础 UserInfo 实体, 为安全验证提供支持的公共属性
 * <p>
 * Author: 就 眠 仪 式
 * CreateTime: 2021/10/23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SecureUser extends BaseDomain implements UserDetails, CredentialsContainer {

    /**
     * 编号
     */

    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 启用
     */
    private boolean enable;

    /**
     * 锁定
     */
    private boolean locked;

    /**
     * 权限
     */
    @Transient
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.locked;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    // TODO 目前意义不大, 暂不实现
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
