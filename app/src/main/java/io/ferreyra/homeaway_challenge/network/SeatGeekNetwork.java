package io.ferreyra.homeaway_challenge.network;

/**
 * Created by carlos on 10/19/17.
 */


import io.ferreyra.homeaway_challenge.network.model.SGEvents;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface SeatGeekNetwork {

    @GET("/2/events")
    Observable<SGEvents> getEvents(@Query("q") String eventName);
}
