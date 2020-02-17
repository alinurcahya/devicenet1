
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable
{

    @SerializedName("IP")
    @Expose
    private String IP;
    @SerializedName("MAC")
    @Expose
    private String MAC;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("UserType")
    @Expose
    private String UserType;
    public final static Parcelable.Creator<Item> CREATOR = new Creator<Item>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Item createFromParcel(Parcel in) {
            Item instance = new Item();
            instance.IP = ((String) in.readValue((String.class.getClassLoader())));
            instance.MAC = ((String) in.readValue((String.class.getClassLoader())));
            instance.Name = ((String) in.readValue((String.class.getClassLoader())));
            instance.UserType = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Item[] newArray(int size) {
            return (new Item[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * 
     * @param IP
     *     The IP
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

    /**
     * 
     * @return
     *     The MAC
     */
    public String getMAC() {
        return MAC;
    }

    /**
     * 
     * @param MAC
     *     The MAC
     */
    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The UserType
     */
    public String getUserType() {
        return UserType;
    }

    /**
     * 
     * @param UserType
     *     The UserType
     */
    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(IP);
        dest.writeValue(MAC);
        dest.writeValue(Name);
        dest.writeValue(UserType);
    }

    public int describeContents() {
        return  0;
    }

}
