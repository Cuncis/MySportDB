package com.gdc.mysportdb.view.team.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Team;

/**
 * A simple {@link Fragment} subclass.
 */
public class Overview extends Fragment {

    private TextView tvOverview;

    public Overview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        tvOverview = view.findViewById(R.id.tv_overview);

        Team team = getActivity().getIntent().getParcelableExtra("KEY_TEAM");
        tvOverview.setText(team.getStrDescriptionEN());

        return view;
    }

}
