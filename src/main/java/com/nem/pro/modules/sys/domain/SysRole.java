package com.nem.pro.modules.sys.domain;

import com.nem.pro.common.web.base.domain.BaseDomain;
import com.nem.pro.common.web.interceptor.enums.Scope;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("SysRole")
@ApiModel("角色实体")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseDomain {

    /**
     * 编号
     */
    @ApiModelProperty("角色编号")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 标识
     */
    @ApiModelProperty("角色标识")
    private String code;

    /**
     * 启用
     */
    @ApiModelProperty("是否开启")
    private boolean enable;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 数据权限
     */
    @ApiModelProperty("数据权限")
    private Scope scope;

}
