package com.gdc.mysportdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Match;
import com.gdc.mysportdb.utils.Utils;

import java.util.List;

public class LastMatchAdapter extends RecyclerView.Adapter<LastMatchAdapter.MatchHolder> {

    private Context context;
    private List<Match> matches;

    public LastMatchAdapter(Context context, List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_match, parent, false);
        return new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchHolder holder, int position) {
        Match matchList = matches.get(position);
        holder.tvDate.setText(Utils.getDateEvent(matchList.getDate()));
        holder.tvHomeTeam.setText(matchList.getHomeTeam());
        holder.tvHomeScore.setText(matchList.getHomeScore());
        holder.tvAwayTeam.setText(matchList.getAwayTeam());
        holder.tvAwayScore.setText(matchList.getAwayScore());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class MatchHolder extends RecyclerView.ViewHolder {
        private TextView tvDate, tvHomeTeam, tvHomeScore, tvAwayTeam, tvAwayScore;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvHomeTeam = itemView.findViewById(R.id.tv_homeTeam);
            tvHomeScore = itemView.findViewById(R.id.tv_homeScore);
            tvAwayTeam = itemView.findViewById(R.id.tv_awayTeam);
            tvAwayScore = itemView.findViewById(R.id.tv_awayScore);
        }
    }

}
