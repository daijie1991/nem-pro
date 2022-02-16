package com.nem.pro.modules.sys.domain;


import com.nem.pro.common.web.base.domain.TreeDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门模型
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Data
@Alias("SysDept")
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="sys_dept")
public class SysDept extends TreeDomain<SysDept> {

    /**
     * 部门 ID
     * */
    @Id
    private String id;

    /**
     * 部门名称
     * */
    private String name;

    /**
     * 显示顺序
     * */
    private Integer sort;

    /**
     * 是否启用
     * */
    private boolean enable;

    /**
     * 地址
     * */
    private String address;

}
