package com.nbs.introokhttpretrofit.presentation.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nbs.introokhttpretrofit.R;

public class LoadingView extends BaseRichView {

    private TextView tvErrorMessage;

    private Button btnRetry;

    private ProgressBar progressBar;

    private String errorMessage;

    private boolean needRetry;

    private OnButtonRetryClickListener onButtonRetryClickListener;

    public LoadingView(@NonNull Context context) {
        super(context);
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public OnButtonRetryClickListener getOnButtonRetryClickListener() {
        return onButtonRetryClickListener;
    }

    public void setOnButtonRetryClickListener(OnButtonRetryClickListener onButtonRetryClickListener) {
        this.onButtonRetryClickListener = onButtonRetryClickListener;
    }

    @Override
    protected void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);

        parseAttribute(attributeSet);

        setErrorMessage(errorMessage);
    }

    public void setErrorMessage(String errorMessage){
        tvErrorMessage.setText(errorMessage);
    }

     public void handleWhenNeedRetry(boolean needRetry){
        btnRetry.setVisibility(GONE);
        if (needRetry){
            btnRetry.setVisibility(VISIBLE);
            if (getOnButtonRetryClickListener() != null){
                btnRetry.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvErrorMessage.setVisibility(GONE);
                        btnRetry.setVisibility(GONE);
                        showHideProgressBar(true);

                        getOnButtonRetryClickListener().onButtonRetryClicked();
                    }
                });
            }
        }
    }

    public void showHideProgressBar(boolean isShown){
        progressBar.setVisibility(isShown ? VISIBLE : GONE);
    }

    public void showError(String errorMessage){
        if (!TextUtils.isEmpty(errorMessage)){
            setErrorMessage(errorMessage);
        }

        progressBar.setVisibility(GONE);

        tvErrorMessage.setVisibility(VISIBLE);

        handleWhenNeedRetry(needRetry);
    }

    @Override
    public int getRichViewLayout() {
        return R.layout.richview_loading_view;
    }

    @Override
    public void bindView(View view) {
        tvErrorMessage = view.findViewById(R.id.tv_error_message);
        progressBar = view.findViewById(R.id.progress_bar);
        btnRetry = view.findViewById(R.id.btn_retry);
    }

    @Override
    protected void parseAttribute(AttributeSet attributeSet) {
        if (attributeSet != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,
                    R.styleable.LoadingView);
            try {
                errorMessage = typedArray.getString(R.styleable.LoadingView_error_message);
                needRetry = typedArray.getBoolean(R.styleable.LoadingView_need_retry,
                        false);
            }finally {
                typedArray.recycle();
            }
        }
    }

    public interface OnButtonRetryClickListener{
        void onButtonRetryClicked();
    }

}
