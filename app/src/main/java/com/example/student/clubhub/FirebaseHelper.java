package com.example.student.clubhub;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Pretha_2015 on 08-09-2017.
 */

public class FirebaseHelper {
    DatabaseReference mDatabase;
    Boolean saved;
    ArrayList<model> models=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
    }
    //WRITE IF NOT NULL
    public Boolean save(model models)
    {
        if(models==null)
        {
            saved=false;
        }else
        {
            try
            {
                mDatabase.child("Events").push().setValue(models);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST

    private void fetchData(DataSnapshot dataSnapshot)
    {
        models.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            model model1=ds.getValue(model.class);
            models.add(model1);
        }
    }
/*

    private void fetchData(DataSnapshot dataSnapshot)
    {
        models.clear();
        model model1=dataSnapshot.getValue(model.class);
        models.add(model1);
    }

*/

    //RETRIEVE
    public ArrayList<model> retrieve()
    {
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return models;
    }


}
