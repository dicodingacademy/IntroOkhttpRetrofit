package com.nbs.introokhttpretrofit.data.libs;

import com.nbs.introokhttpretrofit.data.response.LeagueResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("all_leaguess.php")
    Call<LeagueResponse> getAllLeagues();
}
