package com.nbs.introokhttpretrofit.di.module;

import com.nbs.introokhttpretrofit.domain.GetAllLeagueUseCase;
import com.nbs.introokhttpretrofit.domain.GetLeagueByNameUseCase;
import com.nbs.introokhttpretrofit.presentation.league.LeagueByNamePresenter;
import com.nbs.introokhttpretrofit.presentation.league.LeagueContract;
import com.nbs.introokhttpretrofit.presentation.main.MainContract;
import com.nbs.introokhttpretrofit.presentation.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private MainContract.View view;

    private LeagueContract.View leagueByNameView;

    public ActivityModule() {
    }

    public ActivityModule(MainContract.View view) {
        this.view = view;
    }

    public ActivityModule(LeagueContract.View leagueByNameView) {
        this.leagueByNameView = leagueByNameView;
    }

    @Provides
    MainContract.View provideView(){
        return view;
    }

    @Provides
    LeagueContract.View provideLeagueByNameView(){
        return leagueByNameView;
    }

    @Provides
    MainContract.Presenter providePresenter(GetAllLeagueUseCase getAllLeagueUseCase, MainContract.View view){
        return new MainPresenter(view, getAllLeagueUseCase);
    }

    @Provides
    LeagueContract.Presenter provideLeagueByNamePresenter(GetLeagueByNameUseCase getLeagueByNameUseCase, LeagueContract.View view){
        return new LeagueByNamePresenter(view, getLeagueByNameUseCase);
    }
}
