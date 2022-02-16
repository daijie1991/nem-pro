package com.nem.pro.modules.sys.domain;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色权限模型
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Data
@Alias("SysRolePower")
@Entity
@Table(name="sys_role_power")
public class SysRolePower {

    /**
     * 编号
     * */
    @Id
    private String id;

    /**
     * 角色编号
     * */
    private String roleId;

    /**
     * 权限编号
     * */
    private String powerId;
}
