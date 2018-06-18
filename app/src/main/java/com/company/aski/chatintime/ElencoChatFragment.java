package com.company.aski.chatintime;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.company.aski.chatintime.adapters.ChatAdapter;
import com.company.aski.chatintime.datamodel.Chat;
import com.company.aski.chatintime.datamodel.Messaggio;

import java.util.ArrayList;
import java.util.List;


public class ElencoChatFragment extends Fragment {

    private FloatingActionButton btnAddChat;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ElencoChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_elenco_chat,container,false);


        btnAddChat=view.findViewById(R.id.btn_add_chat);
        mRecyclerView = view.findViewById(R.id.recyclerChat);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(ElencoChatFragment.this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

       //per provare
        List<Chat> listChat= new ArrayList<>();
        List<Messaggio> listMessaggi= new ArrayList<>();
        listMessaggi.add(new Messaggio("Chitammuooo"));
        listMessaggi.add(new Messaggio("Bella zio"));
        listChat.add(new Chat("Vittorio Belardo",listMessaggi));
        listChat.add(new Chat("Porco Pino",listMessaggi));

        mAdapter = new ChatAdapter(ElencoChatFragment.this.getContext(),listChat);
        mRecyclerView.setAdapter(mAdapter);

        //imposto tutti i listner
        setListener();

        return view;
    }

    private void setListener(){

        btnAddChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dovrebbe aggiungere una chat, aprire un activity dei contatti e selezionare uno di quelli
                //selezionato bisogna impostare la durata della chat alla conferma di richiesta
                Toast.makeText(ElencoChatFragment.this.getContext(),R.string.next_feature,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
