package com.mcylm.clay.service.openstackService.model.ecsModel;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsImageType {

    private int id;
    private String osType;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
