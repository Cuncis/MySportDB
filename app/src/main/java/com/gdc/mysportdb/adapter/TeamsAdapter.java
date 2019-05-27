package com.gdc.mysportdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsHolder> {

    private Context context;
    private List<Team> teamList;

    public TeamsAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamsHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);

        return new TeamsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsHolder holder, int i) {
        holder.tvName.setText(teamList.get(i).getStrTeamName());
        Picasso.get().load(teamList.get(i).getStrTeamBadge()).into(holder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class TeamsHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView tvName;

        public TeamsHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_teamLogo);
            tvName = itemView.findViewById(R.id.tv_teamName);
        }
    }

}
