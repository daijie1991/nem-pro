package com.nem.pro.modules.sys.param;

import com.nem.pro.common.web.base.page.PageRequest;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 岗位列表 -- 参数实体

 * CreateTime: 2021-04-01
 */
@Data
@Alias("SysPostRequest")
public class SysPostRequest extends PageRequest {

    /**
     * 岗位名称
     * */
    private String name;

    /**
     * 岗位编号
     * */
    private String code;
}
