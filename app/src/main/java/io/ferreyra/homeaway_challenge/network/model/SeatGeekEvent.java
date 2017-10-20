package io.ferreyra.homeaway_challenge.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by carlos on 10/19/17.
 */

@AutoValue
public abstract class SeatGeekEvent implements Parcelable {


    public static TypeAdapter<SeatGeekEvent> typeAdapter(Gson gson) {
        return new $AutoValue_SeatGeekEvent.GsonTypeAdapter(gson);
    }

}
