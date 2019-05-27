package com.gdc.mysportdb.view.team;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.adapter.TeamsAdapter;
import com.gdc.mysportdb.data.ApiClient;
import com.gdc.mysportdb.data.ApiInterface;
import com.gdc.mysportdb.data.model.LeagueResponse;
import com.gdc.mysportdb.data.model.Leagues;
import com.gdc.mysportdb.data.model.Team;
import com.gdc.mysportdb.data.model.TeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Teams extends Fragment implements TeamView{

    View view;
    EditText etLeague;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TeamsAdapter adapter;

    List<Team> teams;
    TeamPresenter presenter;

    String[] leagueName;
//    List<Leagues> leaguesList;

    public Teams() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_teams, container, false);

        initView();

        teams = new ArrayList<>();

        presenter = new TeamPresenter(this);
        presenter.getAllTeams("English Premier League");

        getLeague();

        initListener();

        return view;
    }

    private void initListener() {
        etLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListLeague();
            }
        });
    }

    private void dialogListLeague() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_league, null);
        builder.setView(view);
        final ListView listView = view.findViewById(R.id.listview);

        final AlertDialog dialog = builder.create();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                teams.clear();
                presenter.getAllTeams(leagueName[position]);
                etLeague.setText(leagueName[position]);
                dialog.dismiss();
            }
        });

        ArrayAdapter<String> adapterInner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, leagueName);
        listView.setAdapter(adapterInner);

        dialog.show();
    }

    private void getLeague() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LeagueResponse> call = apiInterface.getLeague();
        call.enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                List<Leagues> league = response.body().getLeagues();

                leagueName = new String[league.size()];

                if (response.isSuccessful()) {
                    for (int i = 0; i < league.size(); i++) {
                        leagueName[i] = league.get(i).getStrLeague();
                    }

                    etLeague.setText(league.get(0).getStrLeague());

                } else {
                    Toast.makeText(getActivity(), "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LeagueResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initView() {
        etLeague = view.findViewById(R.id.et_league);
        recyclerView = view.findViewById(R.id.rv_allTeams);
        progressBar = view.findViewById(R.id.progressbar);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), "" + errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(TeamResponse result) {
        teams.addAll(result.getTeamList());
        adapter = new TeamsAdapter(getActivity(), teams);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
