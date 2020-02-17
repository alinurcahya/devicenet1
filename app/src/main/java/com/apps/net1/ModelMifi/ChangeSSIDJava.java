
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeSSIDJava implements Parcelable
{

    @SerializedName("WirelessGenericConfReq")
    @Expose
    private com.apps.net1.ModelMifi.WirelessGenericConfReq WirelessGenericConfReq;
    public final static Parcelable.Creator<ChangeSSIDJava> CREATOR = new Creator<ChangeSSIDJava>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ChangeSSIDJava createFromParcel(Parcel in) {
            ChangeSSIDJava instance = new ChangeSSIDJava();
            instance.WirelessGenericConfReq = ((com.apps.net1.ModelMifi.WirelessGenericConfReq) in.readValue((WirelessGenericConfReq.class.getClassLoader())));
            return instance;
        }

        public ChangeSSIDJava[] newArray(int size) {
            return (new ChangeSSIDJava[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The WirelessGenericConfReq
     */
    public com.apps.net1.ModelMifi.WirelessGenericConfReq getWirelessGenericConfReq() {
        return WirelessGenericConfReq;
    }

    /**
     * 
     * @param WirelessGenericConfReq
     *     The WirelessGenericConfReq
     */
    public void setWirelessGenericConfReq(com.apps.net1.ModelMifi.WirelessGenericConfReq WirelessGenericConfReq) {
        this.WirelessGenericConfReq = WirelessGenericConfReq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(WirelessGenericConfReq);
    }

    public int describeContents() {
        return  0;
    }

}
