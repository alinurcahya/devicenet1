
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List implements Parcelable
{

    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("SSID")
    @Expose
    private String SSID;
    @SerializedName("enabled")
    @Expose
    private String enabled;
    @SerializedName("technology")
    @Expose
    private String technology;
    @SerializedName("wmm")
    @Expose
    private String wmm;
    @SerializedName("channel_select")
    @Expose
    private String channelSelect;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("ignore_broadcast")
    @Expose
    private String ignoreBroadcast;
    @SerializedName("tx_power")
    @Expose
    private String txPower;
    @SerializedName("mcast_rate")
    @Expose
    private String mcastRate;
    public final static Parcelable.Creator<List> CREATOR = new Creator<List>() {


        @SuppressWarnings({
            "unchecked"
        })
        public List createFromParcel(Parcel in) {
            List instance = new List();
            instance.index = ((String) in.readValue((String.class.getClassLoader())));
            instance.SSID = ((String) in.readValue((String.class.getClassLoader())));
            instance.enabled = ((String) in.readValue((String.class.getClassLoader())));
            instance.technology = ((String) in.readValue((String.class.getClassLoader())));
            instance.wmm = ((String) in.readValue((String.class.getClassLoader())));
            instance.channelSelect = ((String) in.readValue((String.class.getClassLoader())));
            instance.channel = ((String) in.readValue((String.class.getClassLoader())));
            instance.ignoreBroadcast = ((String) in.readValue((String.class.getClassLoader())));
            instance.txPower = ((String) in.readValue((String.class.getClassLoader())));
            instance.mcastRate = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public List[] newArray(int size) {
            return (new List[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The index
     */
    public String getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The SSID
     */
    public String getSSID() {
        return SSID;
    }

    /**
     * 
     * @param SSID
     *     The SSID
     */
    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

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
     *     The technology
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * 
     * @param technology
     *     The technology
     */
    public void setTechnology(String technology) {
        this.technology = technology;
    }

    /**
     * 
     * @return
     *     The wmm
     */
    public String getWmm() {
        return wmm;
    }

    /**
     * 
     * @param wmm
     *     The wmm
     */
    public void setWmm(String wmm) {
        this.wmm = wmm;
    }

    /**
     * 
     * @return
     *     The channelSelect
     */
    public String getChannelSelect() {
        return channelSelect;
    }

    /**
     * 
     * @param channelSelect
     *     The channel_select
     */
    public void setChannelSelect(String channelSelect) {
        this.channelSelect = channelSelect;
    }

    /**
     * 
     * @return
     *     The channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 
     * @param channel
     *     The channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
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
     *     The txPower
     */
    public String getTxPower() {
        return txPower;
    }

    /**
     * 
     * @param txPower
     *     The tx_power
     */
    public void setTxPower(String txPower) {
        this.txPower = txPower;
    }

    /**
     * 
     * @return
     *     The mcastRate
     */
    public String getMcastRate() {
        return mcastRate;
    }

    /**
     * 
     * @param mcastRate
     *     The mcast_rate
     */
    public void setMcastRate(String mcastRate) {
        this.mcastRate = mcastRate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(index);
        dest.writeValue(SSID);
        dest.writeValue(enabled);
        dest.writeValue(technology);
        dest.writeValue(wmm);
        dest.writeValue(channelSelect);
        dest.writeValue(channel);
        dest.writeValue(ignoreBroadcast);
        dest.writeValue(txPower);
        dest.writeValue(mcastRate);
    }

    public int describeContents() {
        return  0;
    }

}
