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

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974~5626238148");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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