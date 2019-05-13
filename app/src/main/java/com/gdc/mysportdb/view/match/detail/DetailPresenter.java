package com.gdc.mysportdb.view.match.detail;

import com.gdc.mysportdb.data.ApiClient;
import com.gdc.mysportdb.data.ApiInterface;
import com.gdc.mysportdb.data.model.DetailResponse;
import com.gdc.mysportdb.data.model.TeamResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;
    private ApiInterface apiInterface;

    public DetailPresenter(DetailView view) {
        this.view = view;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getMatchDetail(String idEvent) {
        view.showLoading();
        Call<DetailResponse> call = apiInterface.getMatchDetail(idEvent);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    view.showSuccess(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }

    public void getHomeLogo(String idTeam) {
        Call<TeamResponse> call = apiInterface.getTeam(idTeam);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    view.showHomeLogo(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }

    public void getAwayLogo(String idTeam) {
        Call<TeamResponse> call = apiInterface.getTeam(idTeam);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    view.showAwayLogo(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}
