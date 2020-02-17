
package com.apps.net1.ModelMifi;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DHCPList implements Parcelable
{

    @SerializedName("Count")
    @Expose
    private int Count;
    @SerializedName("Items")
    @Expose
    private List<Item> Items = new ArrayList<Item>();
    public final static Parcelable.Creator<DHCPList> CREATOR = new Creator<DHCPList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DHCPList createFromParcel(Parcel in) {
            DHCPList instance = new DHCPList();
            instance.Count = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.Items, (com.apps.net1.ModelMifi.Item.class.getClassLoader()));
            return instance;
        }

        public DHCPList[] newArray(int size) {
            return (new DHCPList[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    /**
     * 
     * @return
     *     The Items
     */
    public List<Item> getItems() {
        return Items;
    }

    /**
     * 
     * @param Items
     *     The Items
     */
    public void setItems(List<Item> Items) {
        this.Items = Items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(Count);
        dest.writeList(Items);
    }

    public int describeContents() {
        return  0;
    }

}
