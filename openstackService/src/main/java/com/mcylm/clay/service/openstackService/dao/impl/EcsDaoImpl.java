package com.mcylm.clay.service.openstackService.dao.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.dao.EcsDao;
import com.mcylm.clay.service.openstackService.dao.RedisDao;
import com.mcylm.clay.service.openstackService.mapper.EcsMapper;
import com.mcylm.clay.service.openstackService.model.ecsModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/9.
 */
@Repository
public class EcsDaoImpl implements EcsDao {

    @Autowired
    private EcsMapper ecsMapper;

    @Autowired
    private RedisDao redisDao;

//    @Override
//    public EcsProduce getEcsProduce() {
//        Gson gson = new Gson();
//        EcsProduce ecsProduce = new EcsProduce();
//        String json = null;
//        json = redisDao.getValue("EcsProduce");
//        if(json == null || json == ""){
//            ecsProduce.setEcsCpuList(ecsMapper.getEcsCpuList());
//            ecsProduce.setEcsExpandDiskList(ecsMapper.getEcsExpandDiskList());
//            ecsProduce.setEcsIpList(ecsMapper.getEcsIpList());
//            ecsProduce.setEcsMemoryList(ecsMapper.getEcsMemoryList());
//            ecsProduce.setEcsOsDiskList(ecsMapper.getEcsOsDiskList());
//            ecsProduce.setEcsTapeList(ecsMapper.getEcsTapeList());
//            json = gson.toJson(ecsProduce);
//            redisDao.setKey("EcsProduce",json);
//            return ecsProduce;
//        }
//        ecsProduce = gson.fromJson(json,EcsProduce.class);
//        return ecsProduce;
//    }

    @Override
    public EcsProduce getEcsProduce() {
        Gson gson = new Gson();
        EcsProduce ecsProduce = new EcsProduce();
        ecsProduce.setEcsCpuList(ecsMapper.getEcsCpuList());
        ecsProduce.setEcsExpandDiskList(ecsMapper.getEcsExpandDiskList());
        ecsProduce.setEcsIpList(ecsMapper.getEcsIpList());
        ecsProduce.setEcsMemoryList(ecsMapper.getEcsMemoryList());
        ecsProduce.setEcsOsDiskList(ecsMapper.getEcsOsDiskList());
        ecsProduce.setEcsTapeList(ecsMapper.getEcsTapeList());
        return ecsProduce;
    }

    @Override
    public List<EcsImageName> getEcsImageNameList(int typeId) {
        return ecsMapper.getEcsImageNameList(typeId);
    }


    @Override
    public List<EcsImageType> getEcsImageTypeList() {
        return ecsMapper.getEcsImageTypeList();
    }

    @Override
    public double getCorePriceByValue(int size) {
        return ecsMapper.getCorePriceByValue(size);
    }

    @Override
    public double getExpandDiskPriceByValue(int size) {
        return ecsMapper.getExpandDiskPriceByValue(size);
    }

    @Override
    public double getIpPriceByValue(int size) {
        return ecsMapper.getIpPriceByValue(size);
    }

    @Override
    public double getMemoryPriceByValue(int size) {
        return ecsMapper.getMemoryPriceByValue(size);
    }

    @Override
    public double getOsDiskPriceByValue(int size) {
        return ecsMapper.getOsDiskPriceByValue(size);
    }

    @Override
    public double getTapePriceByValue(int size) {
        return 0;
    }
}
