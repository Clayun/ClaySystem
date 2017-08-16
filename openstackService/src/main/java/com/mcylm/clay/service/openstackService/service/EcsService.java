package com.mcylm.clay.service.openstackService.service;


import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageName;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageType;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsProduce;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/9.
 */
public interface EcsService {

    void testService();

    EcsProduce getEcsProduce();

    List<EcsImageName> getEcsImageNameList(int typeId);

    List<EcsImageType> getEcsImageTypeList();

    double getEcsPrice(String ecspz);

    String toJsonEcsOrder(String ecspz,String image,String pwd);
}
