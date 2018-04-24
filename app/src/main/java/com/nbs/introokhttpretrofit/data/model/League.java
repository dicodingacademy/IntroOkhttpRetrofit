package com.nbs.introokhttpretrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class League {
    @SerializedName("idLeague")
    private String idLeague;

    @SerializedName("strLeague")
    private String strLeague;

    private String strLeagueAlternate;

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }
}
