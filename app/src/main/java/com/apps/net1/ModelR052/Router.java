package com.apps.net1.ModelR052;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Router{
    @Element(name = "lan_ip") String sIP;

    public Router(){

    }

    public String getsIP() {
        return sIP;
    }

    public void setsIP(String sIP) {
        this.sIP = sIP;
    }

    @Override
    public String toString() {
        return "Router{" +
                "sIP='" + sIP + '\'' +
                '}';
    }
}
