package com.nem.pro.modules.sys.domain;

import com.nem.pro.common.web.base.domain.TreeDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import javax.persistence.Transient;

/**
 * 权限模型
 * <p>
 * Author: 就 眠 仪 式
 * CreateTime: 2021/04/01
 */

@Data
@Alias("SysPower")
@EqualsAndHashCode(callSuper = true)
public class SysPower extends TreeDomain<SysPower> {

    /**
     * 编号
     */
    private String id;

    /**
     * 相关组件
     */
    private String component;

    /**
     * 权限标识
     */
    private String code;

    /**
     * 路由
     */
    private String path;

    /**
     * 类型
     */
    private String type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 链接
     */
    private String link;

    /**
     * 国际化
     */
    private String i18n = "sys.user";

    /**
     * 隐藏
     */
    @Transient
    private Boolean hidden;

    /**
     * 状态
     */
    private Boolean enable;

}
