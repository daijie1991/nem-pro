package com.nem.pro.modules.sys.service;

import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.modules.sys.domain.SysPost;
import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.domain.SysUser;
import com.nem.pro.modules.sys.param.SysPostRequest;
import com.nem.pro.modules.sys.param.SysUserRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface SysPostService {

    /**
     * 获取用户列表
     *
     * @param request 参数实体
     * @return {@link SysPost}
     */
    List<SysPost> list(SysPostRequest request);

    /**
     * 获取用户列表 (分页)
     *
     * @param request 查询参数
     * @return {@link SysPost}
     */
    PageResponse<SysPost> page(SysPostRequest request);


    /**
     * Describe: 保存数据
     * Param: SysPower
     * Return: 操作结果
     * */
    Boolean save(SysPost sysPost);

    /**
     * Describe: 根据 id 修改数据
     * Param: ids
     * Return: 操作结果
     * */
    Boolean updateById(SysPost sysPost);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean removeById(String id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean removeByIds(Collection<? extends Serializable> ids);

}
