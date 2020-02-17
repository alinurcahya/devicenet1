package com.apps.net1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.DhcpInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.net1.API.MeConverter;
import com.apps.net1.API.RestApi;
import com.apps.net1.API.RestApiM20;
import com.apps.net1.API.RestApiMifi;
import com.apps.net1.ModelM20.ResponSignalM20;
import com.apps.net1.ModelMifi.AsdJava;
import com.apps.net1.ModelMifi.ICCIDJava;
import com.apps.net1.ModelMifi.LoginAuthReq;
import com.apps.net1.ModelMifi.Oper;
import com.apps.net1.ModelMifi.PostLogin;
import com.apps.net1.ModelMifi.ResponRSPPJava;
import com.apps.net1.ModelMifi.ResponeICCIDJava;
import com.apps.net1.ModelMifi.ResponseLogin;
import com.apps.net1.ModelMifi.ResponseSSIDJava;
import com.apps.net1.ModelMifi.ResponseSumConnectJava;
import com.apps.net1.ModelMifi.SetGenericConf;
import com.apps.net1.ModelMifi.StatusGetReq;
import com.apps.net1.ModelMifi.WirelessGenericConfReq;
import com.apps.net1.ModelR052.LoginFirst;
import com.apps.net1.ModelM20.LoginFirstM20;
import com.apps.net1.ModelM20.ResponICCIDM20;
import com.apps.net1.ModelM20.ResponSWVerM20;
import com.apps.net1.ModelR052.ResponChangeSSID;
import com.apps.net1.ModelR052.ResponConSum;
import com.apps.net1.ModelR052.ResponICCID;
import com.apps.net1.ModelR052.ResponIMSI;
import com.apps.net1.ModelR052.ResponIP;
import com.apps.net1.ModelR052.ResponSSID;
import com.apps.net1.ModelR052.ResponVSMAC;
import com.apps.net1.Util.Constant;
import com.apps.net1.Util.SessionManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public android.support.v7.app.AlertDialog alertDialogObject;
    String sCookie = "123";
    String sWeb = "";
    SessionManager sessionManager;

    RelativeLayout mainLayout;
    Handler handler;

    RestApi restApi, restApi2, restApi3;
    RestApiM20 restApiM20, restApiM202;
    RestApiMifi restApiMifi;
    Retrofit retrofit, retrofit2, retrofit3;
    Retrofit retrofitM20,  retrofit2M20;
    Retrofit retrofitMifi;

    TextView tvNama, tvSSID, tvVS, tvCONSUM, tvMAC, tvICCID, tvIMSI, tvIP, tvAkses, tvUbah, tvCheck,
    tvRSRP;
    ProgressBar pb, pbme;
    View llChange;

    String updateLink = "http://nacs.notioni.com/openacs-client/inter/";

    ImageView imgSignal;
    DhcpInfo d;
    WifiManager wifii;
    public String intToIp(int i) {

        return
                ( i & 0xFF) + "." +
                        ((i >> 8 ) & 0xFF) + "." +
                        ((i >> 16 ) & 0xFF) + "." +
                        ((i >> 24 ) & 0xFF );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        sessionManager = new SessionManager(this);

        wifii = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        d = wifii.getDhcpInfo();
        pbme = findViewById(R.id.loadings);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                DoSetPass();
            }
        });

        imgSignal = findViewById(R.id.imgLogo);

        tvNama = findViewById(R.id.tvNamaPerang);
        tvSSID = findViewById(R.id.tvSSID);
        tvVS = findViewById(R.id.tvVERSOFT);
        tvCONSUM = findViewById(R.id.tvCONSUM);
        tvMAC = findViewById(R.id.tvMAC);
        tvICCID = findViewById(R.id.tvICCID);
        tvIMSI = findViewById(R.id.tvIMSI);
        tvIP = findViewById(R.id.tvIP);
        tvAkses = findViewById(R.id.tvAkses);
        tvUbah = findViewById(R.id.tvUbah);
        tvCheck = findViewById(R.id.tvCekSoftware);
        tvRSRP = findViewById(R.id.tvRSRP);

        tvIP.setText(intToIp(d.gateway));
        sWeb = "http://"+intToIp(d.gateway)+"/";

        tvNama.setText(sessionManager.getKeyDevice());

        String te = "Ubah";
        SpannableString ss = new SpannableString(te);
        ss.setSpan(new UnderlineSpan(), 0, te.length(), 0);
        tvUbah.setText(ss);
        tvUbah.setVisibility(View.GONE);

        String tes = "Cek Software Terbaru";
        SpannableString sss = new SpannableString(tes);
        sss.setSpan(new UnderlineSpan(), 0, tes.length(), 0);
        tvCheck.setText(sss);
        tvCheck.setVisibility(View.GONE);

        String tez = "Akses Web GUI Disini";
        SpannableString ssz = new SpannableString(tez);
        ssz.setSpan(new UnderlineSpan(), 0, tez.length(), 0);

        tvAkses.setText(ssz);
        tvAkses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                if (tvIP.getText().length() > 0) {
                    i.setData(Uri.parse("http://" + tvIP.getText().toString()));
                } else {
                    i.setData(Uri.parse("http://192.168.0.1"));
                }
                startActivity(i);
            }
        });
        tvAkses.setMovementMethod(LinkMovementMethod.getInstance());
        tvAkses.setHighlightColor(Color.TRANSPARENT);

