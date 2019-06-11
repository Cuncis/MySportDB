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
import com.gdc.mysportdb.data.model.Player;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerHolder> {

    private Context context;
    private List<Player> playerList;

    public PlayerAdapter(Context context, List<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_player, viewGroup, false);
        return new PlayerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerHolder holder, int position) {
        Player player = playerList.get(position);
        holder.tvPlayerName.setText(player.getStrPlayer());
        holder.tvPlayerPosition.setText(player.getStrPosition());
        Picasso.get().load(player.getPlayerLogo()).into(holder.imgPlayerPoster);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class PlayerHolder extends RecyclerView.ViewHolder {
        private ImageView imgPlayerPoster;
        private TextView tvPlayerName, tvPlayerPosition;

        public PlayerHolder(@NonNull View itemView) {
            super(itemView);
            imgPlayerPoster = itemView.findViewById(R.id.img_playerPoster);
            tvPlayerName = itemView.findViewById(R.id.tv_playerName);
            tvPlayerPosition = itemView.findViewById(R.id.tv_playerPosition);
        }
    }

}
