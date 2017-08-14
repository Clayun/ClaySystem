package com.mcylm.clay.service.consoleservice.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	
	public static void page(HttpServletRequest request, Integer cPage, Integer pageSize, Integer count, Map map, List list) {
		
		int pageCount = (count/pageSize) + (count%pageSize==0?0:1);
		
		String s = "";
		if(map != null && !map.isEmpty()) {
			Set keySet = map.keySet();
			Iterator iterator = keySet.iterator();
			while(iterator.hasNext()) {
				Object key = iterator.next();
				Object value = map.get(key);
				if(value != null && !value.equals("")) {
					s += "&" + key + "=" + value;
				}
			}
		}
		
		String first = "";
		String priv = "";
		String next = "";
		String last = "";
		if(cPage == 1||cPage==0) {
			first = "<input class='btn btn-primary ' type='button' disabled='disabled' value='首页'>";
			priv = "<input class='btn btn-primary ' type='button' disabled='disabled' value='上一页'>";
		} else {
			first = "<a href='/console"+request.getRequestURI()+"?cPage=1'><input class='btn btn-primary ' type='button' value='首页'></a>";
			priv = "<a href='/console"+request.getRequestURI()+"?cPage="+(cPage-1)+"'><input class='btn btn-primary ' type='button' value='上一页'></a>";
		}
		
		if(cPage == pageCount) {
			next = "<input class='btn btn-primary ' type='button' disabled='disabled' value='下一页'>";
			last = "<input class='btn btn-primary ' type='button' disabled='disabled' value='尾页'>";
		} else {
			next = "<a id='nextpage' href='/console"+request.getRequestURI()+"?cPage="+(cPage + 1)+"'><input class='btn btn-primary ' type='button' value='下一页'></a>";
			last = "<a id='finalpage' href='/console"+request.getRequestURI()+"?cPage="+ pageCount +"'><input class='btn btn-primary ' type='button' value='尾页'></a>";
		}
		
		request.setAttribute("first", first);
		request.setAttribute("priv", priv);
		request.setAttribute("next", next);
		request.setAttribute("last", last);
		request.setAttribute("page","<span class='text-primary'>共"+count+"条数据</span>&nbsp;&nbsp;&nbsp;&nbsp;" +  first +" " + priv +" " + next +" " + last +" &nbsp;&nbsp;<span class='text-primary'>第"+cPage+"/"+pageCount+"页</span>");
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
	}
}