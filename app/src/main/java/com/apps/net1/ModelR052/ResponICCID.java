package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 30/11/2018.
 */

@Root(strict = false)
public class ResponICCID {
    @Element(name = "iccid")
    String sICCID;

    public ResponICCID() {

    }

    @Override
    public String toString() {
        return "ResponICCID{" +
                "sICCID='" + sICCID + '\'' +
                '}';
    }

    public String getsICCID() {
        return sICCID;
    }

    public void setsICCID(String sICCID) {
        this.sICCID = sICCID;
    }
}
