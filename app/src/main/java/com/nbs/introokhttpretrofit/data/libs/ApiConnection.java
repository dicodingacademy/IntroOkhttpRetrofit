package com.nbs.introokhttpretrofit.data.libs;

public class ApiConnection {

    private ApiClient apiClient;

    public ApiConnection(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
