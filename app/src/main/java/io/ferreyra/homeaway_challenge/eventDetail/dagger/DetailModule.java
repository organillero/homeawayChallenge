package io.ferreyra.homeaway_challenge.eventDetail.dagger;

import android.app.Activity;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.eventDetail.mvp.DetailView;
import io.ferreyra.homeaway_challenge.main.dagger.MainScope;
import io.ferreyra.homeaway_challenge.main.mvp.MainAdapter;
import io.ferreyra.homeaway_challenge.main.mvp.MainModel;
import io.ferreyra.homeaway_challenge.main.mvp.MainPresenter;
import io.ferreyra.homeaway_challenge.main.mvp.MainView;
import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;

/**
 * Created by carlos on 10/19/17.
 */

@Module
public class DetailModule {

    private final Activity activity;

    public DetailModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @DetailScope
    public DetailView providesDetailView (Picasso picasso){
        return new DetailView(activity, picasso);
    }

}