//        if (sessionManager.getKeyDevice().equalsIgnoreCase("R02") ||
//                sessionManager.getKeyDevice().equalsIgnoreCase("R05")) {
//            initR05_R02();
//        } else if (sessionManager.getKeyDevice().equalsIgnoreCase("M20")){
//            initM20();
//        } else {
//            initMifi();
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager.getKeyDevice().equalsIgnoreCase("R05") || sessionManager.getKeyDevice().equalsIgnoreCase("R02"))
            initR05_R02();
        else if (sessionManager.getKeyDevice().equalsIgnoreCase("M20")){
            initM20();
        } else {
            initMifi();
        }
    }

    void doAwal() {

        pbme.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @SuppressLint("NewApi")
            @Override
            public void run() {
                Log.i(TAG, "run: RUN");
                restApi.loginFirst().enqueue(new Callback<LoginFirst>() {
                    @Override
                    public void onResponse(Call<LoginFirst> call, retrofit2.Response<LoginFirst> response) {
                        Log.i(TAG, "onResponse: H " + response.headers().toString());
                        Log.i(TAG, "onResponse: B " + response.body());
                        Log.i(TAG, "onResponse: M " + response.message());
                        if (response.message().equalsIgnoreCase("OK")) {
                            doAction();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginFirst> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                        pbme.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }, 500);
    }

    void initR05_R02(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Pragma", "no-cache")
                        .addHeader("Accept-Encoding", "gzip, deflate")
                        .addHeader("Accept-Language", "en-US,en;q=0.9,id;q=0.8,ms;q=0.7")
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                        .addHeader("Accept", "*/*")
                        .addHeader("Cache-Control", "no-store, no-cache, must-revalidate")
                        .addHeader("X-Requested-With", "XMLHttpRequest")
                        .addHeader("Cookie", "CGISID=")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Referer", sWeb+"index.html")
                        .addHeader("Expires", "-1")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(sWeb)
                .client(client)
                .addConverterFactory(new MeConverter())
                .build();

        restApi = retrofit.create(RestApi.class);

        HttpLoggingInterceptor interceptor3 = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client3 = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                Request request = chain.request()
                        .newBuilder()
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                        .addHeader("Referer", sWeb+"index.html")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(interceptor3).build();

        retrofit3 = new Retrofit.Builder()
                .baseUrl(updateLink)
                .client(client3)
                .addConverterFactory(new MeConverter())
                .build();

        restApi3 = retrofit3.create(RestApi.class);
        doAwal();
    }

    void initM20(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Origin", sWeb)
                        .addHeader("Accept-Encoding", "gzip, deflate")
                        .addHeader("Accept-Language", "en-US,en;q=0.9")
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                        .addHeader("Accept", "*/*")
                        .addHeader("Content-type", "application/x-www-form-urlencoded")
//                        .addHeader("Cache-Control", "no-store, no-cache, must-revalidate")
//                        .addHeader("X-Requested-With", "XMLHttpRequest")
//                        .addHeader("Cookie", "CGISID=")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Referer", sWeb+"login.shtml")
//                        .addHeader("Expires", "-1")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(interceptor).build();

        retrofitM20 = new Retrofit.Builder()
                .baseUrl(sWeb)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        restApiM20 = retrofitM20.create(RestApiM20.class);

        retrofit2M20 = new Retrofit.Builder()
                .baseUrl(sWeb)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        restApiM202 = retrofit2M20.create(RestApiM20.class);

        loginM20();
    }

    void initMifi(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                Request request = chain.request()
                        .newBuilder()
//                        .addHeader("Origin", sWeb)
//                        .addHeader("Accept-Encoding", "gzip, deflate")
//                        .addHeader("Accept-Language", "en-US,en;q=0.9")
//                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
//                        .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
//                        .addHeader("Content-type", "application/json")
//                        .addHeader("X-Requested-With", "XMLHttpRequest")
//                        .addHeader("Connection", "keep-alive")
//                        .addHeader("Referer", sWeb+"/default/login.html")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(interceptor).build();

        retrofitMifi = new Retrofit.Builder()
                .baseUrl(sWeb)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApiMifi = retrofitMifi.create(RestApiMifi.class);

        loginMifi();
    }

    public void loginMifi(){
        LoginAuthReq loginAuthReq = new LoginAuthReq("admin", "21232f297a57a5a743894a0e4a801fc3");
        PostLogin postLogin = new PostLogin(loginAuthReq);
        restApiMifi.loginMifi(postLogin).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, retrofit2.Response<ResponseLogin> response) {

                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                getRSRP();
                getICCID();
                getSUM();
                getSSID();
                pbme.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    public void getRSRP(){
        List<String> jsonArray = new ArrayList<>();
        jsonArray.add("CMStatus");
        jsonArray.add("RSRP");
        jsonArray.add("RSRQ");
        jsonArray.add("RSSI");
        jsonArray.add("SINR");
        jsonArray.add("SignalLevel");
        AsdJava asdJava = new AsdJava(jsonArray);
        restApiMifi.getRSRP(asdJava).enqueue(new Callback<ResponRSPPJava>() {
            @Override
            public void onResponse(Call<ResponRSPPJava> call, retrofit2.Response<ResponRSPPJava> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null){
                    if (response.body().getLTEParaGetRsp() != null){
                        tvRSRP.setText(response.body().getLTEParaGetRsp().getRSRP());
                        int signal = response.body().getLTEParaGetRsp().getSignalLevel();
                        if (signal == 1){
                            imgSignal.setImageResource(R.drawable.signal1);
                        }else if (signal == 2){
                            imgSignal.setImageResource(R.drawable.signal2);
                        }else if (signal == 3){
                            imgSignal.setImageResource(R.drawable.signal3);
                        }else if (signal == 4){
                            imgSignal.setImageResource(R.drawable.signal4);
                        }else if (signal == 5){
                            imgSignal.setImageResource(R.drawable.signal5);
                        }else {
                            imgSignal.setImageResource(R.drawable.signal0);
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponRSPPJava> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void getICCID(){
        List<String> jsonArray = new ArrayList<>();
        jsonArray.add("SoftwareVer");
        jsonArray.add("WiFiMAC");
        jsonArray.add("LTEIMEI");
        jsonArray.add("LTEIMSI");
        jsonArray.add("UICCID");
        ICCIDJava asdJava = new ICCIDJava(jsonArray);
        restApiMifi.getICCID(asdJava).enqueue(new Callback<ResponeICCIDJava>() {
            @Override
            public void onResponse(Call<ResponeICCIDJava> call, retrofit2.Response<ResponeICCIDJava> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null){
                    if (response.body().getDeviceInfoRsp() != null) {
                        tvICCID.setText(response.body().getDeviceInfoRsp().getUICCID());
                        tvIMSI.setText(response.body().getDeviceInfoRsp().getLTEIMSI());
                        tvMAC.setText(response.body().getDeviceInfoRsp().getWiFiMAC());
                        tvVS.setText(response.body().getDeviceInfoRsp().getSoftwareVer());
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponeICCIDJava> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void getSUM(){
        StatusGetReq statusGetReq = new StatusGetReq("DHCPList");
        Oper oper= new Oper(statusGetReq);
        restApiMifi.getSUM(oper).enqueue(new Callback<ResponseSumConnectJava>() {
            @Override
            public void onResponse(Call<ResponseSumConnectJava> call, retrofit2.Response<ResponseSumConnectJava> response) {

                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null)
                    if (response.body().getStatusGetRsp() != null)
                        if (response.body().getStatusGetRsp().getDHCPList() != null)
                            tvCONSUM.setText(String.valueOf(response.body().getStatusGetRsp().getDHCPList().getCount()));
            }

            @Override
            public void onFailure(Call<ResponseSumConnectJava> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    public void getSSID(){
        WirelessGenericConfReq statusGetReq = new WirelessGenericConfReq();
        statusGetReq.setOper("Get");
        Oper oper= new Oper(statusGetReq);
        restApiMifi.getSSID(oper).enqueue(new Callback<ResponseSSIDJava>() {
            @Override
            public void onResponse(Call<ResponseSSIDJava> call, retrofit2.Response<ResponseSSIDJava> response) {

                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null)
                    if (response.body().getWirelessGenericConfRsp() != null)
                        if (response.body().getWirelessGenericConfRsp().getGetGenericConf() != null)
                            if (response.body().getWirelessGenericConfRsp().getGetGenericConf().getList().size() > 0) {
                                tvSSID.setText(response.body().getWirelessGenericConfRsp().getGetGenericConf().getList().get(0).getSSID());
                                tvUbah.setVisibility(View.VISIBLE);
                            }
            }

            @Override
            public void onFailure(Call<ResponseSSIDJava> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    public void changeSSID(String name){
        com.apps.net1.ModelMifi.List list = new com.apps.net1.ModelMifi.List();
        list.setIndex("0");
        list.setSSID(name);
        list.setTechnology("bgn");
        list.setWmm("enable");
        list.setChannelSelect("auto");
        list.setChannel("0");
        list.setIgnoreBroadcast("0");
        list.setTxPower("high");
        list.setMcastRate("20");

        List<com.apps.net1.ModelMifi.List> lists = new ArrayList<>();
        lists.add(list);

        SetGenericConf setGenericConf = new SetGenericConf();
        setGenericConf.setEnabled("enable");
        setGenericConf.setIsolation("enable");
        setGenericConf.setIgnoreBroadcast("0");
        setGenericConf.setLists(lists);

        WirelessGenericConfReq wirelessGenericConfReq = new WirelessGenericConfReq();
        wirelessGenericConfReq.setOper("Set");
        wirelessGenericConfReq.setSetGenericConf(setGenericConf);

        Oper a = new Oper(wirelessGenericConfReq);

        restApiMifi.changeSSID(a).enqueue(new Callback<ResponseSSIDJava>() {
            @Override
            public void onResponse(Call<ResponseSSIDJava> call, retrofit2.Response<ResponseSSIDJava> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null) {
                    if (response.body().getWirelessGenericConfRsp() != null) {
                        alertDialogObject.dismiss();
                        Toast.makeText(MainActivity.this, response.body().getWirelessGenericConfRsp().getRspStatus(), Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (pb != null)
                        pb.setVisibility(View.GONE);
                    if (llChange != null)
                        llChange.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ResponseSSIDJava> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                if (pb != null)
                    pb.setVisibility(View.GONE);
                if (llChange != null)
                    llChange.setVisibility(View.VISIBLE);
                alertDialogObject.dismiss();
                Toast.makeText(MainActivity.this, "Silahkan koneksikan kembali jaringan Anda", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void loginM20(){
        restApiM20.postIMSI("Login", "admin","admin","1547019673").enqueue(new Callback<LoginFirstM20>() {
            @Override
            public void onResponse(Call<LoginFirstM20> call, retrofit2.Response<LoginFirstM20> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                getICCIDM20();
                getSWVersionM20();
                getSSIDNameM20();
                getMACAddrM20();
                getConSumM20();
                getSignalM20();
                if (pbme != null)
                    pbme.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<LoginFirstM20> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void getICCIDM20(){
        restApiM20.getICCID().enqueue(new Callback<ResponICCIDM20>() {
            @Override
            public void onResponse(Call<ResponICCIDM20> call, retrofit2.Response<ResponICCIDM20> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null) {
                    if (response.body().getUiccid() != null)
                        tvICCID.setText(response.body().getUiccid());

                    if (response.body().getIMSI() != null)
                        tvIMSI.setText(response.body().getIMSI());
                    if (response.body().getRsrp() != null)
                        tvRSRP.setText(response.body().getRsrp());
                }
            }

            @Override
            public void onFailure(Call<ResponICCIDM20> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void getSWVersionM20(){
        restApiM20.getSWVersion().enqueue(new Callback<ResponSWVerM20>() {
            @Override
            public void onResponse(Call<ResponSWVerM20> call, retrofit2.Response<ResponSWVerM20> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null)
                    if (response.body().getFwVer() != null)
                        tvVS.setText(response.body().getFwVer());
            }

            @Override
            public void onFailure(Call<ResponSWVerM20> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void getSSIDNameM20(){
        restApiM202.getSSIDName().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                Log.i(TAG, "onResponse: H " + response.headers().toString());
//                Log.i(TAG, "onResponse: B " + response.body());
//                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null) {
                    String a = response.body();
                    String findwat = "document.wireless_basic.mssid_0.value = \"";
                    int b = a.lastIndexOf(findwat);
//                Log.w(TAG, "onResponse: b = "+b );
                    StringBuilder sb = new StringBuilder();
                    do {
//                            Log.i(TAG, "onResponse: bd = "+b);
                        String c = a.substring(b + findwat.length(), b + findwat.length() + 1);
//                            Log.w(TAG, "onResponse: c = "+ c);
                        if (c.equalsIgnoreCase("\"")) {
                            b = 0;
                        } else {
                            sb.append(c);
                            b++;
                        }
                    } while (b != 0);
                    Log.d(TAG, "onResponse: sb = " + sb);
                    tvSSID.setText(sb.toString().replace("\"", ""));
                    tvUbah.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    void getMACAddrM20(){
        restApiM202.getMACADDR().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

//                Log.i(TAG, "onResponse: H " + response.headers().toString());
//                Log.i(TAG, "onResponse: B " + response.body());
//                Log.i(TAG, "onResponse: M " + response.message());

                if (response.body() != null) {
                    String a = response.body();
                    String findwat = "<td class=\"head\" id=\"lMac\">MAC Address</td>";
                    int b = a.lastIndexOf(findwat);
//                Log.w(TAG, "onResponse: b = "+b );
                    StringBuilder sb = new StringBuilder();
                    do {
//                    Log.i(TAG, "onResponse: bd = "+b);
                        String c = a.substring(b + findwat.length() + 6, b + findwat.length() + 6 + 1);
//                    Log.w(TAG, "onResponse: c = "+ c);
                        if (c.equalsIgnoreCase("/")) {
                            b = 0;
                        } else {
                            sb.append(c);
                            b++;
                        }
                    } while (b != 0);
                    Log.d(TAG, "onResponse: sb = " + sb);
                    tvMAC.setText(sb.toString().replace("<td>", "").replace("<", ""));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    void getConSumM20(){
        restApiM202.getCONSUM().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());

                if (response.body() != null) {
                    String a = response.body();
                    String findwat = "<table id=\"div_info_txbf\" width=\"740\" border=\"1\" cellpadding=\"2\" cellspacing=\"1\">";
                    int b = a.lastIndexOf(findwat);
                    int sum = 0;
//                Log.w(TAG, "onResponse: b = "+b );
                    StringBuilder sb = new StringBuilder();
                    do {
//                    Log.i(TAG, "onResponse: bd = "+b);
                        String c = a.substring(b + findwat.length(), b + findwat.length() + 8);
                        String d = a.substring(b + findwat.length(), b + findwat.length() + 5);
//                    Log.w(TAG, "onResponse: cc = "+ c);
//                    Log.w(TAG, "onResponse: dd = "+ d);
                        if (d.equalsIgnoreCase("</tr>")) sum++;
                        if (c.equalsIgnoreCase("</tbody>")) {
                            b = 0;
                        } else {
                            sb.append(c);
                            b++;
                        }
                    } while (b != 0);
                    tvCONSUM.setText(String.valueOf(sum - 1));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    void getSignalM20(){
        restApiM20.getSignal().enqueue(new Callback<ResponSignalM20>() {
            @Override
            public void onResponse(Call<ResponSignalM20> call, retrofit2.Response<ResponSignalM20> response) {

                if (response.body() != null){
                    int signal = Integer.parseInt(response.body().getAntennaValue());
                    if (signal == 1){
                        imgSignal.setImageResource(R.drawable.signal1);
                    }else if (signal == 2){
                        imgSignal.setImageResource(R.drawable.signal2);
                    }else if (signal == 3){
                        imgSignal.setImageResource(R.drawable.signal3);
                    }else if (signal == 4){
                        imgSignal.setImageResource(R.drawable.signal4);
                    }else if (signal == 5){
                        imgSignal.setImageResource(R.drawable.signal5);
                    }else {
                        imgSignal.setImageResource(R.drawable.signal0);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponSignalM20> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    void changeSSIDM20(String ssid){
        restApiM202.changeSSID("setWifi2gBasic", "basic", "2860", "2",
                "2", "2", ssid, "0",
                "", "", "", "",
                "","","", "1",
                "1", "1", "0", "0",
                "1", "1", "1" ,"1",
                "0", "1", "0","1",
                "1","0","1547022264353").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                if (response.body() != null) {
                    if (response.body() != null) {
                        alertDialogObject.dismiss();
                        Toast.makeText(MainActivity.this, "Silahkan koneksikan kembali jaringan Anda", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (pb != null)
                        pb.setVisibility(View.GONE);
                    if (llChange != null)
                        llChange.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                if (pb != null)
                    pb.setVisibility(View.GONE);
                if (llChange != null)
                    llChange.setVisibility(View.VISIBLE);
                alertDialogObject.dismiss();
                Toast.makeText(MainActivity.this, "Silahkan koneksikan kembali jaringan Anda", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void doExit(View v){
        sessionManager.updateNew(true);
        sessionManager.updateDevice("");
        startActivity(new Intent(MainActivity.this, FirstActivity.class));
        finish();
    }

    public void CheckSoftware(View v) {
        restApi3.updateSoftware().enqueue(new Callback<LoginFirst>() {
            @Override
            public void onResponse(Call<LoginFirst> call, retrofit2.Response<LoginFirst> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());
                Toast.makeText(MainActivity.this, "Tidak ditemukan versi terbaru", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginFirst> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void doAction() {
        restApi.loginAction().enqueue(new Callback<LoginFirst>() {
            @Override
            public void onResponse(Call<LoginFirst> call, retrofit2.Response<LoginFirst> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body());
                Log.i(TAG, "onResponse: M " + response.message());

                sCookie = response.headers().get("Set-cookie");
                Log.w(TAG, "onResponse: " + sCookie);
                if (sCookie != null && sCookie.length() > 0) {
                    setRetrofit2();
                }
            }

            @Override
            public void onFailure(Call<LoginFirst> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                pbme.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void doIMSI() {

        final RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.IMSIReq);
        restApi2.postIMSI(requestBody).enqueue(new Callback<ResponIMSI>() {
            @Override
            public void onResponse(Call<ResponIMSI> call, retrofit2.Response<ResponIMSI> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
                tvIMSI.setText(response.body().getCellularInfo().getsIMSI());
                SetSignalStrength(response.body().getCellularInfo().getsRSSI(),
                        response.body().getCellularInfo().getsSysMode(),
                        response.body().getCellularInfo().getsDataMode());
            }

            @Override
            public void onFailure(Call<ResponIMSI> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void doSSID() {

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.SSIDReq);
        restApi2.postSSID(requestBody).enqueue(new Callback<ResponSSID>() {
            @Override
            public void onResponse(Call<ResponSSID> call, retrofit2.Response<ResponSSID> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
                tvSSID.setText(response.body().getWireless().getApo().getWifi24().getSsid0().getsSSID());
                tvUbah.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ResponSSID> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void doSWMAC() {

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.HWMACReq);
        restApi2.postVSMAC(requestBody).enqueue(new Callback<ResponVSMAC>() {
            @Override
            public void onResponse(Call<ResponVSMAC> call, retrofit2.Response<ResponVSMAC> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
                tvVS.setText(response.body().getVersionInfo().getSwVersion());
                tvMAC.setText(response.body().getVersionInfo().getsMac());
                tvCheck.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ResponVSMAC> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });

    }

    public void doConSum() {

        final RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.CONNECTSUMReq);
        restApi2.postConSum(requestBody).enqueue(new Callback<ResponConSum>() {
            @Override
            public void onResponse(Call<ResponConSum> call, retrofit2.Response<ResponConSum> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
                tvCONSUM.setText(String.valueOf(response.body().getClientInfos().size()));
            }

            @Override
            public void onFailure(Call<ResponConSum> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void doICCID() {

        final RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.ICCIDReq);
        restApi2.postICCID(requestBody).enqueue(new Callback<ResponICCID>() {
            @Override
            public void onResponse(Call<ResponICCID> call, retrofit2.Response<ResponICCID> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
                tvICCID.setText(response.body().getsICCID());
            }

            @Override
            public void onFailure(Call<ResponICCID> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    public void doIP() {

        final RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), Constant.IPLANReq);
        restApi2.postIP(requestBody).enqueue(new Callback<ResponIP>() {
            @Override
            public void onResponse(Call<ResponIP> call, retrofit2.Response<ResponIP> response) {
                Log.i(TAG, "onResponse: H " + response.headers().toString());
                Log.i(TAG, "onResponse: B " + response.body().toString());
                Log.i(TAG, "onResponse: M " + response.message());
//                tvIP.setText(response.body().getRouter().getsIP());
                pbme.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponIP> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                pbme.setVisibility(View.GONE);

            }
        });
    }

    public void doChangeSSID(String name) {
        String changeSSID = "<?xml version=1.0 encoding=US-ASCII?> \n" +
                "<RGW>\n" +
                "<param>\n" +
                "<method>call</method>\n" +
                "<session>000</session>\n" +
                "<obj_path>wireless</obj_path>\n" +
                "<obj_method>wifi_set_2.4g</obj_method>\n" +
                "</param>\n" +
                "<wireless>\n" +
                "<wifi_device>0</wifi_device>\n" +
                "<wifi_if_24G>\n" +
                "<switch>on</switch>\n" +
                "<net_mode>11ng</net_mode>\n" +
                "<country>US</country>\n" +
                "<channel>0</channel>\n" +
                "<bandwidth>HT20</bandwidth>\n" +
                "<multi_ssid>1</multi_ssid>\n" +
                "<disabled/>\n" +
                "<hidden>0</hidden>\n" +
                "<isolate>0</isolate>\n" +
                "<ssid>" + name + "</ssid>\n" + // CHANGE THIS
                "<wpa_group_rekey>10</wpa_group_rekey>\n" +
                "<encryption>psk2+ccmp</encryption>\n" +
                "<ssid_index>0</ssid_index>\n" +
                "<key>37207643</key>\n" +
                "</wifi_if_24G>\n" +
                "</wireless>\n" +
                "</RGW>";
        final RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), changeSSID);

        if (restApi2 != null) {
            restApi2.postChangeSSID(requestBody).enqueue(new Callback<ResponChangeSSID>() {
                @Override
                public void onResponse(Call<ResponChangeSSID> call, retrofit2.Response<ResponChangeSSID> response) {
                    Log.i(TAG, "onResponse: H " + response.headers().toString());
                    Log.i(TAG, "onResponse: B " + response.body().toString());
                    Log.i(TAG, "onResponse: M " + response.message());
                    if (response.body() != null) {
                        alertDialogObject.dismiss();
                        Toast.makeText(MainActivity.this, response.body().getWireless().getRespon(), Toast.LENGTH_SHORT).show();
                    } else {
                        if (pb != null)
                            pb.setVisibility(View.GONE);
                        if (llChange != null)
                            llChange.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<ResponChangeSSID> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                    if (pb != null)
                        pb.setVisibility(View.GONE);
                    if (llChange != null)
                        llChange.setVisibility(View.VISIBLE);
                    alertDialogObject.dismiss();
                    Toast.makeText(MainActivity.this, "Silahkan koneksikan kembali jaringan Anda", Toast.LENGTH_LONG).show();

                }
            });
        } else {
            alertDialogObject.dismiss();
            Toast.makeText(MainActivity.this, "Terjadi kesalahan silahkan coba lagi. . .", Toast.LENGTH_SHORT).show();
        }
    }

    public void setRetrofit2() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient clients = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {

                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", "Digest username=admin, realm=Highwmg, nonce=1000, uri=/cgi/xml_action.cgi, response=d2a7bf9ca559b307982c6197bf7ef5a3, qop=auth, nc=00000002, cnonce=46afc1bc34ea5f12")
                        .addHeader("Origin", "http://192.168.0.1")
                        .addHeader("Accept-Encoding", "gzip, deflate")
                        .addHeader("Accept-Language", "en-US,en;q=0.9,id;q=0.8,ms;q=0.7")
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                        .addHeader("Accept", "application/xml, text/xml, */*; q=0.01")
                        .addHeader("Referer", sWeb+"index.html")
                        .addHeader("X-Requested-With", "XMLHttpRequest")
                        .addHeader("Cookie", sCookie)
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Content-Type", "text/plain")
                        .build();
                return chain.proceed(request);
            }
        }).addInterceptor(interceptor).build();


        retrofit2 = new Retrofit.Builder()
                .baseUrl(sWeb)
                .client(clients)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();


        restApi2 = retrofit2.create(RestApi.class);
        doIMSI();
        doSSID();
        doSWMAC();
        doConSum();
        doICCID();
        doIP();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void DoSetPass() {
        android.support.v7.app.AlertDialog.Builder dialogBuilder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
        // Title
        LayoutInflater inflater = getLayoutInflater();
        View viewa = inflater.inflate(R.layout.header_dialog, null);
        dialogBuilder.setCustomTitle(viewa);

        // Body
        LayoutInflater inflaters = getLayoutInflater();
        View viewas = inflaters.inflate(R.layout.item_set_password, null);
        dialogBuilder.setView(viewas);

        final EditText etIP;

        etIP = viewas.findViewById(R.id.etIP);
        etIP.setText(sessionManager.getIP());

        Button btnSave = viewas.findViewById(R.id.btnSetPass);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etIP.getText().toString().length() == 0) {

                    Toast.makeText(MainActivity.this, "Enter IP",
                            Toast.LENGTH_LONG).show();

                } else {
                    sessionManager.updateIP(etIP.getText().toString());

                    Toast.makeText(MainActivity.this, "Success change IP",
                            Toast.LENGTH_LONG).show();
                    alertDialogObject.dismiss();
                }
            }
        });

        //Create alert dialog object via builder
        alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    public void doChangeSSID(View v) {
        final android.support.v7.app.AlertDialog.Builder dialogBuilder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
        // Title
        LayoutInflater inflater = getLayoutInflater();
        View viewa = inflater.inflate(R.layout.header_dialog, null);
        dialogBuilder.setCustomTitle(viewa);

        // Body
        LayoutInflater inflaters = getLayoutInflater();
        View viewas = inflaters.inflate(R.layout.item_set_password, null);
        dialogBuilder.setView(viewas);

        pb = viewas.findViewById(R.id.pro);
        llChange = viewas.findViewById(R.id.llChange);

        final EditText etIP;

        etIP = viewas.findViewById(R.id.etIP);
        etIP.setText(tvSSID.getText().subSequence(5, tvSSID.getText().length()));

        Button btnSave = viewas.findViewById(R.id.btnSetPass);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etIP.getText().toString().length() == 0) {

                    Toast.makeText(MainActivity.this, "Mohon input nama SSID",
                            Toast.LENGTH_LONG).show();

                } else {
                    pb.setVisibility(View.VISIBLE);
                    llChange.setVisibility(View.GONE);
                    if (sessionManager.getKeyDevice().equalsIgnoreCase("R05") ||
                            sessionManager.getKeyDevice().equalsIgnoreCase("R02"))
                        doChangeSSID("Net1-"+etIP.getText().toString());
                    else if (sessionManager.getKeyDevice().equalsIgnoreCase("L150W")||
                            sessionManager.getKeyDevice().equalsIgnoreCase("MifinArgo"))
                        changeSSID("Net1-"+etIP.getText().toString());
                    else
                        changeSSIDM20(etIP.getText().toString());
                }
            }
        });
        Button btnC = viewas.findViewById(R.id.btnCancelPass);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogObject.dismiss();
            }
        });

        //Create alert dialog object via builder
        alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    public void doRefresh(View v){
        d = wifii.getDhcpInfo();
        sWeb = "http://"+intToIp(d.gateway)+"/";
        pbme.setVisibility(View.VISIBLE);
        if (sessionManager.getKeyDevice().equalsIgnoreCase("R05") || sessionManager.getKeyDevice().equalsIgnoreCase("R02"))
            initR05_R02();
         else if (sessionManager.getKeyDevice().equalsIgnoreCase("M20")){
            initM20();
        } else {
            initMifi();
        }
    }

    public void SetSignalStrength(int rssi, int cellularSysNetworkMode, int cellularDataConnMode){
        String rsrp;
        if(rssi == 0){
            rsrp = "N/A";
        } else {
            rsrp = parseFloat(String.valueOf(rssi))-141 + " dBm";
        }

        tvRSRP.setText(rsrp);
        if(0 == cellularSysNetworkMode) {
            imgSignal.setImageResource(R.drawable.signal0);//"images/lte_signal0.png";
        } else if(1 == cellularSysNetworkMode) { //GSM 2G3G
            if(cellularDataConnMode!=1&&cellularDataConnMode!=2&&cellularDataConnMode!=16){
                //3G
                if(rssi < 22){
                    imgSignal.setImageResource(R.drawable.signal0);//"images/lte_signal0.png";
                }else if (rssi < 27)
                    imgSignal.setImageResource(R.drawable.signal1);//"images/lte_signal1.png";
                else if (rssi < 36)
                    imgSignal.setImageResource(R.drawable.signal2);//"images/lte_signal2.png";
                else
                    imgSignal.setImageResource(R.drawable.signal0);//"images/lte_signal3.png";
            }else{
                //2G
                if(rssi < 6){
                    imgSignal.setImageResource(R.drawable.signal0);//"images/lte_signal0.png";
                }else if (rssi < 12)
                    imgSignal.setImageResource(R.drawable.signal1);//"images/lte_signal1.png";
                else if (rssi < 24)
                    imgSignal.setImageResource(R.drawable.signal2);//"images/lte_signal2.png";
                else
                    imgSignal.setImageResource(R.drawable.signal3);//"images/lte_signal3.png";
            }
        }else if (2 == cellularSysNetworkMode) { //LTE
            if(rssi < 21){
                imgSignal.setImageResource(R.drawable.signal0);//"images/lte_signal0.png";
            }else if (rssi < 31)
                imgSignal.setImageResource(R.drawable.signal1);//"images/lte_signal1.png";
            else if (rssi < 41)
                imgSignal.setImageResource(R.drawable.signal2);//"images/lte_signal2.png";
            else
                imgSignal.setImageResource(R.drawable.signal3);//"images/lte_signal3.png";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
