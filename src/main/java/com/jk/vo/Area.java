package com.jk.vo;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/6/16.
 */
public class Area implements Serializable {

    private int areaID;
    private String areaName;

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
