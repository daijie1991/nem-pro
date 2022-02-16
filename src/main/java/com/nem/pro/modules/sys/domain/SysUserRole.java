package com.nem.pro.modules.sys.domain;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色模型
 * <p>
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 */
@Data
@Entity
@Alias("SysUserRole")
@Table(name="sys_user_role")
public class SysUserRole {

    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色编号
     */
    private String roleId;

}
