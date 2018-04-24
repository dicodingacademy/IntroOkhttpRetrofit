package com.nbs.introokhttpretrofit.presentation.richview;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ValidationRule.TEXT, ValidationRule.EMAIL,
        ValidationRule.CURRENCY, ValidationRule.PHONENUMBER})
@Retention(RetentionPolicy.SOURCE)
public @interface ValidationRule {
    int TEXT = 1;

    int EMAIL = 2;

    int CURRENCY = 3;

    int PHONENUMBER = 4;
}
