package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

@Root(strict = false)
public class WirelessID {
    @Element(name = "setting_response")
    String respon;

    public WirelessID() {

    }

    @Override
    public String toString() {
        return "WirelessID{" +
                "respon='" + respon + '\'' +
                '}';
    }

    public String getRespon() {
        return respon;
    }

    public void setRespon(String respon) {
        this.respon = respon;
    }
}
