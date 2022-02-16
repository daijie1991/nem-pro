package com.nem.pro.modules.sys.domain;


import com.nem.pro.common.secure.services.SecureUser;
import com.nem.pro.common.web.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Set;

/**
 * 用户领域模型
 * <p>
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/27
 */

@Data
@Alias("SysUser")
@Entity
public class SysUser extends BaseDomain implements UserDetails, CredentialsContainer {
    /**
     * 编号
     */
    @Id
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
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 部门
     */
    private String deptId;

    @Transient
    private String deptName;

    /**
     * 岗位
     */
    private String postId;

    @Transient
    private String postName;

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
