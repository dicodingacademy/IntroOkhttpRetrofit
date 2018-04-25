package com.nbs.introokhttpretrofit.presentation.main;

import com.nbs.introokhttpretrofit.data.model.League;
import com.nbs.introokhttpretrofit.presentation.base.BaseView;

import java.util.ArrayList;

public interface MainContract {
    interface View extends BaseView{

        void showData(ArrayList<League> leagues);

    }

    interface Presenter{
        void getAllLeagues();

        void cancelRequest();
    }
}
