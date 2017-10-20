package io.ferreyra.homeaway_challenge.home;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by carlos on 10/19/17.
 */

public class HAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        JodaTimeAndroid.init(this);
    }
}
