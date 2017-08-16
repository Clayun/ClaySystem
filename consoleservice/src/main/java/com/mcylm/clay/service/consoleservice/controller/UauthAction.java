package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Uauth;
import com.mcylm.clay.service.consoleservice.model.UauthStr;
import com.mcylm.clay.service.consoleservice.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mcylm.clay.service.consoleservice.service.UauthService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by macbook on 2017/8/9.
 */
@Controller
@RequestMapping("uauth")
public class UauthAction {

    @Autowired
    private UauthService UauthService;

    @RequestMapping("uauthlist")
        public String uauthlist(String dropdownbox, String pageNo, String content, HttpServletRequest request, Map<String,Object> map) throws Exception {
            pageNo=request.getParameter("cPage")==null?"1":request.getParameter("cPage");
            int pageSize=8;
            int listCount = UauthService.getCount(dropdownbox,content);
            if (listCount == 0){
                pageNo = "0";
            }
            if(content!=null){
                pageNo="0";
                listCount=0;
            }
            List<Uauth> list = UauthService.getList(dropdownbox,content,Integer.parseInt(pageNo),pageSize,map);
            map.put("list",list);
            request.setAttribute("dropdownbox",dropdownbox);
            request.setAttribute("content",content);
            PageUtil.page(request, Integer.parseInt(pageNo), pageSize, listCount, map, list);

        /*List<Uauth> list = UauthService.getlist(map);
        map.put("list",list);*/
        return "uauth";
    }
    @RequestMapping(value = "/doUpdateUsername",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateUsername(String username,Integer id){
        try {
            UauthService.doUpdateUsername(username,id);
            return "success";
        }catch (Exception e){
            return " ";
        }
    }
    @RequestMapping(value = "/doUpdatePhone",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateUcenterPhone(@Param("phone") String phone, @Param("id")Integer id){
        try {
            UauthService.doUpdateUcenterPhone(phone,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }

    @RequestMapping(value = "/doUpdateEmail",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateEmail(@Param("email")String email,@Param("id")Integer id){
        try {
            UauthService.doUpdateEmail(email,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/doUpdatePassword",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdatePassword(@Param("password")String password,@Param("id")Integer id){
        try {
            UauthService.doUpdatePassword(password,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/doUpdateContent",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateContent(@Param("content")String content,@Param("id")Integer id){
        try {
            UauthService.doUpdateContent(content,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }
    @RequestMapping(value = "/uauthadd",method= RequestMethod.POST)
    @ResponseBody
    public boolean uauthadd(Uauth uauth){
        try {
            //获取UUID
            UUID uuid=UUID.randomUUID();
            String str = uuid.toString();
            String uuidStr=str.replace("-", "");
            uauth.setUuid(uuidStr);
            //获取当前创建时间
            uauth.setCreateTime(new Date());
            UauthService.uauthadd(uauth);
            return true;

        }catch (Exception e){
            return false;
        }
    }

}
