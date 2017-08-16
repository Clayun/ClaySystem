package com.mcylm.cley.service.userservice.dao;

import com.mcylm.cley.service.userservice.entity.UcenterD;

import java.io.Serializable;
import java.util.List;

public interface UcenterDDao{

    List<UcenterD> getUserList();

    UcenterD updateUser(UcenterD user);
}
