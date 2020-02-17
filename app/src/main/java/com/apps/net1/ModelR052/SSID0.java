package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */



@Root(strict = false)
public class SSID0 {
    @Element(name = "ssid")
    String sSSID;
    @Element(name = "key")
    String sKey;

    public SSID0() {

    }

    @Override
    public String toString() {
        return "SSID0{" +
                "sSSID='" + sSSID + '\'' +
                ", sKey='" + sKey + '\'' +
                '}';
    }

    public String getsSSID() {
        return sSSID;
    }

    public void setsSSID(String sSSID) {
        this.sSSID = sSSID;
    }

    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }
}
