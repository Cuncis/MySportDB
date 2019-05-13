package com.gdc.mysportdb.view.match.detail;

import com.gdc.mysportdb.data.model.DetailResponse;
import com.gdc.mysportdb.data.model.TeamResponse;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void showSuccess(DetailResponse result);
    void showHomeLogo(TeamResponse result);
    void showAwayLogo(TeamResponse result);
    void showError(String errorMessage);
}
