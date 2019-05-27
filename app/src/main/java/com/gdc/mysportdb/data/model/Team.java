package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @SerializedName("strTeam")
    private String strTeamName;

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrTeamName() {
        return strTeamName;
    }
}
