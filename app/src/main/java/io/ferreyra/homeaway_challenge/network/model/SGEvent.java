package io.ferreyra.homeaway_challenge.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by carlos on 10/19/17.
 */

@AutoValue
public abstract class SGEvent implements Parcelable {


    public static TypeAdapter<SGEvent> typeAdapter(Gson gson) {
        return new $AutoValue_SGEvent.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract String id();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("visible_until_utc")
    public abstract DateTime date();

    @SerializedName("venue")
    public abstract SGVenue venue();

    @SerializedName("performers")
    public abstract List<SGPerformer> performers();




}