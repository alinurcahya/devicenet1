
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LTEParaGetRsp implements Parcelable
{

    @SerializedName("RspStatus")
    @Expose
    private String RspStatus;
    @SerializedName("MsgCode")
    @Expose
    private String MsgCode;
    @SerializedName("CMStatus")
    @Expose
    private String CMStatus;
    @SerializedName("RSRP")
    @Expose
    private String RSRP;
    @SerializedName("RSRQ")
    @Expose
    private String RSRQ;
    @SerializedName("RSSI")
    @Expose
    private String RSSI;
    @SerializedName("SINR")
    @Expose
    private String SINR;
    @SerializedName("SignalLevel")
    @Expose
    private int SignalLevel;
    public final static Parcelable.Creator<LTEParaGetRsp> CREATOR = new Creator<LTEParaGetRsp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LTEParaGetRsp createFromParcel(Parcel in) {
            LTEParaGetRsp instance = new LTEParaGetRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.CMStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.RSRP = ((String) in.readValue((String.class.getClassLoader())));
            instance.RSRQ = ((String) in.readValue((String.class.getClassLoader())));
            instance.RSSI = ((String) in.readValue((String.class.getClassLoader())));
            instance.SINR = ((String) in.readValue((String.class.getClassLoader())));
            instance.SignalLevel = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public LTEParaGetRsp[] newArray(int size) {
            return (new LTEParaGetRsp[size]);
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
     *     The CMStatus
     */
    public String getCMStatus() {
        return CMStatus;
    }

    /**
     * 
     * @param CMStatus
     *     The CMStatus
     */
    public void setCMStatus(String CMStatus) {
        this.CMStatus = CMStatus;
    }

    /**
     * 
     * @return
     *     The RSRP
     */
    public String getRSRP() {
        return RSRP;
    }

    /**
     * 
     * @param RSRP
     *     The RSRP
     */
    public void setRSRP(String RSRP) {
        this.RSRP = RSRP;
    }

    /**
     * 
     * @return
     *     The RSRQ
     */
    public String getRSRQ() {
        return RSRQ;
    }

    /**
     * 
     * @param RSRQ
     *     The RSRQ
     */
    public void setRSRQ(String RSRQ) {
        this.RSRQ = RSRQ;
    }

    /**
     * 
     * @return
     *     The RSSI
     */
    public String getRSSI() {
        return RSSI;
    }

    /**
     * 
     * @param RSSI
     *     The RSSI
     */
    public void setRSSI(String RSSI) {
        this.RSSI = RSSI;
    }

    /**
     * 
     * @return
     *     The SINR
     */
    public String getSINR() {
        return SINR;
    }

    /**
     * 
     * @param SINR
     *     The SINR
     */
    public void setSINR(String SINR) {
        this.SINR = SINR;
    }

    /**
     * 
     * @return
     *     The SignalLevel
     */
    public int getSignalLevel() {
        return SignalLevel;
    }

    /**
     * 
     * @param SignalLevel
     *     The SignalLevel
     */
    public void setSignalLevel(int SignalLevel) {
        this.SignalLevel = SignalLevel;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(CMStatus);
        dest.writeValue(RSRP);
        dest.writeValue(RSRQ);
        dest.writeValue(RSSI);
        dest.writeValue(SINR);
        dest.writeValue(SignalLevel);
    }

    public int describeContents() {
        return  0;
    }

}
