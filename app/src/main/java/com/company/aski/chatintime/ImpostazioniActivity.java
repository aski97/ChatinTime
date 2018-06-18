package com.company.aski.chatintime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

public class ImpostazioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);
        Toolbar tbImpostazioni= findViewById(R.id.tbImpostazioni);

        tbImpostazioni.setTitle(R.string.menu_impostazioni);
        setSupportActionBar(tbImpostazioni);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
