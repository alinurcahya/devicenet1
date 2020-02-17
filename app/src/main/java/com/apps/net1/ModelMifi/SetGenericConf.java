
package com.apps.net1.ModelMifi;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetGenericConf implements Parcelable
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
    @SerializedName("list")
    @Expose
    private java.util.List<com.apps.net1.ModelMifi.List> lists = new ArrayList<com.apps.net1.ModelMifi.List>();
    public final static Parcelable.Creator<SetGenericConf> CREATOR = new Creator<SetGenericConf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SetGenericConf createFromParcel(Parcel in) {
            SetGenericConf instance = new SetGenericConf();
            instance.enabled = ((String) in.readValue((String.class.getClassLoader())));
            instance.isolation = ((String) in.readValue((String.class.getClassLoader())));
            instance.ignoreBroadcast = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.lists, (com.apps.net1.ModelMifi.List.class.getClassLoader()));
            return instance;
        }

        public SetGenericConf[] newArray(int size) {
            return (new SetGenericConf[size]);
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
     *     The lists
     */
    public java.util.List<com.apps.net1.ModelMifi.List> getLists() {
        return lists;
    }

    /**
     * 
     * @param lists
     *     The lists
     */
    public void setLists(java.util.List<com.apps.net1.ModelMifi.List> lists) {
        this.lists = lists;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(enabled);
        dest.writeValue(isolation);
        dest.writeValue(ignoreBroadcast);
        dest.writeList(lists);
    }

    public int describeContents() {
        return  0;
    }

}
