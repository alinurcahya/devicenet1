package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */

@Root(strict = false)
public class ResponSSID {

    @Element(name = "wireless")
    Wireless wireless;

    public ResponSSID() {

    }

    @Override
    public String toString() {
        return "ResponSSID{" +
                "wireless=" + wireless +
                '}';
    }

    public Wireless getWireless() {
        return wireless;
    }

    public void setWireless(Wireless wireless) {
        this.wireless = wireless;
    }
}

