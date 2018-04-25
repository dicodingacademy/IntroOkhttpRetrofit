package com.nbs.introokhttpretrofit.presentation.main;

import com.nbs.introokhttpretrofit.data.model.League;
import com.nbs.introokhttpretrofit.data.request.BaseRequest;
import com.nbs.introokhttpretrofit.domain.GetAllLeagueUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter,
        GetAllLeagueUseCase.OnGetAllLeagueCallback{

    MainContract.View view;

    @Inject
    GetAllLeagueUseCase getAllLeagueUseCase;

    @Inject
    public MainPresenter(MainContract.View view, GetAllLeagueUseCase getAllLeagueUseCase) {
        this.view = view;
        this.getAllLeagueUseCase = getAllLeagueUseCase;
        this.getAllLeagueUseCase.setOnGetAllLeagueCallback(this);
    }

    //region GetAllLeagues
    @Override
    public void getAllLeagues() {
        view.showLoading();

        getAllLeagueUseCase.setBaseRequest(new BaseRequest());
        getAllLeagueUseCase.execute();
    }

    @Override
    public void cancelRequest() {
        if (getAllLeagueUseCase != null){
            getAllLeagueUseCase.cancel();
        }
    }

    @Override
    public void onGetAllLeagueSuccess(ArrayList<League> leagues) {
        view.hideLoading();
        view.showData(leagues);
    }

    @Override
    public void onGetAllLeagueFailed(String message) {
        view.hideLoading();
        view.onRequestError(message);
    }
    //endregion GetAllLeagues
}
