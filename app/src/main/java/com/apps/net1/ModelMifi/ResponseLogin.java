
package com.apps.net1.ModelMifi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin implements Parcelable
{

    @SerializedName("LoginAuthRsp")
    @Expose
    public LoginAuthRsp LoginAuthRsp;
    public final static Parcelable.Creator<ResponseLogin> CREATOR = new Creator<ResponseLogin>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResponseLogin createFromParcel(Parcel in) {
            ResponseLogin instance = new ResponseLogin();
            instance.LoginAuthRsp = ((LoginAuthRsp) in.readValue((LoginAuthRsp.class.getClassLoader())));
            return instance;
        }

        public ResponseLogin[] newArray(int size) {
            return (new ResponseLogin[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The LoginAuthRsp
     */
    public LoginAuthRsp getLoginAuthRsp() {
        return LoginAuthRsp;
    }

    /**
     * 
     * @param LoginAuthRsp
     *     The LoginAuthRsp
     */
    public void setLoginAuthRsp(LoginAuthRsp LoginAuthRsp) {
        this.LoginAuthRsp = LoginAuthRsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(LoginAuthRsp);
    }

    public int describeContents() {
        return  0;
    }

}
