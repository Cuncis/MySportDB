package com.gdc.mysportdb.view.team;

import com.gdc.mysportdb.data.model.LeagueResponse;
import com.gdc.mysportdb.data.model.TeamResponse;

import java.util.List;

public interface TeamView {
    void showLoading();
    void hideLoading();
    void showError(String errorMessage);
    void showSuccess(TeamResponse result);
}
