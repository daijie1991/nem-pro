package com.nem.pro.modules.sys.service.impl;


import com.nem.pro.common.web.base.page.PageResponse;
import com.nem.pro.common.web.base.page.Pageable;
import com.nem.pro.modules.sys.domain.SysLog;
import com.nem.pro.modules.sys.mapper.SysLogMapper;
import com.nem.pro.modules.sys.param.SysLogRequest;
import com.nem.pro.modules.sys.repository.SysLogRepository;
import com.nem.pro.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogRepository sysLogRepository;

    @Autowired(required = false)
    private SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> list(SysLogRequest request) {
        return sysLogMapper.selectLog(request);
    }

    @Override
    public PageResponse<SysLog> page(SysLogRequest request) {
        return Pageable.of(request,(()-> sysLogMapper.selectLog(request)));
    }

    @Override
    @Transactional
    public Boolean cleanAuth(String action) {
       return  sysLogRepository.cleanAuth(action);
    }

    @Override
    @Transactional
    public Boolean cleanNotAuth(String action) {
        return  sysLogRepository.cleanNotAuth(action);
    }

    @Override
    public void save(SysLog sysLog) {
         sysLogRepository.save(sysLog);
    }


}
