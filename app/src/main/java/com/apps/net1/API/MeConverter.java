package com.apps.net1.API;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */

public class MeConverter extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return JsonConverter.INSTANCE;
    }

    final static class JsonConverter implements Converter<ResponseBody, String> {
        static final JsonConverter INSTANCE = new JsonConverter();

        @Override
        public String convert(ResponseBody responseBody) throws IOException {
            return responseBody.string();
        }
    }
}
