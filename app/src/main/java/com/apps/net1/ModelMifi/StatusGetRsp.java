
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusGetRsp implements Parcelable
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
    @SerializedName("DHCPList")
    @Expose
    private com.apps.net1.ModelMifi.DHCPList DHCPList;
    public final static Parcelable.Creator<StatusGetRsp> CREATOR = new Creator<StatusGetRsp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StatusGetRsp createFromParcel(Parcel in) {
            StatusGetRsp instance = new StatusGetRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Oper = ((String) in.readValue((String.class.getClassLoader())));
            instance.DHCPList = ((com.apps.net1.ModelMifi.DHCPList) in.readValue((DHCPList.class.getClassLoader())));
            return instance;
        }

        public StatusGetRsp[] newArray(int size) {
            return (new StatusGetRsp[size]);
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

    /**
     * 
     * @return
     *     The DHCPList
     */
    public com.apps.net1.ModelMifi.DHCPList getDHCPList() {
        return DHCPList;
    }

    /**
     * 
     * @param DHCPList
     *     The DHCPList
     */
    public void setDHCPList(com.apps.net1.ModelMifi.DHCPList DHCPList) {
        this.DHCPList = DHCPList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(Oper);
        dest.writeValue(DHCPList);
    }

    public int describeContents() {
        return  0;
    }

}
