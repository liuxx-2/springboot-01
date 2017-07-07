package com.jk.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jk.service.DemoService;
import com.jk.util.PageUtil;
import com.jk.vo.Area;
import com.jk.vo.AreaRequest;
import com.jk.vo.AreaResponse;
import com.jk.vo.ResultData;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lxx on 2017/6/16.
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("list")
    public ModelAndView selectList(ModelAndView mv,HttpServletRequest request,@RequestParam(value="cpage", required=true, defaultValue="1")Integer cpage) {
       PageHelper.startPage(cpage, 2);

        List list = demoService.selectList();
        //总页数
        int pages = ((Page) list).getPages();
        //分页单位
        int pageSize = ((Page)list).getPageSize();

        String url = "list?";
        PageUtil.page(request,cpage,pages,list,url);

        mv.addObject("list",list);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("insert")
    public ModelAndView insert(ModelAndView mv) {
        mv.setViewName("add");
        return mv;
    }

    @RequestMapping("doadd")
    public ModelAndView doadd(AreaRequest areaRequest,ModelAndView mv) {
        demoService.doadd(areaRequest);
        List list = demoService.selectList();
        mv.addObject("list",list);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("update")
    public ModelAndView update(AreaRequest areaRequest,ModelAndView mv) {
        AreaResponse areaResponse = demoService.update(areaRequest);
        mv.addObject("area",areaResponse);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping("doupdate")
    public ModelAndView doupdate(AreaRequest areaRequest,ModelAndView mv) {
        demoService.doupdate(areaRequest);
        List list = demoService.selectList();
        mv.addObject("list",list);
        mv.setViewName("index");
        return mv;
    }

    //测试查询
    @RequestMapping(value="selectList",method = RequestMethod.GET)
    public ResultData selectList(AreaRequest areaRequest){
        ResultData resultData = new ResultData();
        List list = demoService.selectList();
        if(list.size()>0){
            resultData.setCode(200);
            resultData.setMsg("成功");
            resultData.setData(list);
        }
        return resultData;
    }

    //测试添加
    @RequestMapping(value = "insertArea",method = RequestMethod.POST)
    public ResultData insertArea(@RequestBody AreaRequest areaRequest){
        ResultData resultData = new ResultData();
        demoService.doadd(areaRequest);
        resultData.setCode(200);
        resultData.setMsg("成功");
        resultData.setData(null);
        return resultData;
    }

    //测试修改
    @RequestMapping(value = "updateArea",method = RequestMethod.PUT)
    public ResultData updateArea(AreaRequest areaRequest){
        ResultData resultData = new ResultData();
        AreaResponse areaResponse = demoService.update(areaRequest);
        resultData.setCode(200);
        resultData.setMsg("成功");
        resultData.setData(areaResponse);
        return resultData;
    }

    //测试删除
    @RequestMapping(value = "delArea",method = RequestMethod.DELETE)
    public ResultData delArea(AreaRequest areaRequest){
        ResultData resultData = new ResultData();
        demoService.del(areaRequest);
        resultData.setCode(200);
        resultData.setMsg("成功");
        resultData.setData(null);
        return resultData;
    }
}
