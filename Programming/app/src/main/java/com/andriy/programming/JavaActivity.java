package com.andriy.programming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JavaActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974~5626238148");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.javafx);
                intent.putExtra("txtGuide", R.string.txt_javafx);
                startActivity(intent);
                break;

            case R.id.btn_guide_kotlin:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.kotlin);
                intent.putExtra("txtGuide", R.string.txt_kotlin);
                startActivity(intent);
                break;
        }
    }
}
