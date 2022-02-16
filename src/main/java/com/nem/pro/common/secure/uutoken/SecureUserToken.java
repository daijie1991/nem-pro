package com.nem.pro.common.secure.uutoken;

import com.nem.pro.modules.sys.domain.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户 Token 封装实体
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/10/23
 * */
@Data
public class SecureUserToken implements Serializable {

    /**
     * Token
     * */
    private String token;

    /**
     * 基本信息
     * */
    private SysUser sysUser;

    /**
     * 创建时间
     * */
    private LocalDateTime createTime = LocalDateTime.now();

}
