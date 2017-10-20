package io.ferreyra.homeaway_challenge.eventDetail.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;
import io.ferreyra.homeaway_challenge.main.mvp.MainAdapter;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by carlos on 10/20/17.
 */

@SuppressLint("ViewConstructor")
public class DetailView  extends RelativeLayout {

    public PublishSubject<Boolean> mFavoriteViewClickedSubject = PublishSubject.create();

    public Observable<Boolean> getEventFavoriteViewClickedSubject() {
        return mFavoriteViewClickedSubject.asObservable();
    }

    private final Picasso picasso;

    @BindView(R.id.event_icon)
    ImageView icon;
    @BindView(R.id.event_title)
    TextView title;
    @BindView(R.id.event_location)
    TextView location;
    @BindView(R.id.event_date)
    TextView date;

    @BindView(R.id.event_favorite)
    Switch favorite;

    public DetailView(Activity activity, Picasso picasso) {
        super(activity);
        inflate(getContext(), R.layout.event_row, this);
        ButterKnife.bind(this);
        this.picasso = picasso;

        RxView.clicks(favorite)
                .takeUntil(RxView.detaches(this))
                .map( __ -> favorite.isChecked())
                .subscribe(mFavoriteViewClickedSubject);
    }

    public void setEvent (SGEvent event, Boolean isFavorite){
        title.setText(event.title());
        location.setText(event.venue().city());
        date.setText( DateTimeFormat.mediumDateTime().print(event.date()));

        favorite.setChecked(isFavorite);

        String imagePerformer = event.performers().get(0).image();
        if (imagePerformer != null) {
            this.picasso.load(imagePerformer).into(icon);
        }
    }
}
