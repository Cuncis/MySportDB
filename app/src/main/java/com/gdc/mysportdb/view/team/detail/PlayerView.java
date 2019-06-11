package com.gdc.mysportdb.view.team.detail;

import com.gdc.mysportdb.data.model.PlayerResponse;

import java.util.List;

public interface PlayerView {
    void showLoading();
    void hideLoading();
    void showSuccess(PlayerResponse result);
    void showError(String errorMessage);
}
