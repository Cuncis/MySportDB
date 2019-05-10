package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("dateEvent")
    private String date;

    @SerializedName("strHomeTeam")
    private String homeTeam;

    @SerializedName("intHomeScore")
    private String homeScore;

    @SerializedName("strAwayTeam")
    private String awayTeam;

    @SerializedName("intAwayScore")
    private String awayScore;

    public Match() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }
}
