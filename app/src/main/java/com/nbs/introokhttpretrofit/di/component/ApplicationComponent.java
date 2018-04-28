package com.nbs.introokhttpretrofit.di.component;

import com.nbs.introokhttpretrofit.di.PerActivity;
import com.nbs.introokhttpretrofit.di.module.ActivityModule;
import com.nbs.introokhttpretrofit.di.module.ApiModule;
import com.nbs.introokhttpretrofit.di.module.UseCaseModule;
import com.nbs.introokhttpretrofit.di.module.ViewModelModule;
import com.nbs.introokhttpretrofit.presentation.league.LeagueByNameActivity;
import com.nbs.introokhttpretrofit.presentation.main.MainActivity;
import com.nbs.introokhttpretrofit.presentation.mvvmmain.MainViewModel;
import com.nbs.introokhttpretrofit.presentation.mvvmmain.MvvmMainActivity;

import dagger.Component;

@PerActivity
@Component(modules = {ApiModule.class, ActivityModule.class, UseCaseModule.class, ViewModelModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LeagueByNameActivity leagueByNameActivity);

    void inject(MvvmMainActivity mvvmMainActivity);
}
