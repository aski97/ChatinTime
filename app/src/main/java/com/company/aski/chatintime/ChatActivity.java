package com.company.aski.chatintime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ChatActivity extends AppCompatActivity {

    private AdView mAdView;

    private Toolbar tbMessaggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tbMessaggi=findViewById(R.id.tbDestinatario);
        mAdView = findViewById(R.id.adViewChat);

        //bisognerà impostare il nome del destinatario
        tbMessaggi.setTitle(R.string.tb_chat);
        setSupportActionBar(tbMessaggi);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //nascondo la tastiera
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        //inserisco la pubblicità
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
