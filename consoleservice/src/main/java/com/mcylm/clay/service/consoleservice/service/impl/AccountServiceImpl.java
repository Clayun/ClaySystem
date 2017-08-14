package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.AccountDao;
import com.mcylm.clay.service.consoleservice.model.Account;
import com.mcylm.clay.service.consoleservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getaccountlist(Map<String,Object> map){
        List<Account> list=accountDao.getaccountlist(map);
        return list;
    }

    @Override
    public void ucenteradd(Account account) {
        accountDao.ucenteradd(account);
    }

    @Override
    public void accountupdate(Account account) {
        accountDao.accountupdate(account);
    }

    @Override
    public void accountdel(Integer id) {
        accountDao.accountdel(id);
    }

}