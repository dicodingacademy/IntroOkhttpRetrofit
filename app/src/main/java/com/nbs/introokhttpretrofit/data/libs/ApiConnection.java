package com.nbs.introokhttpretrofit.data.libs;

import com.nbs.introokhttpretrofit.BuildConfig;

public class ApiConnection {

    public ApiClient getApiClient(){
        return ApiService.createService(ApiClient.class, OkHttpClientFactory.create(),
                BuildConfig.BASE_URL);
    }
}
