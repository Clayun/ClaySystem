package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Account;

import java.util.List;
import java.util.Map;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/14/014
 * @Modified By:None one
 */
public interface AccountDao {

    List<Account> getaccountlist(Map<String,Object> map);

    void ucenteradd(Account account);

    void accountupdate(Account account);

    void accountdel(Integer id);
}
