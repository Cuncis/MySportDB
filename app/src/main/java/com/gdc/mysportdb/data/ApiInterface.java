package com.gdc.mysportdb.data;

import com.gdc.mysportdb.data.model.DetailResponse;
import com.gdc.mysportdb.data.model.MatchResponse;
import com.gdc.mysportdb.data.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/v1/json/1/eventspastleague.php")
    Call<MatchResponse> getLastMatch(@Query("id") String id);

    @GET("api/v1/json/1/eventsnextleague.php")
    Call<MatchResponse> getNextMatch(@Query("id") String id);

    @GET("api/v1/json/1/lookupevent.php")
    Call<DetailResponse> getMatchDetail(@Query("id") String idEvent);

    @GET("api/v1/json/1/lookupteam.php")
    Call<TeamResponse> getTeam(@Query("id") String idTeam);
}
