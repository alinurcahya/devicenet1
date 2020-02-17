package com.apps.net1.API;


import com.apps.net1.ModelR052.LoginFirst;
import com.apps.net1.ModelR052.ResponChangeSSID;
import com.apps.net1.ModelR052.ResponConSum;
import com.apps.net1.ModelR052.ResponICCID;
import com.apps.net1.ModelR052.ResponIMSI;
import com.apps.net1.ModelR052.ResponIP;
import com.apps.net1.ModelR052.ResponSSID;
import com.apps.net1.ModelR052.ResponVSMAC;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */

public interface RestApi {

    @GET("fotaUpgrade?imei=862075037207643&APV=P65Net1_AP_R051_V009&CPV=P65Net1_CP_R051_V004&jsonpcallback=jQuery110207290225824199774_1542996635095&_=1542996635101")
    Call<LoginFirst> updateSoftware();

    @GET("login.cgi?_=1542993441")
    Call<LoginFirst> loginFirst();

    @GET("login.cgi?Action=Digest&username=admin&realm=Highwmg&nonce=1000&response=d2a7bf9ca559b307982c6197bf7ef5a3&qop=auth&cnonce=46afc1bc34ea5f12&nc=00000002&temp=marvell&_=1542993442")
    Call<LoginFirst> loginAction();

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponIMSI> postIMSI(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponSSID> postSSID(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponVSMAC> postVSMAC(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponConSum> postConSum(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponICCID> postICCID(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponIP> postIP(@Body RequestBody body);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST("xml_action.cgi?method=set")
    Call<ResponChangeSSID> postChangeSSID(@Body RequestBody body);
}
