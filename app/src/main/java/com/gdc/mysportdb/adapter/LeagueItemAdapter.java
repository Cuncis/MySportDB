package com.gdc.mysportdb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gdc.mysportdb.data.model.Leagues;

import java.util.List;

public class LeagueItemAdapter extends BaseAdapter {

    Context context;
    List<Leagues> leagues;
    RecyclerView.ViewHolder holder = null;

    public LeagueItemAdapter(Context context, List<Leagues> leagues) {
        this.context = context;
        this.leagues = leagues;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
