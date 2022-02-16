package com.nem.pro.modules.sys.service.impl;

import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.common.web.base.page.Pageable;
import com.nem.pro.modules.sys.domain.SysPost;
import com.nem.pro.modules.sys.mapper.SysPostMapper;
import com.nem.pro.modules.sys.param.SysPostRequest;
import com.nem.pro.modules.sys.service.SysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class SysPostServiceImpl implements SysPostService {

    @Autowired(required = false)
    private SysPostMapper sysPostMapper;

    @Override
    public List<SysPost> list(SysPostRequest request) {
        return sysPostMapper.selectPost(request);
    }

    @Override
    public PageResponse<SysPost> page(SysPostRequest request) {
        return Pageable.of(request,(()-> sysPostMapper.selectPost(request)));
    }

    @Override
    public Boolean save(SysPost sysPost) {
        Integer result=sysPostMapper.insert(sysPost);
        return result>0;
    }

    @Override
    public Boolean updateById(SysPost sysPost) {
        Integer result= sysPostMapper.updateById(sysPost);
        return result>0;
    }

    @Override
    @Transactional
    public Boolean removeById(String id) {
        Integer result= sysPostMapper.deleteById(id);
        return result>0;
    }

    @Override
    @Transactional
    public Boolean removeByIds(Collection<? extends Serializable> ids) {
        sysPostMapper.deleteByIds(ids);
        return true;
    }
}
