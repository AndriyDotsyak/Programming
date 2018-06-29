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

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974~5626238148");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @OnClick({R.id.btn_guide_node, R.id.btn_guide_javascript, R.id.btn_guide_webgl, R.id.btn_guide_php})
    void onSaveClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btn_guide_node:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.node);
                intent.putExtra("txtGuide", R.string.txt_node);
                startActivity(intent);
                break;

            case R.id.btn_guide_javascript:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.javascript);
                intent.putExtra("txtGuide", R.string.txt_javascript);
                startActivity(intent);
                break;

            case R.id.btn_guide_webgl:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.webgl);
                intent.putExtra("txtGuide", R.string.txt_webgl);
                startActivity(intent);
                break;

            case R.id.btn_guide_php:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.php);
                intent.putExtra("txtGuide", R.string.txt_php);
                startActivity(intent);
                break;
        }
    }
}
