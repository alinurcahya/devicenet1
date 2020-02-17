package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

@Root(strict = false)
public class CellularInfo {
    @Element(name = "IMSI")
    String sIMSI;

    @Element(name = "sys_mode")
    int sSysMode;

    @Element(name = "data_mode")
    int sDataMode;

    @Element(name = "rssi")
    int sRSSI;

    public CellularInfo() {

    }

    @Override
    public String toString() {
        return "CellularInfo{" +
                "sIMSI='" + sIMSI + '\'' +
                ", sSysMode='" + sSysMode + '\'' +
                ", sDataMode='" + sDataMode + '\'' +
                ", sRSSI='" + sRSSI + '\'' +
                '}';
    }

    public String getsIMSI() {
        return sIMSI;
    }

    public void setsIMSI(String sIMSI) {
        this.sIMSI = sIMSI;
    }

    public int getsSysMode() {
        return sSysMode;
    }

    public void setsSysMode(int sSysMode) {
        this.sSysMode = sSysMode;
    }

    public int getsDataMode() {
        return sDataMode;
    }

    public void setsDataMode(int sDataMode) {
        this.sDataMode = sDataMode;
    }

    public int getsRSSI() {
        return sRSSI;
    }

    public void setsRSSI(int sRSSI) {
        this.sRSSI = sRSSI;
    }
}

