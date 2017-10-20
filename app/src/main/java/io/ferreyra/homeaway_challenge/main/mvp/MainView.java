package io.ferreyra.homeaway_challenge.main.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.RelativeLayout;


import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;
import com.jakewharton.rxbinding.support.v7.widget.SearchViewQueryTextEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;
import rx.Observable;

/**
 * Created by carlos on 10/19/17.
 */


@SuppressLint("ViewConstructor")
public class MainView extends RelativeLayout {

    @BindView(R.id.searchV_Events)
    SearchView searchView;

    @BindView(R.id.recyclerV_Events)
    RecyclerView recylerView;

    public MainView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);
    }

    public Observable<SearchViewQueryTextEvent> observeSearchView() {
        return RxSearchView.queryTextChangeEvents(searchView);
    }


    public void setEvents (List<SGEvent> events){
        Log.d("COOL", events.toString() );
    }

}
