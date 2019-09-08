package com.nehaimgurdemoapp.retrofit;

import com.nehaimgurdemoapp.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by neha on 10/2/16.
 */
public class ServiceGenerator {

    // set your desired log level
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

    private static Retrofit.Builder builder = new Retrofit.Builder();

    public static <S> S createService(Class<S> serviceClass, final String oAuthParams) {
        // Log.d(Constants.TAG, "client-id---" + oAuthParams);
        if (oAuthParams != null && !oAuthParams.isEmpty()) {
            httpClient.addInterceptor(new HeaderInterceptor(oAuthParams));
        }
        Retrofit retrofit = builder
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit.create(serviceClass);

    }

}
