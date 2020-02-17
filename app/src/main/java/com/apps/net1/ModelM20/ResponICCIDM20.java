package com.apps.net1.ModelM20;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 19/01/2019.
 */

@Root(strict = false)
public class ResponICCIDM20 {

    @Override
    public String toString() {
        return "ResponICCIDM20{" +
                "esmCauseStr='" + esmCauseStr + '\'' +
                ", earfcnDl='" + earfcnDl + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", rAT='" + rAT + '\'' +
                ", regiStatus='" + regiStatus + '\'' +
                ", emmStatusStr='" + emmStatusStr + '\'' +
                ", rfIsUpdate='" + rfIsUpdate + '\'' +
                ", rsrp='" + rsrp + '\'' +
                ", mcc='" + mcc + '\'' +
                ", arfcn='" + arfcn + '\'' +
                ", emmCauseStr='" + emmCauseStr + '\'' +
                ", uiccid='" + uiccid + '\'' +
                ", globalCellId='" + globalCellId + '\'' +
                ", uiccPinStatus='" + uiccPinStatus + '\'' +
                ", earfcnUl='" + earfcnUl + '\'' +
                ", mEID='" + mEID + '\'' +
                ", tac='" + tac + '\'' +
                ", emmState='" + emmState + '\'' +
                ", rrcState='" + rrcState + '\'' +
                ", serviceDomain='" + serviceDomain + '\'' +
                ", uiccStatus='" + uiccStatus + '\'' +
                ", rejectCause='" + rejectCause + '\'' +
                ", drx='" + drx + '\'' +
                ", cmState='" + cmState + '\'' +
                ", sinr='" + sinr + '\'' +
                ", rrcStateStr='" + rrcStateStr + '\'' +
                ", tmsi='" + tmsi + '\'' +
                ", psc='" + psc + '\'' +
                ", uiccPinNumPuk='" + uiccPinNumPuk + '\'' +
                ", mSISDN='" + mSISDN + '\'' +
                ", netItf='" + netItf + '\'' +
                ", srvStatus='" + srvStatus + '\'' +
                ", cellid='" + cellid + '\'' +
                ", emmSubstate='" + emmSubstate + '\'' +
                ", uiccType='" + uiccType + '\'' +
                ", pci='" + pci + '\'' +
                ", iMSI='" + iMSI + '\'' +
                ", rscp='" + rscp + '\'' +
                ", earfcn='" + earfcn + '\'' +
                ", eSN='" + eSN + '\'' +
                ", rssi='" + rssi + '\'' +
                ", fwVer='" + fwVer + '\'' +
                ", mnc='" + mnc + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", txPower='" + txPower + '\'' +
                ", ci='" + ci + '\'' +
                ", iMEI='" + iMEI + '\'' +
                ", vendor='" + vendor + '\'' +
                ", ecno='" + ecno + '\'' +
                ", rsrq='" + rsrq + '\'' +
                ", model='" + model + '\'' +
                ", uiccPinNumPin='" + uiccPinNumPin + '\'' +
                '}';
    }

    public ResponICCIDM20(){

    }

    @Element(name="esm_cause_str", required=false)
    String esmCauseStr;

    @Element(name="earfcn_dl", required=false)
    String earfcnDl;

    @Element(name="IpAddr", required=false)
    String ipAddr;

    @Element(name="RAT", required=false)
    String rAT;

    @Element(name="RegiStatus", required=false)
    String regiStatus;

    @Element(name="emm_status_str", required=false)
    String emmStatusStr;

    @Element(name="Rf_isUpdate", required=false)
    String rfIsUpdate;

    @Element(name="rsrp", required=false)
    String rsrp;

    @Element(name="mcc", required=false)
    String mcc;

    @Element(name="arfcn", required=false)
    String arfcn;

    @Element(name="emm_cause_str", required=false)
    String emmCauseStr;

    @Element(name="uiccid")
    String uiccid;

    @Element(name="GlobalCellId", required=false)
    String globalCellId;

    @Element(name="Uicc_Pin_status", required=false)
    String uiccPinStatus;

    @Element(name="earfcn_ul", required=false)
    String earfcnUl;

    @Element(name="MEID", required=false)
    String mEID;

