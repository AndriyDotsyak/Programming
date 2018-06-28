package com.andriy.programming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_java, R.id.btn_c_net, R.id.btn_web})
    void onSaveClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btn_java:
                intent = new Intent("android.intent.Java");
                startActivity(intent);
                break;

            case R.id.btn_c_net:
                intent = new Intent("android.intent.CNet");
                startActivity(intent);
                break;

            case R.id.btn_web:
                intent = new Intent("android.intent.WEB");
                startActivity(intent);
                break;
        }
    }
}