package com.nem.pro.modules.sys.domain;

import com.nem.pro.common.aop.enums.Action;
import com.nem.pro.common.web.base.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 日志模型
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */

@Data
@Alias("SysLog")
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name ="sys_log")
public class SysLog extends BaseDomain {

    /**
     * 编号
     * */
    @Id
    private String id;

    /**
     * 标题
     * */
    private String title;

    /**
     * 描述
     * */
    @Column(name = "describes")
    private String describes;

    /**
     * 操作人
     * */
    private String operator;

    /**
     * 操作地址
     * */
    private String address;

    /**
     * 操作
     * */
    private Action action;

    /**
     * 浏览器
     * */
    private String browser;

    /**
     * 方法
     * */
    private String method;

    /**
     * 接口
     * */
    private String url;

    /**
     * 请求方式
     * */
    private String type;

    /**
     * 参数
     * */
    private String params;

    /**
     * 返回值
     * */
    private String result;

    /**
     * 状态
     * */
    private Boolean state;

    /**
     * 异常信息
     * */
    private String error;

    /**
     * 系统
     * */
    @Column(name = "`system`")
    private String system;

}
