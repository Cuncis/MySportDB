package com.gdc.mysportdb.view.match.next_match;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.adapter.MatchAdapter;
import com.gdc.mysportdb.data.model.Match;
import com.gdc.mysportdb.data.model.MatchResponse;
import com.gdc.mysportdb.utils.Utils;
import com.gdc.mysportdb.view.match.MatchView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextMatch extends Fragment implements MatchView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView tvNotif;

    private List<Match> matchList;
    private MatchAdapter adapter;
    private NextMatchPresenter presenter;

    public NextMatch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_match, container, false);

        tvNotif = view.findViewById(R.id.tv_notif);
        progressBar = view.findViewById(R.id.progressbar);
        recyclerView = view.findViewById(R.id.rv_nextMatch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        matchList = new ArrayList<>();

        presenter = new NextMatchPresenter(this);
        presenter.getNextMatch("4328");

        return view;
    }

    @Override
    public void showLoading() {
        Utils.getVisible(progressBar);
    }

    @Override
    public void hideLoading() {
        Utils.getGone(progressBar);
    }

    @Override
    public void showSuccess(MatchResponse result) {
        try {
            tvNotif.setVisibility(View.GONE);
            matchList.addAll(result.getGetAllMatch());
            adapter = new MatchAdapter(getActivity(), matchList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            tvNotif.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
