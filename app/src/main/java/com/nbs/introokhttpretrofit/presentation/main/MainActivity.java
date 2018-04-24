package com.nbs.introokhttpretrofit.presentation.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nbs.introokhttpretrofit.R;
import com.nbs.introokhttpretrofit.data.model.League;
import com.nbs.introokhttpretrofit.di.component.ApplicationComponent;
import com.nbs.introokhttpretrofit.di.component.DaggerApplicationComponent;
import com.nbs.introokhttpretrofit.di.module.ActivityModule;
import com.nbs.introokhttpretrofit.presentation.richview.LoadingView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        LoadingView.OnButtonRetryClickListener{

    private LoadingView loadingView;

    private TextView tvResponse;

    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = DaggerApplicationComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .build();

        applicationComponent.inject(this);

        loadingView = findViewById(R.id.loading_view);
        loadingView.setOnButtonRetryClickListener(this);

        tvResponse = findViewById(R.id.tv_response);

        getData();
    }

    private void getData() {
        presenter.getAllLeagues();
    }

    @Override
    public void showLoding() {
        loadingView.showHideProgressBar(true);
    }

    @Override
    public void hideLoading() {
        loadingView.showHideProgressBar(false);
    }

    @Override
    public void showData(ArrayList<League> leagues) {
        String strLeagues = "";
        for (League league: leagues){
            strLeagues += league.getStrLeague() + "\n";
        }
        tvResponse.setText(strLeagues);
    }

    @Override
    public void onRequestError(String message) {
        loadingView.showError(message);
    }

    @Override
    public void onButtonRetryClicked() {
        getData();
    }
}
