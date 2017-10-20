package io.ferreyra.homeaway_challenge.dagger.module;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.dagger.AppScope;
import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by carlos on 10/19/17.
 */

@Module
public class NetworkModule {

    public static final String BASE_URL = "https://api.seatgeek.com";

    @AppScope
    @Provides
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
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
