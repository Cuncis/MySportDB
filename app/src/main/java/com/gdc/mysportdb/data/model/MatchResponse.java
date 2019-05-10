package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchResponse {

    @SerializedName("events")
    private List<Match> getAllMatch;

    public List<Match> getGetAllMatch() {
        return getAllMatch;
    }
}
