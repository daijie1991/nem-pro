package com.nem.pro.modules.sys.domain;

import com.nem.pro.common.web.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位模型
 *
 * Author: 就眠仪式
 * CreateTime: 2021/03/27
 * */

@Data
@Alias("SysPost")
@Entity
@Table(name="sys_post")
@EqualsAndHashCode(callSuper = true)
public class SysPost extends BaseDomain {

    /**
     * 编号
     * */
    @Id
    private String id;

    /**
     * 名称
     * */
    private String name;

    /**
     * 编码
     * */
    private String code;

    /**
     * 排序
     * */
    private Integer sort;

    /**
     * 启用
     * */
    private Boolean enable;

}
