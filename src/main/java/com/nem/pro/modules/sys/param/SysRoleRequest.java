package com.nem.pro.modules.sys.param;

import com.nem.pro.common.web.base.page.PageRequest;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 角色列表 -- 参数实体
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/04/01
 */
@Data
@Alias("SysRoleRequest")
public class SysRoleRequest extends PageRequest {

    /**
     * 角色名称
     */
    private String name;
}
