package com.gdc.mysportdb.data;

import com.gdc.mysportdb.data.model.MatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/v1/json/1/eventspastleague.php")
    Call<MatchResponse> getMatch(@Query("id") String id);
}
