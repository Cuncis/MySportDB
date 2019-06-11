package com.gdc.mysportdb.view.team.detail;

import android.widget.ProgressBar;

import com.gdc.mysportdb.data.model.PlayerResponse;
import com.gdc.mysportdb.data.retrofit.ApiClient;
import com.gdc.mysportdb.data.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerPresenter {
    private PlayerView view;
    private ApiInterface apiInterface;

    public PlayerPresenter(PlayerView view) {
        this.view = view;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getAllPlayer(String idTeam) {
        view.showLoading();
        Call<PlayerResponse> call = apiInterface.getPlayer(idTeam);
        call.enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    view.showSuccess(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }
}
