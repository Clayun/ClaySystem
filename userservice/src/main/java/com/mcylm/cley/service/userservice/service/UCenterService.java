package com.mcylm.cley.service.userservice.service;

import com.mcylm.cley.service.userservice.entity.UcenterD;
import java.io.Serializable;
import java.util.List;

public interface UCenterService{
    List<UcenterD> getUserList();

    UcenterD updateUser(UcenterD user);
}
