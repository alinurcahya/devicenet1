
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginAuthRsp implements Parcelable
{

    @SerializedName("RspStatus")
    @Expose
    private String RspStatus;
    @SerializedName("MsgCode")
    @Expose
    private String MsgCode;
    @SerializedName("Result")
    @Expose
    private String Result;

    public final static Parcelable.Creator<LoginAuthRsp> CREATOR = new Creator<LoginAuthRsp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LoginAuthRsp createFromParcel(Parcel in) {
            LoginAuthRsp instance = new LoginAuthRsp();
            instance.RspStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.MsgCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Result = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public LoginAuthRsp[] newArray(int size) {
            return (new LoginAuthRsp[size]);
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
     *     The Result
     */
    public String getResult() {
        return Result;
    }

    /**
     * 
     * @param Result
     *     The Result
     */
    public void setResult(String Result) {
        this.Result = Result;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RspStatus);
        dest.writeValue(MsgCode);
        dest.writeValue(Result);
    }

    public int describeContents() {
        return  0;
    }

}
