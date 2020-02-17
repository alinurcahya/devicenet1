package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponeICCIDJava implements Parcelable {

    public final static Parcelable.Creator<ResponeICCIDJava> CREATOR = new Creator<ResponeICCIDJava>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponeICCIDJava createFromParcel(Parcel in) {
            ResponeICCIDJava instance = new ResponeICCIDJava();
            instance.DeviceInfoRsp = ((com.apps.net1.ModelMifi.DeviceInfoRsp) in.readValue((DeviceInfoRsp.class.getClassLoader())));
            return instance;
        }

        public ResponeICCIDJava[] newArray(int size) {
            return (new ResponeICCIDJava[size]);
        }

    };
    @SerializedName("DeviceInfoRsp")
    @Expose
    private com.apps.net1.ModelMifi.DeviceInfoRsp DeviceInfoRsp;

    /**
     * @return The DeviceInfoRsp
     */
    public com.apps.net1.ModelMifi.DeviceInfoRsp getDeviceInfoRsp() {
        return DeviceInfoRsp;
    }

    /**
     * @param DeviceInfoRsp The DeviceInfoRsp
     */
    public void setDeviceInfoRsp(com.apps.net1.ModelMifi.DeviceInfoRsp DeviceInfoRsp) {
        this.DeviceInfoRsp = DeviceInfoRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(DeviceInfoRsp);
    }

    public int describeContents() {
        return 0;
    }

}
