package com.mcylm.clay.service.openstackService.model.ecsModel;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsCpu {
    private int id;
    private int coreNum;
    private double price;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) {
        this.coreNum = coreNum;
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
