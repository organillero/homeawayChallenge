package io.ferreyra.homeaway_challenge.dagger.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.dagger.AppScope;

/**
 * Created by carlos on 10/19/17.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @AppScope
    @Provides
    public Context context(){
        return context;
    }

}
