package com.gdc.mysportdb.view.match;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdc.mysportdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NextMatch extends Fragment {


    public NextMatch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_match, container, false);
        return view;
    }

}
