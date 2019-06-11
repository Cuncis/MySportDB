package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerResponse {
    @SerializedName("player")
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }
}
