package com.nbs.introokhttpretrofit.data.response;

import com.google.gson.annotations.SerializedName;
import com.nbs.introokhttpretrofit.data.model.Team;

import java.util.ArrayList;

public class TeamResponse extends BaseResponse{
    @SerializedName("teams")
    private ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
