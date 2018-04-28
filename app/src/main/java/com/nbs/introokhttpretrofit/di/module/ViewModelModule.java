package com.nbs.introokhttpretrofit.di.module;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.nbs.introokhttpretrofit.presentation.mvvmmain.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    private AppCompatActivity activity;

    public ViewModelModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    MainViewModel provideMainViewModel(){
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }
}
