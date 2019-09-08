package com.nehaimgurdemoapp.retrofit;

import android.util.Log;

import com.nehaimgurdemoapp.utils.Constants;

import java.io.IOException;

/**
 * Created by neha on 08/09/19.
 */
public class HeaderInterceptor implements okhttp3.Interceptor {

    private String oAuthParams;

    HeaderInterceptor(String oAuthParams) {
        this.oAuthParams = oAuthParams;

    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Request request = chain.request();
        try {
            request = request.newBuilder().header("Authorization", "Client-ID " + oAuthParams).build();
        } catch (Exception e) {
            Log.e(Constants.TAG, "Error in response---" + e.getMessage(), e);
        }
        return chain.proceed(request);
    }
}
