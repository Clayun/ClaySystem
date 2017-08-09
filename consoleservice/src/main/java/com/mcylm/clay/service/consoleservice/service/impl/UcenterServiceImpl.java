package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.UcenterDao;
import com.mcylm.clay.service.consoleservice.model.Page;
import com.mcylm.clay.service.consoleservice.model.Ucenter;
import com.mcylm.clay.service.consoleservice.service.UcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.mcylm.clay.service.consoleservice.MD5Util.generate;

/**
 * Created by Mr_Shen on 2017/8/7/007.
 */
@Service
public class UcenterServiceImpl implements UcenterService{

    @Autowired
    private UcenterDao ucenterDao;


    @Override
    public List<Ucenter> getList(Integer pageNo,Integer pageSize,Map<String, Object> map) {
        Page page=new Page();
        int cPage=(pageNo - 1)*pageSize;
        page.setcPage(cPage);
        page.setPageSize(pageSize);
        List<Ucenter> list=ucenterDao.getList(page,map);
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
    public int getCount() {
        int listCount=ucenterDao.getCount();
        return listCount;
    }
}