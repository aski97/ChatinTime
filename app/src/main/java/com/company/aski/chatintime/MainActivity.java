package com.company.aski.chatintime;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.company.aski.chatintime.adapters.PagerAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AdView mAdView;

    private Toolbar tbChat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbChat=findViewById(R.id.tbChat);
        mAdView = findViewById(R.id.adView);

        setSupportActionBar(tbChat);

        // Imposta il Pager
        impostaPager();
        //inserisco la pubblicità
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tbChat.setTitle(R.string.app_name);
    }

    /**
     * Imposta la gestione della paginazione
     */
    private void impostaPager() {

        // Riferimento al pager
        final ViewPager viewPager = findViewById(R.id.pager);

        // Creo l'adapter
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        // Imposto l'adapter per il pager
        viewPager.setAdapter(pagerAdapter);

        // Creazione dei tab ed aggiunta alla toolbar
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        for (int i = 0; i < pagerAdapter.getCount(); i++)
            tabLayout.addTab(tabLayout.newTab().setText(pagerAdapter.getItemTabNameResourceId(i)));

        // Listner delle selezioni dei tab
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
