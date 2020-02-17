package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AsdJava {

    @SerializedName("LTEParaGetReq")
    @Expose
    private List<String> LTEParaGetReq = new ArrayList<String>();

    public AsdJava(List<String> asd) {
        this.LTEParaGetReq = asd;
    }

    /**
     * @return The LTEParaGetReq
     */
    public List<String> getLTEParaGetReq() {
        return LTEParaGetReq;
    }

    /**
     * @param LTEParaGetReq The LTEParaGetReq
     */
    public void setLTEParaGetReq(List<String> LTEParaGetReq) {
        this.LTEParaGetReq = LTEParaGetReq;
    }


}
