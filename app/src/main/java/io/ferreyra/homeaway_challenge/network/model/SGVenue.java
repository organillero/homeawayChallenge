package io.ferreyra.homeaway_challenge.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by carlos on 10/19/17.
 */
@AutoValue
public abstract class SGVenue implements Parcelable {

    public static TypeAdapter<SGVenue> typeAdapter(Gson gson) {
        return new $AutoValue_SGVenue.GsonTypeAdapter(gson);
    }

    @SerializedName("city")
    public abstract String city();

    @SerializedName("name")
    public abstract String name();

}
