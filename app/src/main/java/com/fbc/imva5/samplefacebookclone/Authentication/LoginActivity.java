package com.fbc.imva5.samplefacebookclone.Authentication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fbc.imva5.samplefacebookclone.R;

public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    //activity widgets
    private TextView registerTextView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = LoginActivity.this;
        initWidgets();
        handleClickEvent();
    }


    public void initWidgets() {
        registerTextView = findViewById(R.id.register_button_LA);
    }

    public void handleClickEvent() {

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });


    }
}
