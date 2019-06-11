package com.gdc.mysportdb.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class LeagueResponse{

	@SerializedName("leagues")
	private List<League> leagues;

	public void setLeagues(List<League> leagues){
		this.leagues = leagues;
	}

	public List<League> getLeagues(){
		return leagues;
	}
}