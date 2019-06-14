package com.gdc.mysportdb.view.team.detail.player_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Player;
import com.squareup.picasso.Picasso;

public class PlayerDetail extends AppCompatActivity {

    private ImageView imgPoster;
    private TextView tvWeight, tvHeight, tvPosition, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

        initListener();
    }

    private void initListener() {
        Player playerName = getIntent().getParcelableExtra("KEY_PLAYER");
        setTitle(playerName.getStrPlayer());
        Picasso.get().load(playerName.getPoster()).placeholder(R.drawable.placeholder).into(imgPoster);

        if (TextUtils.isEmpty(playerName.getStrWeight())) {
            tvWeight.setText("");
        } else if (TextUtils.isEmpty(playerName.getStrHeight())) {
            tvHeight.setText("");
        } else if (TextUtils.isEmpty(playerName.getStrWeight()) && TextUtils.isEmpty(playerName.getStrHeight())) {
            tvWeight.setText("");
            tvHeight.setText("");
        } else {
            tvWeight.setText(playerName.getStrWeight());
            tvHeight.setText(playerName.getStrHeight());
        }

        tvPosition.setText(playerName.getStrPosition());
        tvDescription.setText(playerName.getStrDescriptionEN());
    }

    private void initView() {
        imgPoster = findViewById(R.id.img_playerPoster);
        tvWeight = findViewById(R.id.tv_weight);
        tvHeight = findViewById(R.id.tv_height);
        tvPosition = findViewById(R.id.tv_position);
        tvDescription = findViewById(R.id.tv_description);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
