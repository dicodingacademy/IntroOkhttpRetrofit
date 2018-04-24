package com.nbs.introokhttpretrofit.domain;

import com.nbs.introokhttpretrofit.data.libs.ApiConnection;
import com.nbs.introokhttpretrofit.data.model.League;
import com.nbs.introokhttpretrofit.data.request.BaseRequest;
import com.nbs.introokhttpretrofit.data.response.LeagueResponse;

import java.util.ArrayList;

import retrofit2.Call;

public class GetAllLeagueUseCase extends UseCase<BaseRequest, LeagueResponse>{

    private OnGetAllLeagueCallback onGetAllLeagueCallback;

    public GetAllLeagueUseCase(ApiConnection apiConnection) {
        super(apiConnection);
    }

    public OnGetAllLeagueCallback getOnGetAllLeagueCallback() {
        return onGetAllLeagueCallback;
    }

    public void setOnGetAllLeagueCallback(OnGetAllLeagueCallback onGetAllLeagueCallback) {
        this.onGetAllLeagueCallback = onGetAllLeagueCallback;
    }

    @Override
    Call<LeagueResponse> getApi() {
        setApiCall(apiConnection.getApiClient().getAllLeagues());
        return getApiCall();
    }

    @Override
    void onResponseEmpty() {
        getOnGetAllLeagueCallback().onGetAllLeagueFailed("No Data");
    }

    @Override
    void onResponseReceived(LeagueResponse responseBody) {
        getOnGetAllLeagueCallback().onGetAllLeagueSuccess(responseBody.getLeagues());
    }

    @Override
    void onErrorResponse(String message) {
        getOnGetAllLeagueCallback().onGetAllLeagueFailed(message);
    }

    @Override
    void onNoInternetConnection() {
        getOnGetAllLeagueCallback().onGetAllLeagueFailed("No internet connection");
    }

    public interface OnGetAllLeagueCallback{
        void onGetAllLeagueSuccess(ArrayList<League> leagues);

        void onGetAllLeagueFailed(String message);
    }
}
