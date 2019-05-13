package com.gdc.mysportdb.view.match;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.adapter.TabMatchAdapter;
import com.gdc.mysportdb.view.match.last_match.LastMatch;
import com.gdc.mysportdb.view.match.next_match.NextMatch;

/**
 * A simple {@link Fragment} subclass.
 */
public class Matches extends Fragment {


    public Matches() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabMatchAdapter adapter = new TabMatchAdapter(getChildFragmentManager());
        adapter.addFragment(new LastMatch(), "Last Match");
        adapter.addFragment(new NextMatch(), "Next Match");
        viewPager.setAdapter(adapter);
    }

}















