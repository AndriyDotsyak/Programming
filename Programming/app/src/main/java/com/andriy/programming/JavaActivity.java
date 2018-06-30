package com.andriy.programming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JavaActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    private InterstitialAd mInterstitialAd;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974/4433781259");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }

    @OnClick({R.id.btn_guide_java, R.id.btn_guide_android, R.id.btn_guide_javafx, R.id.btn_guide_kotlin})
    void onSaveClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_java:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.java, R.string.txt_java);
                } else {
                    intentData(R.drawable.java, R.string.txt_java);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_android:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.android, R.string.txt_android);
                } else {
                    intentData(R.drawable.android, R.string.txt_android);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_javafx:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.javafx, R.string.txt_javafx);
                } else {
                    intentData(R.drawable.javafx, R.string.txt_javafx);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_kotlin:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.kotlin, R.string.txt_kotlin);
                } else {
                    intentData(R.drawable.kotlin, R.string.txt_kotlin);
                    startActivity(intent);
                }
                break;
        }
    }

    private void intentData(int image, int txt) {
        intent = new Intent("android.intent.guide");
        intent.putExtra("imageGuide", image);
        intent.putExtra("txtGuide", txt);
    }
}