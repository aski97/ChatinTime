package com.company.aski.chatintime.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.company.aski.chatintime.ElencoChatFragment;
import com.company.aski.chatintime.RichiesteChatFragment;
import com.company.aski.chatintime.R;

public class PagerAdapter extends FragmentPagerAdapter {

    /**
     * Numero di tab e quindi di fragment da visualizzare
     */
    private int numeroDiTab =2;

    /**
     * Costruttore
     * @param fm fragment manager di riferimento
     */
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Restituisce l'elemento corrispondente alla posizione passata
     * @param position posizione
     * @return elemento
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ElencoChatFragment();

            case 1:
                return new RichiesteChatFragment();

            default:
                return null;
        }
    }

    /**
     * Restituisce il numero di fragment totali
     * @return numero di fragment
     */
    @Override
    public int getCount() {
        return numeroDiTab;
    }

    /**
     * Restituisce l'id della risorsa con il nome del tab da mettere nel menu
     * @param position indice della posizione
     * @return id della stringa da mostrare nel tab
     */
    public int getItemTabNameResourceId(int position) {
        switch (position) {
            case 0:
                return R.string.tb_chat;
            case 1:
                return R.string.tb_richieste;

             default:
                    return R.string.tb_unknown;
        }
    }
}
