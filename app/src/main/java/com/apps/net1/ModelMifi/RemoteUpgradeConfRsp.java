
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemoteUpgradeConfRsp implements Parcelable
{

    @SerializedName("RspStatus")
    @Expose
    private String RspStatus;
    @SerializedName("MsgCode")
    @Expose
    private String MsgCode;
    @SerializedName("Oper")
    @Expose
    private String Oper;
    public final static Parcelable.Creator<RemoteUpgradeConfRsp> CREATOR = new Creator<RemoteUpgradeConfRsp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RemoteUpgradeConfRsp createFromParcel(Parcel in) {
            RemoteUpgradeConfRsp instance = new RemoteUpgradeConfRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Oper = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public RemoteUpgradeConfRsp[] newArray(int size) {
            return (new RemoteUpgradeConfRsp[size]);
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
     *     The Oper
     */
    public String getOper() {
        return Oper;
    }

    /**
     * 
     * @param Oper
     *     The Oper
     */
    public void setOper(String Oper) {
        this.Oper = Oper;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(Oper);
    }

    public int describeContents() {
        return  0;
    }

}
