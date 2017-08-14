package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mcylm.clay.service.consoleservice.utils.MD5Util.generate;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Service
public class UcenterServiceImpl implements UcenterService{

    @Autowired
    private UcenterDao ucenterDao;

    @Override
    public List<Ucenter> getList(String dropdownbox,String content,Integer pageNo,Integer pageSize,Map<String, Object> map) {
        List<Ucenter> list;
        content="%" + content + "%";
        if(dropdownbox==null){
            Page page=new Page();
            int cPage=(pageNo - 1)*pageSize;
            page.setcPage(cPage);
            page.setPageSize(pageSize);
            list=ucenterDao.getList(page,map);
        }else if(dropdownbox.contains("ID")){
            list=ucenterDao.getIDList(content);
        }else if(dropdownbox.contains("用户名")){
            list=ucenterDao.getUsernameList(content);
        }else{
            list=ucenterDao.getPhoneList(content);
        }
        return list;
    }

    @Override
    public void ucenteradd(Ucenter ucenter) {
        String pwd = generate(ucenter.getPassword());
        ucenter.setPassword(generate(pwd));
        ucenterDao.ucenteradd(ucenter);
    }

    @Override
    public void ucenterdel(Integer id) {
        ucenterDao.ucenterdel(id);
    }

    @Override
    public void doUpdateUcenter(String username, Integer id) {
        ucenterDao.doUpdateUcenter(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        ucenterDao.doUpdateUcenterPhone(phone,id);
    }

    @Override
    public void doUpdatePassword(String password, Integer id) {
        ucenterDao.doUpdatePassword(generate(password),id);
    }

    @Override
    public int getCount(String dropdownbox,String content){
        int listCount;
        content="%" + content + "%";
        if(dropdownbox==null){
            listCount=ucenterDao.getCount();
        }else if(dropdownbox.contains("ID")){
            listCount=ucenterDao.getIDCount(content);
        }else if(dropdownbox.contains("用户名")){
            listCount=ucenterDao.getUsernameCount(content);
        }else{
            listCount=ucenterDao.getPhoneCount(content);
        }
        return listCount;
    }
}