package com.apps.net1.API;

import com.apps.net1.ModelMifi.AsdJava;
import com.apps.net1.ModelMifi.ICCIDJava;
import com.apps.net1.ModelMifi.LTERSP;
import com.apps.net1.ModelMifi.Oper;
import com.apps.net1.ModelMifi.PostLogin;
import com.apps.net1.ModelMifi.ResponCekSoftwareJava;
import com.apps.net1.ModelMifi.ResponRSPPJava;
import com.apps.net1.ModelMifi.ResponeICCIDJava;
import com.apps.net1.ModelMifi.ResponseLogin;
import com.apps.net1.ModelMifi.ResponseSSIDJava;
import com.apps.net1.ModelMifi.ResponseSumConnectJava;
import com.apps.net1.ModelMifi.SetGenericConf;
import com.apps.net1.ModelMifi.WirelessGenericConfReq;
import com.apps.net1.ModelMifi.WirelessGenericConfRsp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dell_Cleva on 20/01/2019.
 */

public interface RestApiMifi {

    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    @POST("fcgi/cuslogin.fcgi")
    Call<ResponseLogin> loginMifi(@Body PostLogin postLogin);

    @POST("fcgi/cusdialer.fcgi")
    Call<ResponRSPPJava> getRSRP(@Body AsdJava postLogin);

    @POST("fcgi/cusprod.fcgi")
    Call<ResponeICCIDJava> getICCID(@Body ICCIDJava s);

    @POST("fcgi/cusconf.fcgi")
    Call<ResponseSumConnectJava> getSUM(@Body Oper s);

    @POST("fcgi/cusconf.fcgi")
    Call<ResponseSSIDJava> getSSID(@Body Oper s);

    @POST("fcgi/cusconf.fcgi")
    Call<ResponseSSIDJava> changeSSID(@Body Oper setGenericConf);

    @POST("fcgi/cusconf.fcgi")
    Call<ResponCekSoftwareJava> checkSoftware(@Body Oper s);
}
