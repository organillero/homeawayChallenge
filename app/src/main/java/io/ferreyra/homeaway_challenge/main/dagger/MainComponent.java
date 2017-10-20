package io.ferreyra.homeaway_challenge.main.dagger;

import dagger.Component;
import io.ferreyra.homeaway_challenge.dagger.AppComponent;
import io.ferreyra.homeaway_challenge.main.MainActivity;

/**
 * Created by carlos on 10/19/17.
 */

@MainScope
@Component( modules = {MainModule.class},
            dependencies = AppComponent.class)

public interface MainComponent {
    void inject (MainActivity activity);
}
