package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 30/11/2018.
 */


@Root(strict = false)
public class ResponChangeSSID {
    @Element
    WirelessID wireless;

    public ResponChangeSSID(){

    }

    @Override
    public String toString() {
        return "ResponChangeSSID{" +
                "wireless=" + wireless +
                '}';
    }

    public WirelessID getWireless() {
        return wireless;
    }

    public void setWireless(WirelessID wireless) {
        this.wireless = wireless;
    }
}


