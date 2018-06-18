package com.company.aski.chatintime.datamodel;

import com.google.firebase.database.FirebaseDatabase;

public class QueryDB {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private static QueryDB instance=null;

    private QueryDB() {
        database.setPersistenceEnabled(true);
    }

    public static QueryDB getInstance(){
        if (instance==null)
            instance= new QueryDB();

        return instance;
    }


}
