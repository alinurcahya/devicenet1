package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WirelessGenericConfRsp implements Parcelable {

    public final static Parcelable.Creator<WirelessGenericConfRsp> CREATOR = new Creator<WirelessGenericConfRsp>() {


        @SuppressWarnings({
                "unchecked"
        })
        public WirelessGenericConfRsp createFromParcel(Parcel in) {
            WirelessGenericConfRsp instance = new WirelessGenericConfRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Oper = ((String) in.readValue((String.class.getClassLoader())));
            instance.GetGenericConf = ((com.apps.net1.ModelMifi.GetGenericConf) in.readValue((GetGenericConf.class.getClassLoader())));
            return instance;
        }

        public WirelessGenericConfRsp[] newArray(int size) {
            return (new WirelessGenericConfRsp[size]);
        }

    };
    @SerializedName("RspStatus")
    @Expose
    private String RspStatus;
    @SerializedName("MsgCode")
    @Expose
    private String MsgCode;
    @SerializedName("Oper")
    @Expose
    private String Oper;
    @SerializedName("GetGenericConf")
    @Expose
    private com.apps.net1.ModelMifi.GetGenericConf GetGenericConf;

    /**
     * @return The RspStatus
     */
    public String getRspStatus() {
        return RspStatus;
    }

    /**
     * @param RspStatus The RspStatus
     */
    public void setRspStatus(String RspStatus) {
        this.RspStatus = RspStatus;
    }

    /**
     * @return The MsgCode
     */
    public String getMsgCode() {
        return MsgCode;
    }

    /**
     * @param MsgCode The MsgCode
     */
    public void setMsgCode(String MsgCode) {
        this.MsgCode = MsgCode;
    }

    /**
     * @return The Oper
     */
    public String getOper() {
        return Oper;
    }

    /**
     * @param Oper The Oper
     */
    public void setOper(String Oper) {
        this.Oper = Oper;
    }

    /**
     * @return The GetGenericConf
     */
    public com.apps.net1.ModelMifi.GetGenericConf getGetGenericConf() {
        return GetGenericConf;
    }

    /**
     * @param GetGenericConf The GetGenericConf
     */
    public void setGetGenericConf(com.apps.net1.ModelMifi.GetGenericConf GetGenericConf) {
        this.GetGenericConf = GetGenericConf;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(Oper);
        dest.writeValue(GetGenericConf);
    }

    public int describeContents() {
        return 0;
    }

}
