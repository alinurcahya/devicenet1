package com.apps.net1.ModelR052;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(strict = false)
public class VersionInfo {
    @Element(name = "sw_version")
    String swVersion;
    @Element(name = "version_num")
    String sVersionNum;
    @Element(name = "mac_addr")
    String sMac;

    public VersionInfo() {

    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "swVersion='" + swVersion + '\'' +
                ", sVersionNum='" + sVersionNum + '\'' +
                ", sMac='" + sMac + '\'' +
                '}';
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    public String getsVersionNum() {
        return sVersionNum;
    }

    public void setsVersionNum(String sVersionNum) {
        this.sVersionNum = sVersionNum;
    }

    public String getsMac() {
        return sMac;
    }

    public void setsMac(String sMac) {
        this.sMac = sMac;
    }
}