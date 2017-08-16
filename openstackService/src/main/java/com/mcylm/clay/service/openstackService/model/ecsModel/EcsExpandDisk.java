package com.mcylm.clay.service.openstackService.model.ecsModel;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsExpandDisk {

    private int id;
    private int expanddiskSize;
    private double price;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpanddiskSize() {
        return expanddiskSize;
    }

    public void setExpanddiskSize(int expanddiskSize) {
        this.expanddiskSize = expanddiskSize;
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
