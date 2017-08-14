package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.AccountDao;
import com.mcylm.clay.service.consoleservice.mapper.AccountMapper;
import com.mcylm.clay.service.consoleservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getaccountlist(Map<String,Object> map) {
        List<Account> list=accountMapper.getaccountlist(map);
        return list;
    }

}