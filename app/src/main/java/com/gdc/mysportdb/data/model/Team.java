package com.gdc.mysportdb.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @SerializedName("strTeam")
    private String strTeamName;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("intFormedYear")
    private String formedyear;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    protected Team(Parcel in) {
        idTeam = in.readString();
        strTeamBadge = in.readString();
        strTeamName = in.readString();
        strStadium = in.readString();
        formedyear = in.readString();
        strDescriptionEN = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrTeamName() {
        return strTeamName;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getFormedyear() {
        return formedyear;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idTeam);
        dest.writeString(strTeamBadge);
        dest.writeString(strTeamName);
        dest.writeString(strStadium);
        dest.writeString(formedyear);
        dest.writeString(strDescriptionEN);
    }
}
