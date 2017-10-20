package io.ferreyra.homeaway_challenge.eventDetail.dagger;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.homeaway_challenge.eventDetail.mvp.DetailPresenter;
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

    public static final String PREFERENCES_FAVORITE_EVENTS = "PREFERENCES_FAVORITE_EVENTS" ;

    public DetailModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @DetailScope
    public DetailView providesDetailView (Picasso picasso){
        return new DetailView(activity, picasso);
    }

    @Provides
    @DetailScope
    public DetailPresenter providesDetailPresenter (DetailView view, @Named("PREFERENCES_FAVORITE_EVENTS") SharedPreferences preferences){
        return new DetailPresenter(view, preferences);
    }


    @Provides
    @DetailScope
    @Named("PREFERENCES_FAVORITE_EVENTS")
    public SharedPreferences providesSharedPreferences (Context context){
        return context.getSharedPreferences(PREFERENCES_FAVORITE_EVENTS, Context.MODE_PRIVATE);
    }

}
