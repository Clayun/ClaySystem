package com.mcylm.clay.service.openstackService.model.ecsModel;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsOsDisk {

    private int id;
    private int osdiskSize;
    private double price;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOsdiskSize() {
        return osdiskSize;
    }

    public void setOsdiskSize(int osdiskSize) {
        this.osdiskSize = osdiskSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
