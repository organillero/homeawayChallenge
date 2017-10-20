package io.ferreyra.homeaway_challenge.main.mvp;

import android.app.Activity;

import java.util.List;

import io.ferreyra.homeaway_challenge.network.SeatGeekNetwork;
import io.ferreyra.homeaway_challenge.network.model.SGEvents;
import rx.Observable;

/**
 * Created by carlos on 10/19/17.
 */

public class MainModel {

    private final SeatGeekNetwork seatGeekNetwork;

    public MainModel(SeatGeekNetwork seatGeekNetwork){
        this.seatGeekNetwork = seatGeekNetwork;
    }
    public Observable<SGEvents> getEvents(String query) {
        return seatGeekNetwork.getEvents(query);
    }

}
