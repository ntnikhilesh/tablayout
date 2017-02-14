package com.example.dell.otp;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;




public class NetworkApiGenerator {





    public  static <S> S createService(Class<S> serviceClass)
{

    RequestInterceptor requestInterceptor=new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
               request.addHeader("Accept", "application/json");
            //request.addQueryParam("api_key",apikey);
        }
    };

    OkHttpClient okHttpClient = new OkHttpClient();

    RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint("https://api.stackexchange.com/2.2/")
            .setClient(new OkClient(okHttpClient))
            .setLogLevel(RestAdapter.LogLevel.FULL);
    builder.setRequestInterceptor(requestInterceptor);
    RestAdapter adapter = builder.build();

    return adapter.create(serviceClass);

}
}
