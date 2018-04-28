package com.nbs.introokhttpretrofit.presentation.mvvmmain;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.nbs.introokhttpretrofit.R;
import com.nbs.introokhttpretrofit.data.libs.RetrofitLiveData;
import com.nbs.introokhttpretrofit.data.model.League;
import com.nbs.introokhttpretrofit.data.response.LeagueResponse;
import com.nbs.introokhttpretrofit.di.module.ActivityModule;
import com.nbs.introokhttpretrofit.di.module.ViewModelModule;
import com.nbs.introokhttpretrofit.presentation.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MvvmMainActivity extends BaseActivity {

    private TextView tvMain;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    RetrofitLiveData<LeagueResponse> retrofitLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_main);

        getApplicationBuilder()
                .activityModule(new ActivityModule())
                .viewModelModule(new ViewModelModule(this))
                .build().inject(this);

        tvMain = findViewById(R.id.tv_test);

        mainViewModel.setRetrofitLiveData(retrofitLiveData);
        mainViewModel.getRetrofitLiveData().observe(this, leagueResponse -> {
            List<League> leagues = leagueResponse.getLeagues();
            String text = "";
            for (League l: leagues){
                text += l.getStrLeague() +"\n";
            }
            tvMain.setText(text);
        });
    }

    @Override
    protected void initIntent() {

    }
}
