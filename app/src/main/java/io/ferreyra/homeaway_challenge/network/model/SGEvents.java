package io.ferreyra.homeaway_challenge.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by carlos on 10/19/17.
 */

@AutoValue
public abstract class SGEvents implements Parcelable {

    public static TypeAdapter<SGEvents> typeAdapter(Gson gson) {
        return new $AutoValue_SGEvents.GsonTypeAdapter(gson);
    }

    @SerializedName("events")
    public abstract List<SGEvent> events();
}
