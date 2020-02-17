package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

@Root(strict = false)
public class Wireless {
    @Element(name = "AP0")
    APO apo;

    public Wireless() {

    }

    @Override
    public String toString() {
        return "Wireless{" +
                "apo=" + apo +
                '}';
    }

    public APO getApo() {
        return apo;
    }

    public void setApo(APO apo) {
        this.apo = apo;
    }
}
