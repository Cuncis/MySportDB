package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamResponse {
    @SerializedName("teams")
    private List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }
}
