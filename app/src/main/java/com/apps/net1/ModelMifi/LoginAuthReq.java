package com.apps.net1.ModelMifi;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

public class LoginAuthReq {
    String UserName;
    String PassWord;
    public LoginAuthReq(String user, String pass){
        this.UserName = user;
        this.PassWord = pass;
    }
}
