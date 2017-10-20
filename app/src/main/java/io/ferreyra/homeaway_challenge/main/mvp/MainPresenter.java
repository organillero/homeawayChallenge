package io.ferreyra.homeaway_challenge.main.mvp;

import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.ferreyra.homeaway_challenge.main.dagger.MainModule;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by carlos on 10/19/17.
 */

public class MainPresenter {

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    private final MainView view;
    private final MainModel model;

    public MainPresenter(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }


    public void onCreate() {
        compositeSubscription.add(observeSearchView());
    }

    public void onDestroy() {
        compositeSubscription.clear();
    }

    private Subscription observeSearchView() {
        return view.observeSearchView()
                .debounce(100, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .switchMap(s -> model.getEvents(s.queryText().toString()))
                .concatMap(sgEvents -> Observable.just(sgEvents.events()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        swEventsList -> {
                            view.setEvents(swEventsList);
                        },
                        error -> {
                            Log.e("Error", error.getLocalizedMessage());
                        }
                );
    }
}
