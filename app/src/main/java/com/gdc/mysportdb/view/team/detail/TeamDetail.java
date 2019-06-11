package com.gdc.mysportdb.view.team.detail;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.adapter.TeamDetailPagerAdapter;
import com.gdc.mysportdb.data.model.Team;
import com.squareup.picasso.Picasso;

public class TeamDetail extends AppCompatActivity {

    boolean FLAG_COLLAPSED = true;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView tvTeamName, tvTeamYear, tvTeamStadium;
    private ImageView imgLogo, btnBack, btnFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        final AppBarLayout appBar = findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBar.getTotalScrollRange()) {
                    FLAG_COLLAPSED = true;
                } else if (verticalOffset == 0) {
                    FLAG_COLLAPSED = false;
                } else {
//                    Toast.makeText(TeamDetail.this, "Just Toast", Toast.LENGTH_SHORT).show();
                }
            }
        });

        initView();

        Team team = getIntent().getParcelableExtra("KEY_TEAM");
        Picasso.get().load(team.getStrTeamBadge()).into(imgLogo);
        tvTeamName.setText(team.getStrTeamName());
        tvTeamStadium.setText(team.getStrStadium());
        tvTeamYear.setText(team.getFormedyear());

        initListener();
        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initListener() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeamDetail.this, "Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tvTeamName = findViewById(R.id.tv_teamName);
        tvTeamYear = findViewById(R.id.tv_teamYear);
        tvTeamStadium = findViewById(R.id.tv_teamStadium);
        imgLogo = findViewById(R.id.img_teamLogo);
        btnBack = findViewById(R.id.btn_back);
        btnFavorite = findViewById(R.id.btn_favorite);
    }

    private void addTabs(ViewPager viewPager) {
        TeamDetailPagerAdapter adapter = new TeamDetailPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Overview(), "Overview");
        adapter.addFrag(new PlayerFrag(), "Player");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (FLAG_COLLAPSED) {
            finish();
        }
        return super.onSupportNavigateUp();
    }
}
