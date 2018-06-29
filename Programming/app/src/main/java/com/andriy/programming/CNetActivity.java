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

public class CNetActivity extends AppCompatActivity {

    @BindView(R.id.adView)
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnet);
        ButterKnife.bind(this);

        MobileAds.initialize(this, "ca-app-pub-8258213393688974~5626238148");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @OnClick({R.id.btn_guide_c, R.id.btn_guide_net, R.id.btn_guide_xamarin})
    void onSaveClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btn_guide_c:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.c);
                intent.putExtra("txtGuide", R.string.txt_c);
                startActivity(intent);
                break;

            case R.id.btn_guide_net:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.net);
                intent.putExtra("txtGuide", R.string.txt_net);
                startActivity(intent);
                break;

            case R.id.btn_guide_xamarin:
                intent = new Intent("android.intent.guide");
                intent.putExtra("imageGuide", R.drawable.xamarin);
                intent.putExtra("txtGuide", R.string.txt_xamarin);
                startActivity(intent);
                break;
        }
    }
}
