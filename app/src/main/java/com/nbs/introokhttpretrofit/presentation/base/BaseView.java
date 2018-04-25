package com.nbs.introokhttpretrofit.presentation.base;

public interface BaseView {
    void showLoading();

    void hideLoading();

    void onRequestError(String message);
}
