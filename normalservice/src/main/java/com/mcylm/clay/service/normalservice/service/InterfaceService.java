package com.mcylm.clay.service.normalservice.service;

import com.mcylm.clay.service.normalservice.model.Label;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/5.
 */
public interface InterfaceService {

    Label selectLabelByKey(String key,List<Label> list);

    List<Label> selectLabelsByPage(String page);

}
