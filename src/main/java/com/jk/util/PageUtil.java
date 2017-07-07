package com.jk.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

	public static void page(HttpServletRequest request,Integer cpage,Integer pages,List list,String url){

		//首页
		String first = "";
		//上页
		String prev = "";
		//下页
		String next = "";
		//尾页
		String last = "";

		if(cpage==1){
			first = "首页";
			prev = "上页";
		}else{
			first = "<a href='"+request.getContextPath()+"/"+url+"&cpage=1'>首页</a>";
			prev = "<a href='"+request.getContextPath()+"/"+url+"&cpage="+(cpage-1)+"'>上页</a>";
		}

		if(cpage.equals(pages)||pages==0){
			last = "尾页";
			next = "下页";
		}else{
			next = "<a href='"+request.getContextPath()+"/"+url+"&cpage="+(cpage+1)+"'>下页</a>";
			last = "<a href='"+request.getContextPath()+"/"+url+"&cpage="+(pages)+"'>尾页</a>";
		}

		request.setAttribute("list", list);
		//当前页
		request.setAttribute("cpage", cpage);
		//总页数
		request.setAttribute("totalPage", pages);
		request.setAttribute("page", first+" "+prev+" "+next+" "+last);

	}

}
