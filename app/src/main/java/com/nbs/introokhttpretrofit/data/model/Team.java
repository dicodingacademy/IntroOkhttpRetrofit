package com.nbs.introokhttpretrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String id;

    @SerializedName("strTeam")
    private String name;

    @SerializedName("strTeamLogo")
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
