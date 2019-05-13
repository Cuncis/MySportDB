package com.gdc.mysportdb.view.match.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gdc.mysportdb.R;
import com.gdc.mysportdb.data.model.Detail;
import com.gdc.mysportdb.data.model.DetailResponse;
import com.gdc.mysportdb.data.model.Team;
import com.gdc.mysportdb.data.model.TeamResponse;
import com.gdc.mysportdb.utils.Utils;
import com.squareup.picasso.Picasso;

public class MatchDetail extends AppCompatActivity implements DetailView {

    private TextView tv_date, tv_homeTeam, tv_awayTeam, tv_homeScore, tv_awayScore, tv_homeGoalDetail, tv_awayGoalDetail,
            tv_homeShots, tv_awayShots, tv_homeLineupKeeper, tv_awayLineupKeeper, tv_homeLineupDefense, tv_awayLineupDefense,
            tv_homeLineupMidfield, tv_awayLineupMidfield, tv_homeLineupForward, tv_awayLineupForward, tv_homeLineupSubstitutes,
            tv_awayLineupSubstitutes;

    private ImageView imgHomeLogo, imgAwayLogo;
    private DetailPresenter presenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        initView();

        String idEvent = getIntent().getStringExtra("ID_EVENT");
        String idHomeTeam = getIntent().getStringExtra("ID_HOME");
        String idAwayTeam = getIntent().getStringExtra("ID_AWAY");

        presenter = new DetailPresenter(this);
        presenter.getMatchDetail(idEvent);
        presenter.getHomeLogo(idHomeTeam);
        presenter.getAwayLogo(idAwayTeam);
    }

    private void initView() {
        progressBar = findViewById(R.id.progressbar);
        tv_date = findViewById(R.id.tv_date);
        tv_homeTeam = findViewById(R.id.tv_homeTeam);
        tv_awayTeam = findViewById(R.id.tv_awayTeam);
        tv_homeScore = findViewById(R.id.tv_homeScore);
        tv_awayScore = findViewById(R.id.tv_awayScore);
        tv_homeGoalDetail = findViewById(R.id.tv_homeGoalDetail);
        tv_awayGoalDetail = findViewById(R.id.tv_awayGoalDetail);
        tv_homeShots = findViewById(R.id.tv_homeShots);
        tv_awayShots = findViewById(R.id.tv_awayShots);
        tv_homeLineupKeeper = findViewById(R.id.tv_homeLineupKeeper);
        tv_awayLineupKeeper = findViewById(R.id.tv_awayLineupKeeper);
        tv_homeLineupDefense = findViewById(R.id.tv_homeLineupDefense);
        tv_awayLineupDefense = findViewById(R.id.tv_awayLineupDefense);
        tv_homeLineupMidfield = findViewById(R.id.tv_homeLineupMidfield);
        tv_awayLineupMidfield = findViewById(R.id.tv_awayLineupMidfield);
        tv_homeLineupForward = findViewById(R.id.tv_homeLineupForward);
        tv_awayLineupForward = findViewById(R.id.tv_awayLineupForward);
        tv_homeLineupSubstitutes = findViewById(R.id.tv_homeLineupSubstitutes);
        tv_awayLineupSubstitutes = findViewById(R.id.tv_awayLineupSubstitutes);

        //team logo
        imgHomeLogo = findViewById(R.id.img_homeTeam);
        imgAwayLogo = findViewById(R.id.img_awayTeam);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(DetailResponse result) {
        Detail detail = result.getEvents().get(0);
        tv_date.setText(Utils.getDateEvent(detail.getDateEvent()));
        tv_homeTeam.setText(detail.getStrHomeTeam());
        tv_awayTeam.setText(detail.getStrAwayTeam());
        tv_homeScore.setText(detail.getIntHomeScore());
        tv_awayScore.setText(detail.getIntAwayScore());
        tv_homeGoalDetail.setText(detail.getStrHomeGoalDetails());
        tv_awayGoalDetail.setText(detail.getStrAwayGoalDetails());
        tv_homeShots.setText(detail.getIntHomeShots());
        tv_awayShots.setText(detail.getIntAwayShots());
        tv_homeLineupKeeper.setText(detail.getStrHomeLineupGoalkeeper());
        tv_awayLineupKeeper.setText(detail.getStrAwayLineupGoalkeeper());
        tv_homeLineupDefense.setText(detail.getStrHomeLineupDefense());
        tv_awayLineupDefense.setText(detail.getStrAwayLineupDefense());
        tv_homeLineupMidfield.setText(detail.getStrHomeLineupMidfield());
        tv_awayLineupMidfield.setText(detail.getStrAwayLineupMidfield());
        tv_homeLineupForward.setText(detail.getStrHomeLineupForward());
        tv_awayLineupForward.setText(detail.getStrAwayFormation());
        tv_homeLineupSubstitutes.setText(detail.getStrHomeLineupSubstitutes());
        tv_awayLineupSubstitutes.setText(detail.getStrAwayLineupSubstitutes());
    }

    @Override
    public void showHomeLogo(TeamResponse result) {
        Picasso.get().load(result.getTeamList().get(0).getStrTeamBadge()).into(imgHomeLogo);
    }

    @Override
    public void showAwayLogo(TeamResponse result) {
        Picasso.get().load(result.getTeamList().get(0).getStrTeamBadge()).into(imgAwayLogo);
    }


    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}











