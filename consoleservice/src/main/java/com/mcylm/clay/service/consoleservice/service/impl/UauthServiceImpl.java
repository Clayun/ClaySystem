package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Uauth;
import com.mcylm.clay.service.consoleservice.service.UauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcylm.clay.service.consoleservice.dao.UauthDao;

import java.util.List;
import java.util.Map;

import static com.mcylm.clay.service.consoleservice.utils.MD5Util.generate;

/**
 * Created by macbook on 2017/8/9.
 */
@Service
public class UauthServiceImpl implements UauthService {
    @Autowired
    private UauthDao UauthDao;

    @Override
    public List<Uauth> getList(String dropdownbox, String content, Integer pageNo, Integer pageSize, Map<String, Object> map) {
        List<Uauth> list;
        content="%" + content + "%";
        if(dropdownbox==null){
            Page page=new Page();
            int cPage=(pageNo - 1)*pageSize;
            page.setcPage(cPage);
            page.setPageSize(pageSize);
            list=UauthDao.getList(page,map);
        }else if(dropdownbox.contains("电子邮箱")){
            list=UauthDao.getEmailList(content);
        }else if(dropdownbox.contains("用户名")){
            list=UauthDao.getUserNameList(content);
        }else{
            list=UauthDao.getPhoneList(content);
        }
        return list;
    }

    @Override
    public void doUpdateUsername(String username, Integer id) {
        UauthDao.doUpdateUsername(username,id);
    }

    @Override
    public void doUpdateUcenterPhone(String phone, Integer id) {
        UauthDao.doUpdateUcenterPhone(phone,id);
    }

    @Override
    public void doUpdateEmail(String email, Integer id) {
        UauthDao.doUpdateEmail(email,id);
    }

    @Override
    public void doUpdatePassword(String password, Integer id) {
        UauthDao.doUpdatePassword(generate(password),id);
    }

    @Override
    public void uauthadd(Uauth uauth) {
        uauth.setPassword(generate(uauth.getPassword()));
        UauthDao.uauthadd(uauth);
    }

    @Override
    public void doUpdateContent(String content, Integer id) {
        UauthDao.doUpdateContent(content,id);
    }

    @Override
    public int getCount(String dropdownbox, String content) {
        int listCount;
        content="%" + content + "%";
        if(dropdownbox==null){
            listCount=UauthDao.getCount();
        }else if(dropdownbox.contains("电子邮箱")){
            listCount=UauthDao.getEmailCount(content);
        }else if(dropdownbox.contains("用户名")){
            listCount=UauthDao.getUsernameCount(content);
        }else{
            listCount=UauthDao.getPhoneCount(content);
        }
        return listCount;
    }
}
