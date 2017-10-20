package io.ferreyra.homeaway_challenge.dagger.module;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.dagger.AppScope;

/**
 * Created by carlos on 10/19/17.
 */

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson context (){
        return Converters.registerAll(new GsonBuilder())
                .create();

    }
}
