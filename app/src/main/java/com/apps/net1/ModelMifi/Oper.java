package com.apps.net1.ModelMifi;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

public class Oper {
    StatusGetReq StatusGetReq;

    WirelessGenericConfReq WirelessGenericConfReq;

    RemoteUpgradeConfReq RemoteUpgradeConfReq;

    public Oper(RemoteUpgradeConfReq w){
        this.RemoteUpgradeConfReq = w;
    }

    public Oper(WirelessGenericConfReq w){
        this.WirelessGenericConfReq = w;
    }

    public Oper(StatusGetReq sgr) {
        this.StatusGetReq = sgr;
    }
}
