package com.nbs.introokhttpretrofit.di.module;

import com.nbs.introokhttpretrofit.BuildConfig;
import com.nbs.introokhttpretrofit.data.libs.ApiClient;
import com.nbs.introokhttpretrofit.data.libs.ApiConnection;
import com.nbs.introokhttpretrofit.data.libs.ApiService;
import com.nbs.introokhttpretrofit.data.libs.OkHttpClientFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApiModule {
    @Provides
    String provideBaseUrl(){
        return BuildConfig.BASE_URL;
    }

    @Provides
    OkHttpClient provideOkhttpClient(){
        return OkHttpClientFactory.create();
    }

    @Provides
    ApiClient provideApiClient(OkHttpClient okHttpClient, String baseUrl){
        return ApiService.createService(ApiClient.class, okHttpClient, baseUrl);
    }

    @Provides
    ApiConnection provideApiConnection(ApiClient apiClient){
        return new  ApiConnection(apiClient);
    }
}
