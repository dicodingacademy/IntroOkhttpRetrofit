package com.nbs.introokhttpretrofit.presentation.mvvmmain;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.nbs.introokhttpretrofit.data.libs.RetrofitLiveData;
import com.nbs.introokhttpretrofit.data.response.LeagueResponse;

public class MainViewModel extends AndroidViewModel{

    private RetrofitLiveData<LeagueResponse> retrofitLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRetrofitLiveData(RetrofitLiveData<LeagueResponse> retrofitLiveData) {
        this.retrofitLiveData = retrofitLiveData;
    }

    public RetrofitLiveData<LeagueResponse> getRetrofitLiveData() {
        return retrofitLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        retrofitLiveData.cancel();
    }
}
