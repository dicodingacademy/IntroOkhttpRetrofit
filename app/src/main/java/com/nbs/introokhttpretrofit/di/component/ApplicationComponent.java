package com.nbs.introokhttpretrofit.di.component;

import com.nbs.introokhttpretrofit.di.PerActivity;
import com.nbs.introokhttpretrofit.di.module.ActivityModule;
import com.nbs.introokhttpretrofit.di.module.ApiModule;
import com.nbs.introokhttpretrofit.di.module.UseCaseModule;
import com.nbs.introokhttpretrofit.presentation.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = {ApiModule.class, ActivityModule.class, UseCaseModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
