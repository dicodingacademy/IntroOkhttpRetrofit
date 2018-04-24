package com.nbs.introokhttpretrofit.presentation.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.nbs.introokhttpretrofit.R;

public class SinarmasEditTextView extends BaseRichView {
    private TextInputLayout tilSinarmas;

    private EditText edtSinarmas;

    private String textHint;

    @ValidationRule
    private int validationRule;

    private boolean isEmpty = false;

    private boolean isMandatory;

    private String defaultErrorMessage;

    public SinarmasEditTextView(@NonNull Context context) {
        super(context);
    }

    public SinarmasEditTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SinarmasEditTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SinarmasEditTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);

        parseAttribute(attributeSet);

        setHint(textHint);

        showError(defaultErrorMessage);

        handleTextWatcher();
    }

    @Override
    public int getRichViewLayout() {
        return R.layout.richview_sinarmas_edittext;
    }

    @Override
    public void bindView(View view) {
        tilSinarmas = view.findViewById(R.id.til_sinarmas);
        edtSinarmas = view.findViewById(R.id.edt_sinarmas);
    }

    public void handleTextWatcher(){
        edtSinarmas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }

    public String getText(){
        if (!TextUtils.isEmpty(edtSinarmas.getText().toString().trim())){
            return edtSinarmas.getText().toString().trim();
        }else{
            return "";
        }
    }

    public boolean isFieldEmpty(){
        return isEmpty;
    }

    public void setHint(String textHint){
        tilSinarmas.setHint(textHint);
    }

    public void showError(String errorMessage){
        if (isMandatory){
            String err = errorMessage;
            if (TextUtils.isEmpty(errorMessage)){
                err = getContext().getString(R.string.error_message_field_required);
            }
            tilSinarmas.setErrorEnabled(!TextUtils.isEmpty(err));
            tilSinarmas.setError(err);
        }
    }

    public boolean isFieldMandatory(){
        return isMandatory;
    }

    public boolean isValidInput(String value){
        boolean isValid = false;
        switch (validationRule){
            case ValidationRule.TEXT:
                break;

            case ValidationRule.EMAIL:
                break;

            case ValidationRule.CURRENCY:
                break;

            case ValidationRule.PHONENUMBER:
                if (TextUtils.isDigitsOnly(value)){
                    isValid = true;
                }
                break;
        }
        return isValid;
    }

    @Override
    protected void parseAttribute(AttributeSet attributeSet) {
        if (attributeSet != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,
                    R.styleable.SinarmasEditTextView);
            try {
                textHint = typedArray.getString(R.styleable.SinarmasEditTextView_text_hint);
                defaultErrorMessage = typedArray
                        .getString(R.styleable.SinarmasEditTextView_default_error_message);
                isMandatory = typedArray
                        .getBoolean(R.styleable.SinarmasEditTextView_is_mandatory,
                                false);
                validationRule = typedArray
                        .getInteger(R.styleable.SinarmasEditTextView_rule, ValidationRule.TEXT);
            }finally {
                typedArray.recycle();
            }
        }
    }
}
