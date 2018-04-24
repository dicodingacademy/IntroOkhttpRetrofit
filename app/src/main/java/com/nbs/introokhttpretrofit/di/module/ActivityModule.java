package com.nbs.introokhttpretrofit.di.module;

import com.nbs.introokhttpretrofit.domain.GetAllLeagueUseCase;
import com.nbs.introokhttpretrofit.presentation.main.MainContract;
import com.nbs.introokhttpretrofit.presentation.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private MainContract.View view;

    public ActivityModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View provideView(){
        return view;
    }

    @Provides
    MainContract.Presenter providePresenter(GetAllLeagueUseCase getAllLeagueUseCase, MainContract.View view){
        return new MainPresenter(view, getAllLeagueUseCase);
    }
}
