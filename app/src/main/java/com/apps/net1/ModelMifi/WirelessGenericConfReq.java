
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WirelessGenericConfReq implements Parcelable
{

    @SerializedName("Oper")
    @Expose
    private String Oper;
    @SerializedName("SetGenericConf")
    @Expose
    private com.apps.net1.ModelMifi.SetGenericConf SetGenericConf;
    public final static Parcelable.Creator<WirelessGenericConfReq> CREATOR = new Creator<WirelessGenericConfReq>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WirelessGenericConfReq createFromParcel(Parcel in) {
            WirelessGenericConfReq instance = new WirelessGenericConfReq();
            instance.Oper = ((String) in.readValue((String.class.getClassLoader())));
            instance.SetGenericConf = ((com.apps.net1.ModelMifi.SetGenericConf) in.readValue((SetGenericConf.class.getClassLoader())));
            return instance;
        }

        public WirelessGenericConfReq[] newArray(int size) {
            return (new WirelessGenericConfReq[size]);
        }

    }
    ;

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
     *     The SetGenericConf
     */
    public com.apps.net1.ModelMifi.SetGenericConf getSetGenericConf() {
        return SetGenericConf;
    }

    /**
     * 
     * @param SetGenericConf
     *     The SetGenericConf
     */
    public void setSetGenericConf(com.apps.net1.ModelMifi.SetGenericConf SetGenericConf) {
        this.SetGenericConf = SetGenericConf;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(Oper);
        dest.writeValue(SetGenericConf);
    }

    public int describeContents() {
        return  0;
    }

}
