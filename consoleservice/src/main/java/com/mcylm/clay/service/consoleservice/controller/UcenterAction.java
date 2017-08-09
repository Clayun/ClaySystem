package com.mcylm.clay.service.consoleservice.controller;

import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.UcenterService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Controller
@RequestMapping("/list")
public class UcenterAction{

    @Autowired
    private UcenterService ucenterService;

    //列表查询
    @RequestMapping("/ucenterlist")
    public String ucenterlist(Map<String,Object> map) throws IOException, TemplateException {
        List<Ucenter> list = ucenterService.getList(map);
        map.put("list",list);
        return "console";
    }

    //添加
    @RequestMapping(value="/ucenteradd",method= RequestMethod.POST)
    @ResponseBody
    public boolean toadd(Ucenter ucenter){
        try {
            //获取UUID
            UUID uuid=UUID.randomUUID();
            String str = uuid.toString();
            String uuidStr=str.replace("-", "");
            ucenter.setUuid(uuidStr);

            //获取当前创建时间
            ucenter.setCreateTime(new Date());
            ucenterService.ucenteradd(ucenter);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //删除
    @RequestMapping(value="/ucenterdel",method= RequestMethod.POST)
    @ResponseBody
    public boolean ucenterdel(Integer id){
        try{
            ucenterService.ucenterdel(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //修改姓名
    @RequestMapping(value = "/doUpdateUcenter",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateUcenter(String username,Integer id){
        try {
            ucenterService.doUpdateUcenter(username,id);
            return "success";
        }catch (Exception e){
            return " ";
        }
    }

    //修改电话
    @RequestMapping(value = "/doUpdatePhone",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdateUcenterPhone(@Param("phone") String phone, @Param("id")Integer id){
        try {
            ucenterService.doUpdateUcenterPhone(phone,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }
    //修改密码
    @RequestMapping(value = "/doUpdatePassword",method= RequestMethod.POST)
    @ResponseBody
    public String doUpdatePassword(@Param("password") String password, @Param("id")Integer id){
        try {
            ucenterService.doUpdatePassword(password,id);
            return "success";
        }catch (Exception e){
            return "";
        }
    }
}