package com.nem.pro.modules.sys.service.impl;


import com.nem.pro.modules.sys.domain.SysPower;
import com.nem.pro.modules.sys.mapper.SysPowerMapper;
import com.nem.pro.modules.sys.service.SysPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysPowerServiceImpl implements SysPowerService {

    @Autowired(required = false)
    private SysPowerMapper sysPowerMapper;

    @Override
    public List<SysPower> tree() {
        // List to Tree
        return toTree(sysPowerMapper.selectPower(),"0");
    }

    @Override
    public Boolean save(SysPower sysPower) {
        return null;
    }

    @Override
    public Boolean removeById(String id) {
        return null;
    }

    @Override
    public Boolean updateById(SysPower sysPower) {
        return null;
    }

    public List<SysPower> toTree(List<SysPower> sysMenus,String parent) {
        List<SysPower> list = new ArrayList<>();
        for (SysPower menu : sysMenus) {
            if (parent.equals(menu.getParent())) {
                menu.setChildren(toTree(sysMenus, menu.getId()));
                list.add(menu);
            }
        }
        return list;
    }
}
