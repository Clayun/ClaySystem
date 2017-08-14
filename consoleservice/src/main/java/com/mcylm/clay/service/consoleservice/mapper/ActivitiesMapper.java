package com.mcylm.clay.service.consoleservice.mapper;

import com.mcylm.clay.service.consoleservice.model.Activities;
import com.mcylm.clay.service.consoleservice.model.ActivitiesStr;
import com.mcylm.clay.service.consoleservice.model.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by macbook on 2017/8/11.
 */
@Mapper
public interface ActivitiesMapper {

    /*@Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id")
    List<Activities> activitieslist();*/

    @Insert("insert into pre_activities_details(type,title,abstractInfo,content,num,startTime,overTime," +
            "managerName,state,selected) values(#{type},#{title},#{abstractInfo},#{content},#{num}," +
            "#{startTime},#{overTime},#{managerName},#{state},#{selected})")
    void activitiesAdd(ActivitiesStr activities);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id and a.id = #{id}")
    Activities toUpdateActivities(@Param("id") Integer id);

    @Update("update pre_activities_details set type=#{type},title=#{title},abstractInfo=#{abstractInfo}," +
            "content=#{content},num=#{num},startTime=#{startTime},overTime=#{overTime}," +
            "managerName=#{managerName},state=#{state},selected=#{selected} where id = #{id}")
    void activitiesUpdate(ActivitiesStr activities);

    @Select("select count(*) from pre_activities_details")
    int getCount();

    @Select("select count(*) from pre_activities_details where title like #{content}")
    int getCountTitle(String content);

    @Select("select count(*) from pre_activities_details where state like #{content}")
    int getCountState(String content);

    @Select("select count(*) from pre_activities_details where managerName like #{content}")
    int getCountmanagerName(String content);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id order by id limit #{page.cPage},#{page.pageSize}")
    List<Activities> activitieslist(@Param("page")Page page, Map<String, Object> map);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id and a.title like #{content} order by id")
    List<Activities> activitieslistTitle(String content);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id and a.state like #{content} order by id")
    List<Activities> activitieslistState(String content);

    @Select("select a.id,a.title,a.abstractInfo,a.content,a.num,a.startTime,a.overTime," +
            "a.managerName,b.type,c.state,d.selected FROM pre_activities_details a ," +
            "pre_activities_details_type b, pre_activities_details_state c, " +
            "pre_activities_details_selected d where a.type = b.id and " +
            "a.state = c.id and a.selected = d.id and a.managerName like #{content} order by id")
    List<Activities> activitieslistmanagerName(String content);
}
