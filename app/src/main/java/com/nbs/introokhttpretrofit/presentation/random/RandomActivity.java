package com.nbs.introokhttpretrofit.presentation.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nbs.introokhttpretrofit.R;
import com.nbs.introokhttpretrofit.presentation.richview.SinarmasEditTextView;

public class RandomActivity extends AppCompatActivity {

    private Button btnSubmit;

    private SinarmasEditTextView name, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        name = findViewById(R.id.input_name);
        alamat = findViewById(R.id.input_alamat);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.isFieldEmpty()){
                    Toast.makeText(RandomActivity.this,
                            name.getText()+" "+alamat.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
