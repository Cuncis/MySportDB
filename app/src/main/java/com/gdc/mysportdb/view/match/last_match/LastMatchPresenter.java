package com.gdc.mysportdb.view.match.last_match;

import com.gdc.mysportdb.data.ApiClient;
import com.gdc.mysportdb.data.ApiInterface;
import com.gdc.mysportdb.data.model.MatchResponse;
import com.gdc.mysportdb.view.match.MatchView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastMatchPresenter {
    private MatchView view;
    private ApiInterface apiInterface;

    public LastMatchPresenter(MatchView view) {
        this.view = view;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getLastMatch(String id) {
        view.showLoading();
        Call<MatchResponse> call = apiInterface.getMatch(id);
        call.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    view.showSuccess(response.body());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }
}
