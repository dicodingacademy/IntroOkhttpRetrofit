package com.nbs.introokhttpretrofit.presentation.richview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public abstract class BaseRichView extends FrameLayout{
    public BaseRichView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public BaseRichView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseRichView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseRichView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public abstract int getRichViewLayout();

    public abstract void bindView(View view);

    protected abstract void parseAttribute(AttributeSet attributeSet);

    protected void init(Context context, AttributeSet attributeSet){
        View view = LayoutInflater.from(context).inflate(getRichViewLayout(),
                this, true);
        bindView(view);
    }
}
