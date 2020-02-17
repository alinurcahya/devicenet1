package com.apps.net1.ModelM20;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 19/01/2019.
 */

@Root(strict = false)
public class LoginFirstM20 {

    @Element(name="Login")
    String login;

    public LoginFirstM20(){

    }

    public String getLogin() {return this.login;}
    public void setLogin(String value) {this.login = value;}

}
