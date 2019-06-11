package com.gdc.mysportdb.data.model;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("strPlayer")
    private String strPlayer;

    @SerializedName("strPosition")
    private String strPosition;

    @SerializedName("strCutout")
    private String playerLogo;

    public Player() {
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public String getPlayerLogo() {
        return playerLogo;
    }

    public void setPlayerLogo(String playerLogo) {
        this.playerLogo = playerLogo;
    }
}
