package com.nbs.introokhttpretrofit.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.nbs.introokhttpretrofit.di.component.DaggerApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity{

    private DaggerApplicationComponent.Builder applicationBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         applicationBuilder = DaggerApplicationComponent
                .builder();

         initIntent();
    }

    public DaggerApplicationComponent.Builder getApplicationBuilder() {
        return applicationBuilder;
    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void setTitle(ActionBar actionBar, String title, boolean isChildActivity){
        if (actionBar != null){
            actionBar.setTitle(title);

            if (isChildActivity){
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract void initIntent();
}
