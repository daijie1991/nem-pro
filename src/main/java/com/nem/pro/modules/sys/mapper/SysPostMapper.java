package com.nem.pro.modules.sys.mapper;

import com.nem.pro.modules.sys.domain.SysPost;
import com.nem.pro.modules.sys.param.SysPostRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Mapper
public interface SysPostMapper  {

    /**
     * 获取岗位列表
     *
     * @return {@link SysPost}
     * */
    List<SysPost> selectPost(@Param("request") SysPostRequest request);

    /**
     * Describe: 根据 Id 修改
     * Param: username
     * Return: Integer
     */
    Integer updateById(SysPost sysDept);

    /**
     * Describe: 根据 Id 删除
     * Param: username
     * Return: Integer
     */
    Integer deleteById(String id);

    /**
     * Describe: 根据 Id 批量删除
     * Param: username
     * Return: Integer
     */
    Integer deleteByIds(Collection<? extends Serializable> ids);

    /**
     * Describe: 添加数据
     * Param: username
     * Return: Integer
     */
    Integer insert(SysPost sysDept);
}
