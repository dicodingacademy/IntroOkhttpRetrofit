package com.nbs.introokhttpretrofit.presentation.league;

import com.nbs.introokhttpretrofit.data.model.Team;
import com.nbs.introokhttpretrofit.presentation.base.BaseView;

import java.util.ArrayList;

public interface LeagueContract{
    interface View extends BaseView{
        void showData(ArrayList<Team> teams);
    }

    interface Presenter{
        void getLeagueByName(String leagueName);
    }
}
