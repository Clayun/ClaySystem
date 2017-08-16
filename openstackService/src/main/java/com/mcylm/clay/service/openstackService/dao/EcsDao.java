package com.mcylm.clay.service.openstackService.dao;

import com.mcylm.clay.service.openstackService.model.ecsModel.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/9.
 */
public interface EcsDao {

    EcsProduce getEcsProduce();

    List<EcsImageName> getEcsImageNameList(int typeId);

    List<EcsImageType> getEcsImageTypeList();

    double getCorePriceByValue(int size);

    double getExpandDiskPriceByValue(int size);

    double getIpPriceByValue(int size);

    double getMemoryPriceByValue(int size);

    double getOsDiskPriceByValue(int size);

    double getTapePriceByValue(int size);
}
