package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.LoginDao;
import com.mcylm.clay.service.consoleservice.model.Login;
import com.mcylm.clay.service.consoleservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/24/024
 * @Modified By:None one
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Login tologin(Login login) {
        Login LoginMessage= loginDao.tologin(login);
        return LoginMessage;
    }

}
