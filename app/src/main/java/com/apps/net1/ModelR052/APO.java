package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

@Root(strict = false)
public class APO {
    @Element(name = "wifi_if_24G")
    WIFI24 wifi24;

    public APO() {

    }

    @Override
    public String toString() {
        return "APO{" +
                "wifi24=" + wifi24 +
                '}';
    }

    public WIFI24 getWifi24() {
        return wifi24;
    }

    public void setWifi24(WIFI24 wifi24) {
        this.wifi24 = wifi24;
    }
}
