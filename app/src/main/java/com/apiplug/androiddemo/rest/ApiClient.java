package com.apiplug.androiddemo.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * API Client going to be used while connecting API Plug demo API.
 *
 * @author APIPlug
 * @version v1.0
 *
 */
public class ApiClient {
    private static APIPlug REST_CLIENT;
    private static final String API_URL = "http://sandbox.apiplug.com:8000/demo/v1/"; //Change according to your API path.

    static {
        setupRestClient();
    }

    private ApiClient() {}

    public static APIPlug get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //Uncomment these lines below to start logging each request.

        /*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(APIPlug.class);
    }
}
