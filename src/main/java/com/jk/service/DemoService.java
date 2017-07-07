package com.jk.service;

import com.jk.vo.AreaRequest;
import com.jk.vo.AreaResponse;

import java.util.List;

/**
 * Created by Lxx on 2017/6/16.
 */
public interface DemoService {
    List selectList();

    void doadd(AreaRequest areaRequest);

    AreaResponse update(AreaRequest areaRequest);

    void doupdate(AreaRequest areaRequest);

    void del(AreaRequest areaRequest);
}
