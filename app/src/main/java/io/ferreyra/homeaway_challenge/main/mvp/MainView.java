package io.ferreyra.homeaway_challenge.main.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import io.ferreyra.homeaway_challenge.R;

/**
 * Created by carlos on 10/19/17.
 */

@SuppressLint("ViewConstructor")
public class MainView extends RelativeLayout {

    public MainView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);
    }

}
