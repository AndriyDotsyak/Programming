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

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    private InterstitialAd mInterstitialAd;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974~5626238148");

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

    @OnClick({R.id.btn_guide_node, R.id.btn_guide_javascript, R.id.btn_guide_webgl, R.id.btn_guide_php})
    void onSaveClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_node:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.node, R.string.txt_node);
                } else {
                    intentData(R.drawable.node, R.string.txt_node);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_javascript:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.javascript, R.string.txt_javascript);
                } else {
                    intentData(R.drawable.javascript, R.string.txt_javascript);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_webgl:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.webgl, R.string.txt_webgl);
                } else {
                    intentData(R.drawable.webgl, R.string.txt_webgl);
                    startActivity(intent);
                }
                break;

            case R.id.btn_guide_php:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    intentData(R.drawable.php, R.string.txt_php);
                } else {
                    intentData(R.drawable.php, R.string.txt_php);
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
