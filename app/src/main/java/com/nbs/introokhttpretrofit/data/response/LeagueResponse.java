package com.nbs.introokhttpretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.nbs.introokhttpretrofit.data.model.League;

import java.util.ArrayList;

public class LeagueResponse extends BaseResponse{
    @SerializedName("leagues")
    private ArrayList<League> leagues = new ArrayList<>();

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }
}
