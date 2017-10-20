package io.ferreyra.homeaway_challenge.eventDetail.mvp;

import android.content.SharedPreferences;
import android.opengl.EGLDisplay;
import android.util.Log;

import io.ferreyra.homeaway_challenge.main.MainActivity;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by carlos on 10/20/17.
 */

public class DetailPresenter {

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    private final DetailView view;
    private final SharedPreferences sharedPreferences;
    private SGEvent event;
    private Boolean favorite;

    public DetailPresenter (DetailView view, SharedPreferences sharedPreferences) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate (){

        view.setEvent(event, loadFavoriteEvent(event.id()));
        compositeSubscription.add(rowClickeSubscription());
    }

    public void onDestroy(){
        compositeSubscription.clear();
    }

    public void setEvent (SGEvent event) {
        this.event = event;
    }

    private Subscription rowClickeSubscription(){
        return view.getEventFavoriteViewClickedSubject()
                .subscribe( isChecked  -> { saveFavoriteEvent(event.id(), isChecked);},
                            error -> { Log.e("Error", error.toString()); }
                );

    }

    private boolean loadFavoriteEvent(String id){
        return sharedPreferences.getInt(id, 0)  == 1 ;
    }

    private void saveFavoriteEvent (String id, boolean ischeked){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (ischeked && !sharedPreferences.contains(id)) {
            editor.putInt(id , 1);
            editor.apply();
        }
        else if ((!ischeked && sharedPreferences.contains(id))) {
            editor.remove(id);
            editor.apply();
        }
    }
}
