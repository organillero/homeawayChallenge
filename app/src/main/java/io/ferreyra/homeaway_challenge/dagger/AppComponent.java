package io.ferreyra.homeaway_challenge.dagger;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Component;
import io.ferreyra.homeaway_challenge.dagger.module.AppModule;
import io.ferreyra.homeaway_challenge.dagger.module.GsonModule;
import io.ferreyra.homeaway_challenge.dagger.module.NetworkModule;
import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;
import okhttp3.OkHttpClient;

/**
 * Created by carlos on 10/19/17.
 */

@AppScope
@Component(modules = { AppModule.class , NetworkModule.class, GsonModule.class})
public interface  AppComponent {

    Context context();
    OkHttpClient okhttpClient();
    //SeatGeekNetwork seatWeekNetwork();
    //Picasso picasso();
}
