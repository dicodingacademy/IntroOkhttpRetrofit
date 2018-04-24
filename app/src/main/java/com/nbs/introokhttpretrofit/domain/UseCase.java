package com.nbs.introokhttpretrofit.domain;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.nbs.introokhttpretrofit.data.libs.ApiConnection;
import com.nbs.introokhttpretrofit.data.request.BaseRequest;
import com.nbs.introokhttpretrofit.data.response.ApiError;
import com.nbs.introokhttpretrofit.data.response.BaseResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class UseCase<T extends BaseRequest, D extends BaseResponse> {

    private T baseRequest;

    private Call<D> apiCall;

    protected ApiConnection apiConnection;

    public T getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(T baseRequest) {
        this.baseRequest = baseRequest;
    }

    public UseCase() {
        apiConnection = new ApiConnection();
    }

    protected Call<D> getApiCall() {
        return apiCall;
    }

    abstract Call<D> getApi();

    public void execute() {
        getApi().enqueue(new Callback<D>() {
            @Override
            public void onResponse(Call<D> call, Response<D> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && (response.code() != 204)) {
                        onResponseReceived(response.body());
                    } else if (response.body() == null || response.code() == 204 ) {
                        onResponseEmpty();
                    }
                } else {
                    onErrorResponse(getErrorMessage(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<D> call, Throwable t) {
                onErrorResponse(t.getMessage());
            }
        });
    }

    public void cancel(){
        if (apiCall != null){
            if (apiCall.isExecuted()){
                apiCall.cancel();
            }
        }
    }

    public void setApiCall(Call<D> apiCall) {
        this.apiCall = apiCall;
    }

    private String getErrorMessage(ResponseBody errorBody) {
        try {
            String errorResponse = errorBody.string();
            if (errorResponse.contains("DOCTYPE")) {
                return "";
            }else{
                return new Gson().fromJson(errorResponse, ApiError.class).getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    abstract void onResponseEmpty();

    abstract void onResponseReceived(D responseBody);

    abstract void onErrorResponse(String message);

    abstract void onNoInternetConnection();

}
