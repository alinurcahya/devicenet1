
package com.apps.net1.ModelMifi;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetGenericConf implements Parcelable
{

    @SerializedName("enabled")
    @Expose
    private String enabled;
    @SerializedName("isolation")
    @Expose
    private String isolation;
    @SerializedName("ignore_broadcast")
    @Expose
    private String ignoreBroadcast;
    @SerializedName("ssidcount")
    @Expose
    private int ssidcount;
    @SerializedName("list")
    @Expose
    private java.util.List<com.apps.net1.ModelMifi.List> list = new ArrayList<com.apps.net1.ModelMifi.List>();
    public final static Parcelable.Creator<GetGenericConf> CREATOR = new Creator<GetGenericConf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GetGenericConf createFromParcel(Parcel in) {
            GetGenericConf instance = new GetGenericConf();
            instance.enabled = ((String) in.readValue((String.class.getClassLoader())));
            instance.isolation = ((String) in.readValue((String.class.getClassLoader())));
            instance.ignoreBroadcast = ((String) in.readValue((String.class.getClassLoader())));
            instance.ssidcount = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.list, (com.apps.net1.ModelMifi.List.class.getClassLoader()));
            return instance;
        }

        public GetGenericConf[] newArray(int size) {
            return (new GetGenericConf[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The enabled
     */
    public String getEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled
     *     The enabled
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    /**
     * 
     * @return
     *     The isolation
     */
    public String getIsolation() {
        return isolation;
    }

    /**
     * 
     * @param isolation
     *     The isolation
     */
    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }

    /**
     * 
     * @return
     *     The ignoreBroadcast
     */
    public String getIgnoreBroadcast() {
        return ignoreBroadcast;
    }

    /**
     * 
     * @param ignoreBroadcast
     *     The ignore_broadcast
     */
    public void setIgnoreBroadcast(String ignoreBroadcast) {
        this.ignoreBroadcast = ignoreBroadcast;
    }

    /**
     * 
     * @return
     *     The ssidcount
     */
    public int getSsidcount() {
        return ssidcount;
    }

    /**
     * 
     * @param ssidcount
     *     The ssidcount
     */
    public void setSsidcount(int ssidcount) {
        this.ssidcount = ssidcount;
    }

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<com.apps.net1.ModelMifi.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<com.apps.net1.ModelMifi.List> list) {
        this.list = list;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(enabled);
        dest.writeValue(isolation);
        dest.writeValue(ignoreBroadcast);
        dest.writeValue(ssidcount);
        dest.writeList(list);
    }

    public int describeContents() {
        return  0;
    }

}
