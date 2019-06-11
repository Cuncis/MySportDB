package com.gdc.mysportdb.view.team.detail.player_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Player;
import com.squareup.picasso.Picasso;

public class PlayerDetail extends AppCompatActivity {

    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgPoster = findViewById(R.id.img_playerPoster);

        Player playerName = getIntent().getParcelableExtra("KEY_PLAYER");
        setTitle(playerName.getStrPlayer());
        Picasso.get().load(playerName.getPoster()).placeholder(R.drawable.placeholder).into(imgPoster);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
