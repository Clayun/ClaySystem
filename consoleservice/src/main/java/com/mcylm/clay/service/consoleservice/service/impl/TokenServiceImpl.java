package com.mcylm.clay.service.consoleservice.service.impl;

import com.mcylm.clay.service.consoleservice.dao.TokenDao;
import com.mcylm.clay.service.consoleservice.model.Orders;
import com.mcylm.clay.service.consoleservice.model.Token;
import com.mcylm.clay.service.consoleservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/17/017
 * @Modified By:None one
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public List<Token> getOrderList() {
        List<Token> list=tokenDao.getOrderList();
        return list;
    }
}