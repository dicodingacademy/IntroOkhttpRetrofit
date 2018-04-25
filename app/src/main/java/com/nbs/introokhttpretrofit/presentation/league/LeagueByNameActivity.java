package com.nbs.introokhttpretrofit.presentation.league;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nbs.introokhttpretrofit.R;
import com.nbs.introokhttpretrofit.data.model.Team;
import com.nbs.introokhttpretrofit.di.module.ActivityModule;
import com.nbs.introokhttpretrofit.presentation.base.BaseActivity;
import com.nbs.introokhttpretrofit.presentation.richview.LoadingView;

import java.util.ArrayList;

import javax.inject.Inject;

public class LeagueByNameActivity extends BaseActivity implements LeagueContract.View{

    private TextView tvResponse;

    private LoadingView loadingView;

    public static final String BUNDLE_LEAGUE_NAME = "bundle_league_name";

    private String leagueName;

    @Inject
    LeagueContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_by_name);

        getApplicationBuilder().activityModule(new ActivityModule(this))
                .build().inject(this);

        tvResponse = findViewById(R.id.tv_response);
        loadingView = findViewById(R.id.loading_view);

        setTitle(getSupportActionBar(), "Liga Inggris", true);


        presenter.getLeagueByName(leagueName);
    }

    @Override
    protected void initIntent() {
        leagueName = getIntent().getStringExtra(BUNDLE_LEAGUE_NAME);
    }

    @Override
    public void showLoading() {
        loadingView.showHideProgressBar(true);
    }

    @Override
    public void hideLoading() {
        loadingView.showHideProgressBar(false);
    }

    @Override
    public void onRequestError(String message) {
        loadingView.showError(message);
        showToast(message);
    }

    @Override
    public void showData(ArrayList<Team> teams) {
        String response = "";
        for (Team t: teams){
            response += t.getName()+"\n";
        }
        tvResponse.setText(response);
    }

    public static void start(Context context, String name) {
        Intent starter = new Intent(context, LeagueByNameActivity.class);
        starter.putExtra(BUNDLE_LEAGUE_NAME, name);
        context.startActivity(starter);
    }
}
