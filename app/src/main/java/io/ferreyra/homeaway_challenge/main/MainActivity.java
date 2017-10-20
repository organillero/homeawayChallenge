package io.ferreyra.homeaway_challenge.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.ferreyra.homeaway_challenge.main.HAApplication;
import io.ferreyra.homeaway_challenge.main.dagger.DaggerMainComponent;
import io.ferreyra.homeaway_challenge.main.dagger.MainModule;
import io.ferreyra.homeaway_challenge.main.mvp.MainPresenter;
import io.ferreyra.homeaway_challenge.main.mvp.MainView;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

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
