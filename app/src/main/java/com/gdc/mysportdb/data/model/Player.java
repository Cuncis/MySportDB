package com.gdc.mysportdb.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Player implements Parcelable {

    @SerializedName("idPlayer")
    private String idPlayer;

    @SerializedName("strPlayer")
    private String strPlayer;

    @SerializedName("strPosition")
    private String strPosition;

    @SerializedName("strCutout")
    private String playerLogo;

    @SerializedName("strWeight")
    private String strWeight;

    @SerializedName("strHeight")
    private String strHeight;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strFanart1")
    private String poster;

    public Player() {
    }

    protected Player(Parcel in) {
        idPlayer = in.readString();
        strPlayer = in.readString();
        strPosition = in.readString();
        playerLogo = in.readString();
        strWeight = in.readString();
        strHeight = in.readString();
        strDescriptionEN = in.readString();
        poster = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

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

    public String getIdPlayer() {
        return idPlayer;
    }

    public String getStrWeight() {
        return strWeight;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idPlayer);
        dest.writeString(strPlayer);
        dest.writeString(strPosition);
        dest.writeString(playerLogo);
        dest.writeString(strWeight);
        dest.writeString(strHeight);
        dest.writeString(strDescriptionEN);
        dest.writeString(poster);
    }
}
