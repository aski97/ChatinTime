package com.company.aski.chatintime;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.company.aski.chatintime.adapters.PagerAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager viewPager;
    private AdView mAdView;

    private Toolbar tbChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbChat=findViewById(R.id.tbDestinatario);
        mAdView = findViewById(R.id.adView);

        tbChat.setTitle(R.string.app_name);
        setSupportActionBar(tbChat);

        // Imposta il Pager
        impostaPager();
        //inserisco la pubblicità
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    /**
     * Imposta la gestione della paginazione
     */
    private void impostaPager() {

        // Riferimento al pager
        viewPager = findViewById(R.id.pager);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewPager.getCurrentItem()==0 || viewPager.getCurrentItem()==1)
            getMenuInflater().inflate(R.menu.menu_elenco_chat,menu);
        else if (viewPager.getCurrentItem()==2)
            getMenuInflater().inflate(R.menu.menu_contatti,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
            invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Switch per individuare la voce di menu scelta
        switch (item.getItemId()) {
            case R.id.menu_impostazioni:

                Intent intent= new Intent(getApplicationContext(),ImpostazioniActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_chat_search:
                Toast.makeText(getApplicationContext(),R.string.next_feature,Toast.LENGTH_SHORT).show();

                return true;

            case R.id.menu_contatti_refresh:
                Toast.makeText(getApplicationContext(),R.string.next_feature,Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_contatti_search:
                Toast.makeText(getApplicationContext(),R.string.next_feature,Toast.LENGTH_SHORT).show();
                return true;

            default:
                // Scelta non riconosciuta, passo il controllo al metodo della classe base
                return super.onOptionsItemSelected(item);
        }
    }
}
