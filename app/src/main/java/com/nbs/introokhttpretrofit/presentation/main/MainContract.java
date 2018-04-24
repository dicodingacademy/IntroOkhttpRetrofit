package com.nbs.introokhttpretrofit.presentation.main;

import com.nbs.introokhttpretrofit.data.model.League;

import java.util.ArrayList;

public interface MainContract {
    interface View{
        void showLoding();

        void hideLoading();

        void showData(ArrayList<League> leagues);

        void onRequestError(String message);
    }

    interface Presenter{
        void getAllLeagues();

        void cancelRequest();
    }
}
