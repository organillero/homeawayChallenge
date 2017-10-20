package io.ferreyra.homeaway_challenge.main.mvp;

import io.ferreyra.homeaway_challenge.main.dagger.MainModule;
import rx.Subscription;
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

    }

    public void onDestroy() {
        compositeSubscription.clear();
    }

}
