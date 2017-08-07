package com.mcylm.clay.service.normalservice.model;

import java.io.Serializable;

/**
 * Created by Mikesam on 2017/8/5.
 */
public class Label implements Serializable{

    private int id;
    private String key;
    private String label;
    private String type;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
