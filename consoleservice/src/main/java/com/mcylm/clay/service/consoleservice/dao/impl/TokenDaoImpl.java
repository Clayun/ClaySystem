package com.mcylm.clay.service.consoleservice.dao.impl;

import com.mcylm.clay.service.consoleservice.dao.TokenDao;
import com.mcylm.clay.service.consoleservice.mapper.TokenMapper;
import com.mcylm.clay.service.consoleservice.model.Orders;
import com.mcylm.clay.service.consoleservice.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Mr_Shen
 * @Description: - -!
 * @Date:2017/8/17/017
 * @Modified By:None one
 */
@Repository
public class TokenDaoImpl implements TokenDao{

    @Autowired
    private TokenMapper tokenMapper;


    @Override
    public List<Token> getOrderList() {
        List<Token> list=tokenMapper.getOrderList();
        return list;
    }
}