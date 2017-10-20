package io.ferreyra.homeaway_challenge.network.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;


/**
 * Created by carlos on 10/19/17.
 */

@AutoValue
public abstract class SeatGeekEvents {

    public static TypeAdapter<SeatGeekEvents> typeAdapter(Gson gson) {
        return new AutoValue_SeatGeekEvents.GsonTypeAdapter(gson);
    }

    public abstract List<SeatGeekEvent> events();
}
