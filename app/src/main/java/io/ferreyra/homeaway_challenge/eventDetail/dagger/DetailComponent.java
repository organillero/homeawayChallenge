package io.ferreyra.homeaway_challenge.eventDetail.dagger;

import dagger.Component;
import io.ferreyra.homeaway_challenge.dagger.AppComponent;
import io.ferreyra.homeaway_challenge.eventDetail.DetailActivity;

/**
 * Created by carlos on 10/20/17.
 */


@DetailScope
@Component( modules = {DetailModule.class},
        dependencies = AppComponent.class)

public interface DetailComponent {
    void inject (DetailActivity activity);
}
