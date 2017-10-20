package io.ferreyra.homeaway_challenge.eventDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;
import io.ferreyra.homeaway_challenge.eventDetail.dagger.DaggerDetailComponent;
import io.ferreyra.homeaway_challenge.eventDetail.dagger.DetailModule;
import io.ferreyra.homeaway_challenge.eventDetail.mvp.DetailView;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;

/**
 * Created by carlos on 10/20/17.
 */


public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_SG_EVENT = "io.ferreyra.homeaway_challenge.eventDetail.SG_EVENT";

    @Inject
    DetailView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);


        DaggerDetailComponent.builder()
                .appComponent( ((io.ferreyra.homeaway_challenge.main.HAApplication) this.getApplication()).getComponent() )
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            SGEvent event = (SGEvent)extras.get(INTENT_SG_EVENT);
            view.setEvent (event);
        }

        setContentView(view);
    }

}
