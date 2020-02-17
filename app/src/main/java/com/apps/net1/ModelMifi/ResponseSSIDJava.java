
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSSIDJava implements Parcelable
{

    @SerializedName("WirelessGenericConfRsp")
    @Expose
    private com.apps.net1.ModelMifi.WirelessGenericConfRsp WirelessGenericConfRsp;
    public final static Parcelable.Creator<ResponseSSIDJava> CREATOR = new Creator<ResponseSSIDJava>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResponseSSIDJava createFromParcel(Parcel in) {
            ResponseSSIDJava instance = new ResponseSSIDJava();
            instance.WirelessGenericConfRsp = ((com.apps.net1.ModelMifi.WirelessGenericConfRsp) in.readValue((WirelessGenericConfRsp.class.getClassLoader())));
            return instance;
        }

        public ResponseSSIDJava[] newArray(int size) {
            return (new ResponseSSIDJava[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The WirelessGenericConfRsp
     */
    public com.apps.net1.ModelMifi.WirelessGenericConfRsp getWirelessGenericConfRsp() {
        return WirelessGenericConfRsp;
    }

    /**
     * 
     * @param WirelessGenericConfRsp
     *     The WirelessGenericConfRsp
     */
    public void setWirelessGenericConfRsp(com.apps.net1.ModelMifi.WirelessGenericConfRsp WirelessGenericConfRsp) {
        this.WirelessGenericConfRsp = WirelessGenericConfRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(WirelessGenericConfRsp);
    }

    public int describeContents() {
        return  0;
    }

}
