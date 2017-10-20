package io.ferreyra.homeaway_challenge.eventDetail.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;
import io.ferreyra.homeaway_challenge.main.mvp.MainAdapter;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;

/**
 * Created by carlos on 10/20/17.
 */

@SuppressLint("ViewConstructor")
public class DetailView  extends RelativeLayout {

    private final Picasso picasso;
    @BindView(R.id.event_icon)
    ImageView icon;

    @BindView(R.id.event_title)
    TextView title;
    @BindView(R.id.event_location)
    TextView location;
    @BindView(R.id.event_date)
    TextView date;

    public DetailView(Activity activity, Picasso picasso) {
        super(activity);
        inflate(getContext(), R.layout.event_row, this);
        ButterKnife.bind(this);
        this.picasso = picasso;
    }

    public void setEvent (SGEvent event ){
        title.setText(event.title());
        location.setText(event.venue().city());
        date.setText( DateTimeFormat.mediumDateTime().print(event.date()));

        String imagePerformer = event.performers().get(0).image();
        if (imagePerformer != null) {
            this.picasso.load(imagePerformer).into(icon);
        }

    }



}
