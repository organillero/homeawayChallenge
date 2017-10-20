package io.ferreyra.homeaway_challenge.main.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by carlos on 10/20/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Picasso picasso;

    public MainAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    private List<SGEvent> events = new ArrayList<>();


    public PublishSubject<SGEvent> mViewClickSubject = PublishSubject.create();

    public Observable<SGEvent> getEventViewClickedObservable() {
        return mViewClickSubject.asObservable();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_icon)
        public ImageView imageView;
        @BindView(R.id.event_title)
        public TextView title;
        @BindView(R.id.event_location)
        public TextView location;
        @BindView(R.id.event_date)
        public TextView date;
        @BindView(R.id.event_favorite)
        public Switch favorite;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.event_row, parent, false);

        ViewHolder vh = new ViewHolder(v);

        RxView.clicks(v)
                .takeUntil(RxView.detaches(parent))
                .map( __ -> (SGEvent)vh.itemView.getTag())
                .subscribe(mViewClickSubject);

        return vh;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        String imagePerformer = events.get(position).performers().get(0).image();

        if (imagePerformer != null) {
            this.picasso.load(imagePerformer).into(holder.imageView);
        }

        holder.title.setText(events.get(position).title());
        holder.location.setText(events.get(position).venue().city());
        holder.date.setText(DateTimeFormat.mediumDateTime().print(events.get(position).date()));

        holder.itemView.setTag(events.get(position));
        holder.favorite.setVisibility(View.GONE);
    }


    public void setEvents(List<SGEvent> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        mViewClickSubject.onCompleted();
    }
}
