package com.gdc.mysportdb.view.team;

import com.gdc.mysportdb.data.retrofit.ApiClient;
import com.gdc.mysportdb.data.retrofit.ApiInterface;
import com.gdc.mysportdb.data.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamPresenter {
    private TeamView view;
    private ApiInterface apiInterface;

    public TeamPresenter(TeamView view) {
        this.view = view;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getAllTeams(String leagueName) {
        view.showLoading();
        Call<TeamResponse> call = apiInterface.getTeams(leagueName);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    view.showSuccess(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }
}











