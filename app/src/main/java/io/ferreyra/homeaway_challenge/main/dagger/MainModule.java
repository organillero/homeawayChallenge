package io.ferreyra.homeaway_challenge.main.dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.main.mvp.MainModel;
import io.ferreyra.homeaway_challenge.main.mvp.MainPresenter;
import io.ferreyra.homeaway_challenge.main.mvp.MainView;
import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;

/**
 * Created by carlos on 10/19/17.
 */

@Module
public class MainModule {

    private final Activity activity;

    public MainModule (Activity activity){
        this.activity = activity;
    }

    @Provides
    @MainScope
    public MainView providesMainView (){
            return new MainView(activity);
    }

    @Provides
    @MainScope
    public MainModel providesMainModel (SeatGeekNetwork seatGeekNetwork){
        return new MainModel(seatGeekNetwork);
    }

    @Provides
    @MainScope
    public MainPresenter providesMainPresenter (MainView view, MainModel model){
        return new MainPresenter(view, model);
    }

}
