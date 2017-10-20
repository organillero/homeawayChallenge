package io.ferreyra.homeaway_challenge.dagger.module;

import android.content.Context;
import android.util.Base64;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.dagger.AppScope;
import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by carlos on 10/19/17.
 */

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://api.seatgeek.com";
    private static final String CREDS_ENCODED = "Basic T1RNeU9UWTROSHd4TlRBNE5EWXhOell3TGpFMDpkNmFhMTAxOTY0NTY4MjU3Mjc3ZmFlNmI1YTRlYzQzNWJiMTc2OTg3YzEwMzczM2VhNjJmYjg3MDhjZjk1ZjBi";

    @AppScope
    @Provides
    public Interceptor authInterceptor() {

        return chain -> {

             Request original = chain.request();
            Request.Builder builder = original.newBuilder()
                    .header("Authorization", CREDS_ENCODED)
                    .header("Accept", "application/json");
            Request request = builder.build();
            return chain.proceed(request);
        };
    }

    @AppScope
    @Provides
    public Interceptor logInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @AppScope
    @Provides
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor( authInterceptor() )
                .addInterceptor( logInterceptor() )
                .build();
    }

    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public SeatGeekNetwork seatGeekNetwork(Retrofit retrofit) {
        return retrofit.create(SeatGeekNetwork.class);
    }

    @AppScope
    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

}
