package com.nem.pro.modules.sys.param;

import com.nem.pro.common.web.interceptor.enums.Scope;
import lombok.Data;

import java.util.List;

@Data
public class SysRoleGiveRequest {

    private String roleId;

    private List<String> powerIds;

    private Scope scope;

    private List<String> deptIds;

}
