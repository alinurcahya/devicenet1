package com.apps.net1.ModelM20;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 19/01/2019.
 */


@Root(strict = false)
public class ResponSWVerM20 {

    public ResponSWVerM20(){

    }

    @Element(name="FwVer", required=false)
    String fwVer;

    @Element(name="rej_cause", required=false)
    String rejCause;

    @Element(name="LteVer", required=false)
    String lteVer;

    @Element(name="upday", required=false)
    String upday;

    @Element(name="srv_status", required=false)
    String srvStatus;

    @Element(name="CMState", required=false)
    String cMState;

    @Element(name="Uicc_status", required=false)
    String uiccStatus;

    @Element(name="RatType", required=false)
    String ratType;

    @Element(name="upmin", required=false)
    String upmin;

    @Element(name="Uicc_Pin_status", required=false)
    String uiccPinStatus;

    @Element(name="Model", required=false)
    String model;

    @Element(name="upsecs", required=false)
    String upsecs;

    @Element(name="msisdn", required=false)
    String msisdn;

    @Element(name="uphour", required=false)
    String uphour;

    @Element(name="Uicc_state", required=false)
    String uiccState;

    public String getFwVer() {return this.fwVer;}
    public void setFwVer(String value) {this.fwVer = value;}

    public String getRejCause() {return this.rejCause;}
    public void setRejCause(String value) {this.rejCause = value;}

    public String getLteVer() {return this.lteVer;}
    public void setLteVer(String value) {this.lteVer = value;}

    public String getUpday() {return this.upday;}
    public void setUpday(String value) {this.upday = value;}

    public String getSrvStatus() {return this.srvStatus;}
    public void setSrvStatus(String value) {this.srvStatus = value;}

    public String getCMState() {return this.cMState;}
    public void setCMState(String value) {this.cMState = value;}

    public String getUiccStatus() {return this.uiccStatus;}
    public void setUiccStatus(String value) {this.uiccStatus = value;}

    public String getRatType() {return this.ratType;}
    public void setRatType(String value) {this.ratType = value;}

    public String getUpmin() {return this.upmin;}
    public void setUpmin(String value) {this.upmin = value;}

    public String getUiccPinStatus() {return this.uiccPinStatus;}
    public void setUiccPinStatus(String value) {this.uiccPinStatus = value;}

    public String getModel() {return this.model;}
    public void setModel(String value) {this.model = value;}

    public String getUpsecs() {return this.upsecs;}
    public void setUpsecs(String value) {this.upsecs = value;}

    public String getMsisdn() {return this.msisdn;}
    public void setMsisdn(String value) {this.msisdn = value;}

    public String getUphour() {return this.uphour;}
    public void setUphour(String value) {this.uphour = value;}

    public String getUiccState() {return this.uiccState;}
    public void setUiccState(String value) {this.uiccState = value;}

}
