
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponCekSoftwareJava implements Parcelable
{

    @SerializedName("RemoteUpgradeConfRsp")
    @Expose
    private com.apps.net1.ModelMifi.RemoteUpgradeConfRsp RemoteUpgradeConfRsp;
    public final static Parcelable.Creator<ResponCekSoftwareJava> CREATOR = new Creator<ResponCekSoftwareJava>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResponCekSoftwareJava createFromParcel(Parcel in) {
            ResponCekSoftwareJava instance = new ResponCekSoftwareJava();
            instance.RemoteUpgradeConfRsp = ((com.apps.net1.ModelMifi.RemoteUpgradeConfRsp) in.readValue((RemoteUpgradeConfRsp.class.getClassLoader())));
            return instance;
        }

        public ResponCekSoftwareJava[] newArray(int size) {
            return (new ResponCekSoftwareJava[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The RemoteUpgradeConfRsp
     */
    public com.apps.net1.ModelMifi.RemoteUpgradeConfRsp getRemoteUpgradeConfRsp() {
        return RemoteUpgradeConfRsp;
    }

    /**
     * 
     * @param RemoteUpgradeConfRsp
     *     The RemoteUpgradeConfRsp
     */
    public void setRemoteUpgradeConfRsp(com.apps.net1.ModelMifi.RemoteUpgradeConfRsp RemoteUpgradeConfRsp) {
        this.RemoteUpgradeConfRsp = RemoteUpgradeConfRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(RemoteUpgradeConfRsp);
    }

    public int describeContents() {
        return  0;
    }

}
