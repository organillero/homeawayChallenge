package io.ferreyra.homeaway_challenge.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.ferreyra.homeaway_challenge.eventDetail.Detail;
import io.ferreyra.homeaway_challenge.main.HAApplication;
import io.ferreyra.homeaway_challenge.main.dagger.DaggerMainComponent;
import io.ferreyra.homeaway_challenge.main.dagger.MainModule;
import io.ferreyra.homeaway_challenge.main.mvp.MainPresenter;
import io.ferreyra.homeaway_challenge.main.mvp.MainView;
import io.ferreyra.homeaway_challenge.network.model.SGEvent;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

    public static void start(Context context, SGEvent event) {
        Intent intent = new Intent(context, Detail.class);
        intent.putExtra(Detail.INTENT_SG_EVENT, event);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appComponent( ((HAApplication) this.getApplication()).getComponent() )
                .mainModule(new MainModule(this))
                .build()
                .inject(this)
                ;

        setContentView(view);
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


}
