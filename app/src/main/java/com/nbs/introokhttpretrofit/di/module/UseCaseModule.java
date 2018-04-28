package com.nbs.introokhttpretrofit.di.module;

import com.nbs.introokhttpretrofit.data.libs.ApiConnection;
import com.nbs.introokhttpretrofit.data.libs.RetrofitLiveData;
import com.nbs.introokhttpretrofit.data.response.LeagueResponse;
import com.nbs.introokhttpretrofit.domain.GetAllLeagueUseCase;
import com.nbs.introokhttpretrofit.domain.GetLeagueByNameUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {
    @Provides
    GetAllLeagueUseCase provideGetAllLeagueUseCase(ApiConnection apiConnection){
        return new GetAllLeagueUseCase(apiConnection);
    }

    @Provides
    GetLeagueByNameUseCase provideGetLeagueByNameUseCase(ApiConnection apiConnection){
        return new GetLeagueByNameUseCase(apiConnection);
    }

    @Provides
    RetrofitLiveData<LeagueResponse> provideLeagueLiveData(ApiConnection apiConnection){
        return new RetrofitLiveData<>(apiConnection.getApiClient().getAllLeagues());
    }
}
