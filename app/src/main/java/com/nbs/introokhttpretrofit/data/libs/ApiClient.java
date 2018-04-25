package com.nbs.introokhttpretrofit.data.libs;

import com.nbs.introokhttpretrofit.data.response.LeagueResponse;
import com.nbs.introokhttpretrofit.data.response.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("all_leagues.php")
    Call<LeagueResponse> getAllLeagues();

    @GET("search_all_teams.php")
    Call<TeamResponse> getLeagueByName(@Query("l") String leagueName);
}
