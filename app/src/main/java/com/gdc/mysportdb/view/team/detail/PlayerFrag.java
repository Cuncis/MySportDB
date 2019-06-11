package com.gdc.mysportdb.view.team.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.adapter.PlayerAdapter;
import com.gdc.mysportdb.data.model.PlayerResponse;
import com.gdc.mysportdb.data.model.Team;
import com.gdc.mysportdb.data.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFrag extends Fragment implements PlayerView {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    PlayerAdapter adapter;
    List<Player> players;
    PlayerPresenter presenter;

    public PlayerFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        recyclerView = view.findViewById(R.id.rv_player);
        progressBar = view.findViewById(R.id.progressbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        players = new ArrayList<>();

        Team team = getActivity().getIntent().getParcelableExtra("KEY_TEAM");
        presenter = new PlayerPresenter(this);
        presenter.getAllPlayer(team.getIdTeam());

        Log.d("_logPlayer", "onCreateView: " + team.getIdTeam());

        return view;
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
    public void showSuccess(PlayerResponse result) {
        players.addAll(result.getPlayerList());
        adapter = new PlayerAdapter(getActivity(), players);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), "Error: " + errorMessage , Toast.LENGTH_SHORT).show();
    }
}
