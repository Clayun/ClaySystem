package com.mcylm.clay.service.openstackService.service.impl;

import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.dao.EcsDao;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageName;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsImageType;
import com.mcylm.clay.service.openstackService.model.ecsModel.EcsProduce;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.service.EcsService;
import com.mcylm.clay.service.openstackService.utils.Base64Utils;
import com.mcylm.clay.service.openstackService.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mikesam on 2017/8/9.
 */
@Service
public class EcsServiceImpl implements EcsService {

    @Autowired
    private EcsDao ecsDao;

    @Override
    public void testService() {

    }

    @Override
    public EcsProduce getEcsProduce() {
        return ecsDao.getEcsProduce();
    }

    @Override
    public List<EcsImageName> getEcsImageNameList(int typeId) {
        return ecsDao.getEcsImageNameList(typeId);
    }

    @Override
    public List<EcsImageType> getEcsImageTypeList() {
        return ecsDao.getEcsImageTypeList();
    }

    @Override
    public double getEcsPrice(String ecspz) {
        String[] pzs = ecspz.split(",");
        int cpu = Integer.valueOf(pzs[1]);
        int mem = Integer.valueOf(pzs[2]);
        int xtp = Integer.valueOf(pzs[3]);
        int tzp = Integer.valueOf(pzs[4]);
        int tape = Integer.valueOf(pzs[5]);
        int ip = Integer.valueOf(pzs[6]);

        double price = 0;
        price = ecsDao.getCorePriceByValue(cpu)
                +ecsDao.getMemoryPriceByValue(mem)
                +ecsDao.getOsDiskPriceByValue(xtp)
                +ecsDao.getExpandDiskPriceByValue(tzp)
                +ecsDao.getTapePriceByValue(tape)
                +ecsDao.getIpPriceByValue(ip);
        return price;
    }

    @Override
    public String toJsonEcsOrder(String ecspz, String image, String pwd) {
        Gson gson = new Gson();
        String[] pzs = ecspz.split(",");
        EcsServer ecsServer = new EcsServer();
        ecsServer.setCpu(pzs[1]);
        ecsServer.setMemory(pzs[2]);
        ecsServer.setOs_disk(pzs[3]);
        ecsServer.setExpand_disk(pzs[4]);
        ecsServer.setTape(pzs[5]);
        ecsServer.setIps(pzs[6]);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String str = dateFormat.format(date);
        ecsServer.setUuid(str+Utils.createUuid().toUpperCase());
        ecsServer.setSer_uuid(Utils.createUuid());
        ecsServer.setDays("0");
        ecsServer.setState("1");
        ecsServer.setPricePerMonth(String.valueOf(getEcsPrice(ecspz)));
        ecsServer.setCreateTime(new Date());
        ecsServer.setSer_name(Utils.createUuid());
        ecsServer.setImage(image);
        ecsServer.setPassword(pwd);
        return Base64Utils.encodeBase64String(gson.toJson(ecsServer));
    }
}
