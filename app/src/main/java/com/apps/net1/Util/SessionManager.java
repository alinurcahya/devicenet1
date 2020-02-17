package com.apps.net1.Util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dell_Cleva on 20/10/2018.
 */

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "MyIPS";

    // User name (make variable public to access from outside)
    public static final String KEY_IP = "ip";
    public static final String KEY_DEVICE = "device";
    public static final String IS_NEW = "is_new";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getIP(){
        String user = pref.getString(KEY_IP, "192.168.0.1");
        return user;
    }

    public void updateIP(String ip) {
        editor.putString(KEY_IP, ip);
        editor.commit();
    }

    public String getKeyDevice(){
        return pref.getString(KEY_DEVICE, "");
    }

    public void updateDevice(String ip) {
        editor.putString(KEY_DEVICE, ip);
        editor.commit();
    }

    public boolean isNew(){
        return pref.getBoolean(IS_NEW, true);
    }

    public void updateNew(boolean wa) {
        editor.putBoolean(IS_NEW, wa);
        editor.commit();
    }
}