    @Element(name="tac", required=false)
    String tac;

    @Element(name="emm_state", required=false)
    String emmState;

    @Element(name="rrc_state", required=false)
    String rrcState;

    @Element(name="service_domain", required=false)
    String serviceDomain;

    @Element(name="Uicc_status", required=false)
    String uiccStatus;

    @Element(name="reject_cause", required=false)
    String rejectCause;

    @Element(name="drx", required=false)
    String drx;

    @Element(name="CmState", required=false)
    String cmState;

    @Element(name="sinr", required=false)
    String sinr;

    @Element(name="rrc_state_str", required=false)
    String rrcStateStr;

    @Element(name="tmsi", required=false)
    String tmsi;

    @Element(name="psc", required=false)
    String psc;

    @Element(name="Uicc_Pin_num_puk", required=false)
    String uiccPinNumPuk;

    @Element(name="MSISDN", required=false)
    String mSISDN;

    @Element(name="netItf", required=false)
    String netItf;

    @Element(name="srv_status", required=false)
    String srvStatus;

    @Element(name="cellid", required=false)
    String cellid;

    @Element(name="emm_substate", required=false)
    String emmSubstate;

    @Element(name="UiccType", required=false)
    String uiccType;

    @Element(name="pci", required=false)
    String pci;

    @Element(name="IMSI")
    String iMSI;

    @Element(name="rscp", required=false)
    String rscp;

    @Element(name="earfcn", required=false)
    String earfcn;

    @Element(name="ESN", required=false)
    String eSN;

    @Element(name="rssi", required=false)
    String rssi;

    @Element(name="FwVer", required=false)
    String fwVer;

    @Element(name="mnc", required=false)
    String mnc;

    @Element(name="bandwidth", required=false)
    String bandwidth;

    @Element(name="tx_power", required=false)
    String txPower;

    @Element(name="ci", required=false)
    String ci;

    @Element(name="IMEI", required=false)
    String iMEI;

    @Element(name="Vendor", required=false)
    String vendor;

    @Element(name="ecno", required=false)
    String ecno;

    @Element(name="rsrq", required=false)
    String rsrq;

    @Element(name="Model", required=false)
    String model;

    @Element(name="Uicc_Pin_num_pin", required=false)
    String uiccPinNumPin;

    public String getEsmCauseStr() {return this.esmCauseStr;}
    public void setEsmCauseStr(String value) {this.esmCauseStr = value;}

    public String getEarfcnDl() {return this.earfcnDl;}
    public void setEarfcnDl(String value) {this.earfcnDl = value;}

    public String getIpAddr() {return this.ipAddr;}
    public void setIpAddr(String value) {this.ipAddr = value;}

    public String getRAT() {return this.rAT;}
    public void setRAT(String value) {this.rAT = value;}

    public String getRegiStatus() {return this.regiStatus;}
    public void setRegiStatus(String value) {this.regiStatus = value;}

    public String getEmmStatusStr() {return this.emmStatusStr;}
    public void setEmmStatusStr(String value) {this.emmStatusStr = value;}

    public String getRfIsUpdate() {return this.rfIsUpdate;}
    public void setRfIsUpdate(String value) {this.rfIsUpdate = value;}

    public String getRsrp() {return this.rsrp;}
    public void setRsrp(String value) {this.rsrp = value;}

    public String getMcc() {return this.mcc;}
    public void setMcc(String value) {this.mcc = value;}

    public String getArfcn() {return this.arfcn;}
    public void setArfcn(String value) {this.arfcn = value;}

    public String getEmmCauseStr() {return this.emmCauseStr;}
    public void setEmmCauseStr(String value) {this.emmCauseStr = value;}

    public String getUiccid() {return this.uiccid;}
    public void setUiccid(String value) {this.uiccid = value;}

    public String getGlobalCellId() {return this.globalCellId;}
    public void setGlobalCellId(String value) {this.globalCellId = value;}

    public String getUiccPinStatus() {return this.uiccPinStatus;}
    public void setUiccPinStatus(String value) {this.uiccPinStatus = value;}

    public String getEarfcnUl() {return this.earfcnUl;}
    public void setEarfcnUl(String value) {this.earfcnUl = value;}

