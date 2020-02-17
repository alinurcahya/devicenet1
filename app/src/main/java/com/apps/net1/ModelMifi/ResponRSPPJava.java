
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponRSPPJava implements Parcelable
{

    @SerializedName("LTEParaGetRsp")
    @Expose
    private com.apps.net1.ModelMifi.LTEParaGetRsp LTEParaGetRsp;
    public final static Parcelable.Creator<ResponRSPPJava> CREATOR = new Creator<ResponRSPPJava>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResponRSPPJava createFromParcel(Parcel in) {
            ResponRSPPJava instance = new ResponRSPPJava();
            instance.LTEParaGetRsp = ((com.apps.net1.ModelMifi.LTEParaGetRsp) in.readValue((LTEParaGetRsp.class.getClassLoader())));
            return instance;
        }

        public ResponRSPPJava[] newArray(int size) {
            return (new ResponRSPPJava[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The LTEParaGetRsp
     */
    public com.apps.net1.ModelMifi.LTEParaGetRsp getLTEParaGetRsp() {
        return LTEParaGetRsp;
    }

    /**
     * 
     * @param LTEParaGetRsp
     *     The LTEParaGetRsp
     */
    public void setLTEParaGetRsp(com.apps.net1.ModelMifi.LTEParaGetRsp LTEParaGetRsp) {
        this.LTEParaGetRsp = LTEParaGetRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(LTEParaGetRsp);
    }

    public int describeContents() {
        return  0;
    }

}
