package com.jk.service;

import com.jk.mapper.DemoMapper;
import com.jk.vo.AreaRequest;
import com.jk.vo.AreaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lxx on 2017/6/16.
 */
@Service
@Transactional
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List selectList() {
        return demoMapper.selectList();
    }

    @Override
    public void doadd(AreaRequest areaRequest) {
        demoMapper.doadd(areaRequest);
    }

    @Override
    public AreaResponse update(AreaRequest areaRequest) {
        return demoMapper.update(areaRequest);
    }

    @Override
    public void doupdate(AreaRequest areaRequest) {
        demoMapper.doupdate(areaRequest);
    }

    @Override
    public void del(AreaRequest areaRequest) {
        demoMapper.del(areaRequest);
    }
}
