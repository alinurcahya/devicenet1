
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceInfoRsp implements Parcelable
{

    @SerializedName("RspStatus")
    @Expose
    private String RspStatus;
    @SerializedName("MsgCode")
    @Expose
    private String MsgCode;
    @SerializedName("SoftwareVer")
    @Expose
    private String SoftwareVer;
    @SerializedName("WiFiMAC")
    @Expose
    private String WiFiMAC;
    @SerializedName("LTEIMEI")
    @Expose
    private String LTEIMEI;
    @SerializedName("LTEIMSI")
    @Expose
    private String LTEIMSI;
    @SerializedName("UICCID")
    @Expose
    private String UICCID;
    public final static Parcelable.Creator<DeviceInfoRsp> CREATOR = new Creator<DeviceInfoRsp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DeviceInfoRsp createFromParcel(Parcel in) {
            DeviceInfoRsp instance = new DeviceInfoRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.SoftwareVer = ((String) in.readValue((String.class.getClassLoader())));
            instance.WiFiMAC = ((String) in.readValue((String.class.getClassLoader())));
            instance.LTEIMEI = ((String) in.readValue((String.class.getClassLoader())));
            instance.LTEIMSI = ((String) in.readValue((String.class.getClassLoader())));
            instance.UICCID = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public DeviceInfoRsp[] newArray(int size) {
            return (new DeviceInfoRsp[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The RspStatus
     */
    public String getRspStatus() {
        return RspStatus;
    }

    /**
     * 
     * @param RspStatus
     *     The RspStatus
     */
    public void setRspStatus(String RspStatus) {
        this.RspStatus = RspStatus;
    }

    /**
     * 
     * @return
     *     The MsgCode
     */
    public String getMsgCode() {
        return MsgCode;
    }

    /**
     * 
     * @param MsgCode
     *     The MsgCode
     */
    public void setMsgCode(String MsgCode) {
        this.MsgCode = MsgCode;
    }

    /**
     * 
     * @return
     *     The SoftwareVer
     */
    public String getSoftwareVer() {
        return SoftwareVer;
    }

    /**
     * 
     * @param SoftwareVer
     *     The SoftwareVer
     */
    public void setSoftwareVer(String SoftwareVer) {
        this.SoftwareVer = SoftwareVer;
    }

    /**
     * 
     * @return
     *     The WiFiMAC
     */
    public String getWiFiMAC() {
        return WiFiMAC;
    }

    /**
     * 
     * @param WiFiMAC
     *     The WiFiMAC
     */
    public void setWiFiMAC(String WiFiMAC) {
        this.WiFiMAC = WiFiMAC;
    }

    /**
     * 
     * @return
     *     The LTEIMEI
     */
    public String getLTEIMEI() {
        return LTEIMEI;
    }

    /**
     * 
     * @param LTEIMEI
     *     The LTEIMEI
     */
    public void setLTEIMEI(String LTEIMEI) {
        this.LTEIMEI = LTEIMEI;
    }

    /**
     * 
     * @return
     *     The LTEIMSI
     */
    public String getLTEIMSI() {
        return LTEIMSI;
    }

    /**
     * 
     * @param LTEIMSI
     *     The LTEIMSI
     */
    public void setLTEIMSI(String LTEIMSI) {
        this.LTEIMSI = LTEIMSI;
    }

    /**
     * 
     * @return
     *     The UICCID
     */
    public String getUICCID() {
        return UICCID;
    }

    /**
     * 
     * @param UICCID
     *     The UICCID
     */
    public void setUICCID(String UICCID) {
        this.UICCID = UICCID;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(SoftwareVer);
        dest.writeValue(WiFiMAC);
        dest.writeValue(LTEIMEI);
        dest.writeValue(LTEIMSI);
        dest.writeValue(UICCID);
    }

    public int describeContents() {
        return  0;
    }

}
