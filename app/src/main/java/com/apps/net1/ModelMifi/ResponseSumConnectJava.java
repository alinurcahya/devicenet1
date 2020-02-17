package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSumConnectJava implements Parcelable {

    public final static Parcelable.Creator<ResponseSumConnectJava> CREATOR = new Creator<ResponseSumConnectJava>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponseSumConnectJava createFromParcel(Parcel in) {
            ResponseSumConnectJava instance = new ResponseSumConnectJava();
            instance.StatusGetRsp = ((com.apps.net1.ModelMifi.StatusGetRsp) in.readValue((StatusGetRsp.class.getClassLoader())));
            return instance;
        }

        public ResponseSumConnectJava[] newArray(int size) {
            return (new ResponseSumConnectJava[size]);
        }

    };
    @SerializedName("StatusGetRsp")
    @Expose
    private com.apps.net1.ModelMifi.StatusGetRsp StatusGetRsp;

    /**
     * @return The StatusGetRsp
     */
    public com.apps.net1.ModelMifi.StatusGetRsp getStatusGetRsp() {
        return StatusGetRsp;
    }

    /**
     * @param StatusGetRsp The StatusGetRsp
     */
    public void setStatusGetRsp(com.apps.net1.ModelMifi.StatusGetRsp StatusGetRsp) {
        this.StatusGetRsp = StatusGetRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(StatusGetRsp);
    }

    public int describeContents() {
        return 0;
    }

}
