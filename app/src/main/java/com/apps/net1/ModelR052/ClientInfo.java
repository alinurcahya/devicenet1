package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */


@Root(name = "one_client", strict = false)
public class ClientInfo {
    @Element(name = "name")
    String sName;

    public ClientInfo() {

    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "sName='" + sName + '\'' +
                '}';
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
