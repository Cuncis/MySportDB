package com.gdc.mysportdb.data.retrofit;

import com.gdc.mysportdb.data.model.DetailResponse;
import com.gdc.mysportdb.data.model.LeagueResponse;
import com.gdc.mysportdb.data.model.MatchResponse;
import com.gdc.mysportdb.data.model.PlayerResponse;
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

    @GET("api/v1/json/1/search_all_teams.php")
    Call<TeamResponse> getTeams(@Query("l") String leagueName);

    @GET("api/v1/json/1/all_leagues.php")
    Call<LeagueResponse> getLeague();

    @GET("api/v1/json/1/lookup_all_players.php")
    Call<PlayerResponse> getPlayer(@Query("id") String idTeam);
}















