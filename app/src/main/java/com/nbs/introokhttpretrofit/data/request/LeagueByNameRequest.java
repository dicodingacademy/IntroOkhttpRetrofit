package com.nbs.introokhttpretrofit.data.request;

public class LeagueByNameRequest extends BaseRequest{
    private String leagueName;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
