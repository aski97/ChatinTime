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


public class ChatFragment extends Fragment {

    private FloatingActionButton btnAddChat;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat,container,false);

        btnAddChat=view.findViewById(R.id.btn_add_chat);
        mRecyclerView = view.findViewById(R.id.recyclerChat);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(ChatFragment.this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        String dati[]= {"avd","bucchin"};
        // specify an adapter (see also next example)
        mAdapter = new ChatAdapter(dati);
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
                Toast.makeText(ChatFragment.this.getContext(),R.string.next_feature,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
