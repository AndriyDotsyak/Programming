package com.andriy.programming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.image_guide)
    ImageView imageGuide;

    @BindView(R.id.txt_guide)
    TextView txtGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        Bundle argumets = getIntent().getExtras();

        imageGuide.setImageDrawable(getResources().getDrawable(argumets.getInt("imageGuide")));
        txtGuide.setText(getResources().getText(argumets.getInt("txtGuide")));
    }
}
