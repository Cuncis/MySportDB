package com.gdc.mysportdb.view.team;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdc.mysportdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Teams extends Fragment {


    public Teams() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        return view;
    }

}