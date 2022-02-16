package com.nem.pro.modules.sys.service.impl;

import com.nem.pro.modules.sys.domain.SysDept;
import com.nem.pro.modules.sys.mapper.SysDeptMapper;
import com.nem.pro.modules.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired(required = false)
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> tree() {
        return toTree(sysDeptMapper.selectDept(),"0");
    }

    @Override
    public Boolean updateById(SysDept sysDept) {
        Integer result= sysDeptMapper.updateById(sysDept);
        return result>0;
    }

    @Override
    @Transactional
    public Boolean removeById(String id) {
        Integer result= sysDeptMapper.deleteById(id);
        return result>0;
    }

    @Override
    @Transactional
    public Boolean removeByIds(Collection<? extends Serializable> ids) {
       sysDeptMapper.deleteByIds(ids);
       return true;
    }

    @Override
    public Boolean save(SysDept sysDept) {
        if(null==sysDept.getParent()){
            sysDept.setParent("0");
        }
        Integer result=sysDeptMapper.insert(sysDept);
        return result>0;
    }

    @Override
    public List<SysDept> selectDeptByParentId(String parentId) {
        return sysDeptMapper.selectDeptByParentId(parentId);
    }

    public List<SysDept> toTree(List<SysDept> sysDept, String parent) {
        List<SysDept> list = new ArrayList<>();
        for (SysDept dept : sysDept) {
            if (parent.equals(dept.getParent())) {
                dept.setChildren(toTree(sysDept, dept.getId()));
                list.add(dept);
            }
        }
        return list;
    }
}
