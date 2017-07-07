package com.jk.mapper;

import com.jk.vo.AreaRequest;
import com.jk.vo.AreaResponse;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Created by Lxx on 2017/6/16.
 */
public interface DemoMapper {
    List selectList();

    void doadd(AreaRequest areaRequest);

    AreaResponse update(AreaRequest areaRequest);

    void doupdate(AreaRequest areaRequest);

    @Delete("delete from area where id = #{areaID}")
    void del(AreaRequest areaRequest);
}
