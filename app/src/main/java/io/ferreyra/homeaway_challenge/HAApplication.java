package io.ferreyra.homeaway_challenge.main;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

import io.ferreyra.homeaway_challenge.dagger.AppComponent;
import io.ferreyra.homeaway_challenge.dagger.DaggerAppComponent;
import io.ferreyra.homeaway_challenge.dagger.module.AppModule;

/**
 * Created by carlos on 10/19/17.
 */

public class HAApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        JodaTimeAndroid.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }
}
