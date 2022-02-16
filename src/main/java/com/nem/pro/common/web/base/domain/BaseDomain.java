package com.nem.pro.common.web.base.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base 实体
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/03/23
 * */
@Data
public class BaseDomain implements Serializable {

    /**
     * 创建人
     * */
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 创建时间
     * */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人
     * */
    @ApiModelProperty("修改人")
    private String updateBy;

    /**
     * 修改时间
     * */
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    /**
     * 删除
     * */
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    /**
     * 备注
     * */
    @ApiModelProperty("备注")
    private String remark;

}
