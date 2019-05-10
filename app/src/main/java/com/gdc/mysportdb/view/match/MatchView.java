package com.gdc.mysportdb.view.match;

import com.gdc.mysportdb.data.model.MatchResponse;

public interface MatchView {
    void showLoading();
    void hideLoading();
    void showSuccess(MatchResponse result);
    void showError(String errorMessage);
}
