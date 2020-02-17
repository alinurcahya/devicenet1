package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

@Root(strict = false)
public class WIFI24 {
    @Element(name = "ssid0")
    SSID0 ssid0;

    public WIFI24() {
    }

    @Override
    public String toString() {
        return "WIFI24{" +
                "ssid0=" + ssid0 +
                '}';
    }

    public SSID0 getSsid0() {
        return ssid0;
    }

    public void setSsid0(SSID0 ssid0) {
        this.ssid0 = ssid0;
    }
}
