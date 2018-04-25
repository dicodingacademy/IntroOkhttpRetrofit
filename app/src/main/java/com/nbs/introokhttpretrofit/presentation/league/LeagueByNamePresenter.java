package com.nbs.introokhttpretrofit.presentation.league;

import com.nbs.introokhttpretrofit.data.model.Team;
import com.nbs.introokhttpretrofit.data.request.LeagueByNameRequest;
import com.nbs.introokhttpretrofit.domain.GetLeagueByNameUseCase;

import java.util.ArrayList;

public class LeagueByNamePresenter implements LeagueContract.Presenter, GetLeagueByNameUseCase.OnGetLeagueByNameCallback{

    private LeagueContract.View view;

    private GetLeagueByNameUseCase getLeagueByNameUseCase;

    public LeagueByNamePresenter(LeagueContract.View view, GetLeagueByNameUseCase getLeagueByNameUseCase) {
        this.view = view;
        this.getLeagueByNameUseCase = getLeagueByNameUseCase;
        this.getLeagueByNameUseCase.setOnGetLeagueByNameCallback(this);
    }

    @Override
    public void getLeagueByName(String leagueName) {
        view.showLoading();

        LeagueByNameRequest request = new LeagueByNameRequest();
        request.setLeagueName(leagueName);

        getLeagueByNameUseCase.setBaseRequest(request);
        getLeagueByNameUseCase.execute();
    }

    @Override
    public void onGetLeagueByNameSuccess(ArrayList<Team> list) {
        view.hideLoading();
        view.showData(list);
    }

    @Override
    public void onGetLeagueByNameFailed(String message) {
        view.hideLoading();
        view.onRequestError(message);
    }
}
