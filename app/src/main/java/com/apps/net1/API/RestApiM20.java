package com.apps.net1.API;

import com.apps.net1.ModelM20.LoginFirstM20;
import com.apps.net1.ModelM20.ResponICCIDM20;
import com.apps.net1.ModelM20.ResponSWVerM20;
import com.apps.net1.ModelM20.ResponSignalM20;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dell_Cleva on 19/01/2019.
 */

public interface RestApiM20 {

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("cgi-bin/systemutil.cgi")
    @FormUrlEncoded
    Call<LoginFirstM20> postIMSI(@Field("Command") String command, @Field("user") String user, @Field("password") String pass, @Field("T") String t);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("cgi-bin/wireless.cgi")
    @FormUrlEncoded
    Call<String> changeSSID(@Field("Command") String command, @Field("page") String page, @Field("wlan_conf") String wlan_conf, @Field("radiohiddenButton") String radiohiddenButton,
                            @Field("wifihiddenButton") String wifihiddenButton, @Field("wirelessmode") String wirelessmode, @Field("mssid_0") String mssid_0, @Field("isolated_ssid") String isolated_ssid,
                            @Field("mssid_1") String mssid_1, @Field("mssid_2") String mssid_2, @Field("mssid_3") String mssid_3, @Field("mssid_4") String mssid_4,
                            @Field("mssid_5") String mssid_5, @Field("mssid_6") String mssid_6, @Field("mssid_7") String mssid_7, @Field("broadcastssid") String broadcastssid,
                            @Field("apisolated") String apisolated, @Field("mbssidapisolated") String mbssidapisolated, @Field("sz11gChannel") String sz11gChannel, @Field("n_mode") String n_mode,
                            @Field("n_bandwidth") String n_bandwidth, @Field("n_gi") String n_gi, @Field("n_rdg") String n_rdg, @Field("n_stbc") String n_stbc,
                            @Field("n_amsdu") String n_amsdu, @Field("n_autoba") String n_autoba, @Field("n_badecline") String n_badecline, @Field("n_disallow_tkip") String n_disallow_tkip,
                            @Field("n_2040_coexit") String n_2040_coexit, @Field("n_ldpc") String n_ldpc, @Field("t") String t);

    @GET("cgi-bin/modem.cgi?Command=getModemStatus&T=1547020704501")
    Call<ResponICCIDM20> getICCID();

    @GET("cgi-bin/systemutil.cgi?Command=SystemInfoCmTlsq&T=1547020429786")
    Call<ResponSWVerM20> getSWVersion();

    @GET("cgi-bin/modem.cgi?Command=getAntenna&T=1547074727500")
    Call<ResponSignalM20> getSignal();

    @GET("wifi2g/basic_net1.shtml")
    Call<String> getSSIDName();

    @GET("internet/lan.shtml")
    Call<String> getMACADDR();

    @GET("wifi2g/stainfo.shtml")
    Call<String> getCONSUM();
}
