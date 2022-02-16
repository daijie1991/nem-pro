package com.nem.pro.common.web.base.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Tree 实体
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2021/04/24
 * */
@Data
public class TreeDomain<T> extends BaseDomain{

    /**
     * 父级编号
     * */
    private String parent;

    /**
     * 子级集合
     * */
    @Transient
    private List<T> children = new ArrayList<>();
}
