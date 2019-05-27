package com.gdc.mysportdb.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class LeagueResponse{

	@SerializedName("leagues")
	private List<Leagues> leagues;

	public void setLeagues(List<Leagues> leagues){
		this.leagues = leagues;
	}

	public List<Leagues> getLeagues(){
		return leagues;
	}
}