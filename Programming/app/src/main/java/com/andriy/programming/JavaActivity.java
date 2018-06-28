package com.andriy.programming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_guide_java, R.id.btn_guide_android, R.id.btn_guide_javafx, R.id.btn_guide_kotlin})
    void onSaveClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_guide_java:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.java);
                intent.putExtra("txtGuide", R.string.txt_java);
                startActivity(intent);
                break;
            case R.id.btn_guide_android:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.android);
                intent.putExtra("txtGuide", R.string.txt_android);
                startActivity(intent);
                break;
            case R.id.btn_guide_javafx:
                break;
            case R.id.btn_guide_kotlin:
                break;
        }
    }
}
