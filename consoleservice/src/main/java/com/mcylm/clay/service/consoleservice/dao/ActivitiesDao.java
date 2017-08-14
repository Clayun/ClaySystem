package com.mcylm.clay.service.consoleservice.dao;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.model.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
public interface ActivitiesDao {

    void activitiesAdd(ActivitiesStr activities);

    Activities toUpdateActivities(Integer id);

    void activitiesUpdate(ActivitiesStr activities);

    int getCount();

    int getCountTitle(String content);

    int getCountState(String content);

    int getCountmanagerName(String content);

    List<Activities> activitieslist(Page page, Map<String, Object> map);

    List<Activities> activitieslistTitle(String content);

    List<Activities> activitieslistState(String content);

    List<Activities> activitieslistmanagerName(String content);
}
