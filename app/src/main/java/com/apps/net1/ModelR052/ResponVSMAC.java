package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 30/11/2018.
 */

@Root(strict = false)
public class ResponVSMAC {
    @Element(name = "version_info")
    VersionInfo versionInfo;

    public ResponVSMAC() {

    }

    @Override
    public String toString() {
        return "ResponVSMAC{" +
                "versionInfo=" + versionInfo +
                '}';
    }

    public VersionInfo getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(VersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }
}


