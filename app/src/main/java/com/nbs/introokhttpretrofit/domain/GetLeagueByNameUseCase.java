package com.nbs.introokhttpretrofit.domain;

import com.nbs.introokhttpretrofit.data.libs.ApiConnection;
import com.nbs.introokhttpretrofit.data.model.Team;
import com.nbs.introokhttpretrofit.data.request.LeagueByNameRequest;
import com.nbs.introokhttpretrofit.data.response.TeamResponse;

import java.util.ArrayList;

import retrofit2.Call;

public class GetLeagueByNameUseCase extends UseCase<LeagueByNameRequest, TeamResponse>{

    private OnGetLeagueByNameCallback onGetLeagueByNameCallback;

    public GetLeagueByNameUseCase(ApiConnection apiConnection) {
        super(apiConnection);
    }

    public OnGetLeagueByNameCallback getOnGetLeagueByNameCallback() {
        return onGetLeagueByNameCallback;
    }

    public void setOnGetLeagueByNameCallback(OnGetLeagueByNameCallback onGetLeagueByNameCallback) {
        this.onGetLeagueByNameCallback = onGetLeagueByNameCallback;
    }

    @Override
    Call<TeamResponse> getApi() {
        setApiCall(apiConnection.getApiClient().getLeagueByName(getBaseRequest().getLeagueName()));
        return getApiCall();
    }

    @Override
    void onResponseEmpty() {
        getOnGetLeagueByNameCallback().onGetLeagueByNameFailed("No Data");
    }

    @Override
    void onResponseReceived(TeamResponse responseBody) {
        getOnGetLeagueByNameCallback().onGetLeagueByNameSuccess(responseBody.getTeams());
    }

    @Override
    void onErrorResponse(String message) {
        getOnGetLeagueByNameCallback().onGetLeagueByNameFailed(message);
    }

    @Override
    void onNoInternetConnection() {

    }

    public interface OnGetLeagueByNameCallback{
        void onGetLeagueByNameSuccess(ArrayList<Team> list);

        void onGetLeagueByNameFailed(String message);
    }
}
