package io.ferreyra.homeaway_challenge.network.model;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by carlos on 10/20/17.
 */

@GsonTypeAdapterFactory
public abstract class SGAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_SGAdapterFactory();
    }

}
