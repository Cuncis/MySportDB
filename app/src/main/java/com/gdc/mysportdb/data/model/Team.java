package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    public String getStrTeamBadge() {
        return strTeamBadge;
    }
}