    public String getMEID() {return this.mEID;}
    public void setMEID(String value) {this.mEID = value;}

    public String getTac() {return this.tac;}
    public void setTac(String value) {this.tac = value;}

    public String getEmmState() {return this.emmState;}
    public void setEmmState(String value) {this.emmState = value;}

    public String getRrcState() {return this.rrcState;}
    public void setRrcState(String value) {this.rrcState = value;}

    public String getServiceDomain() {return this.serviceDomain;}
    public void setServiceDomain(String value) {this.serviceDomain = value;}

    public String getUiccStatus() {return this.uiccStatus;}
    public void setUiccStatus(String value) {this.uiccStatus = value;}

    public String getRejectCause() {return this.rejectCause;}
    public void setRejectCause(String value) {this.rejectCause = value;}

    public String getDrx() {return this.drx;}
    public void setDrx(String value) {this.drx = value;}

    public String getCmState() {return this.cmState;}
    public void setCmState(String value) {this.cmState = value;}

    public String getSinr() {return this.sinr;}
    public void setSinr(String value) {this.sinr = value;}

    public String getRrcStateStr() {return this.rrcStateStr;}
    public void setRrcStateStr(String value) {this.rrcStateStr = value;}

    public String getTmsi() {return this.tmsi;}
    public void setTmsi(String value) {this.tmsi = value;}

    public String getPsc() {return this.psc;}
    public void setPsc(String value) {this.psc = value;}

    public String getUiccPinNumPuk() {return this.uiccPinNumPuk;}
    public void setUiccPinNumPuk(String value) {this.uiccPinNumPuk = value;}

    public String getMSISDN() {return this.mSISDN;}
    public void setMSISDN(String value) {this.mSISDN = value;}

    public String getNetItf() {return this.netItf;}
    public void setNetItf(String value) {this.netItf = value;}

    public String getSrvStatus() {return this.srvStatus;}
    public void setSrvStatus(String value) {this.srvStatus = value;}

    public String getCellid() {return this.cellid;}
    public void setCellid(String value) {this.cellid = value;}

    public String getEmmSubstate() {return this.emmSubstate;}
    public void setEmmSubstate(String value) {this.emmSubstate = value;}

    public String getUiccType() {return this.uiccType;}
    public void setUiccType(String value) {this.uiccType = value;}

    public String getPci() {return this.pci;}
    public void setPci(String value) {this.pci = value;}

    public String getIMSI() {return this.iMSI;}
    public void setIMSI(String value) {this.iMSI = value;}

    public String getRscp() {return this.rscp;}
    public void setRscp(String value) {this.rscp = value;}

    public String getEarfcn() {return this.earfcn;}
    public void setEarfcn(String value) {this.earfcn = value;}

    public String getESN() {return this.eSN;}
    public void setESN(String value) {this.eSN = value;}

    public String getRssi() {return this.rssi;}
    public void setRssi(String value) {this.rssi = value;}

    public String getFwVer() {return this.fwVer;}
    public void setFwVer(String value) {this.fwVer = value;}

    public String getMnc() {return this.mnc;}
    public void setMnc(String value) {this.mnc = value;}

    public String getBandwidth() {return this.bandwidth;}
    public void setBandwidth(String value) {this.bandwidth = value;}

    public String getTxPower() {return this.txPower;}
    public void setTxPower(String value) {this.txPower = value;}

    public String getCi() {return this.ci;}
    public void setCi(String value) {this.ci = value;}

    public String getIMEI() {return this.iMEI;}
    public void setIMEI(String value) {this.iMEI = value;}

    public String getVendor() {return this.vendor;}
    public void setVendor(String value) {this.vendor = value;}

    public String getEcno() {return this.ecno;}
    public void setEcno(String value) {this.ecno = value;}

    public String getRsrq() {return this.rsrq;}
    public void setRsrq(String value) {this.rsrq = value;}

    public String getModel() {return this.model;}
    public void setModel(String value) {this.model = value;}

    public String getUiccPinNumPin() {return this.uiccPinNumPin;}
    public void setUiccPinNumPin(String value) {this.uiccPinNumPin = value;}

}
