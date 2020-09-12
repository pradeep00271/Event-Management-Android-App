package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class input_events extends AppCompatActivity {
    EditText event_name1,event_club1,decription1;
    Button postbtn;
    DatabaseReference mDatabase,eventRef;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;
//private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_events);
        //  firebaseAuth = FirebaseAuth.getInstance();
        lv = (ListView) findViewById(R.id.lv);
        //INITIALIZE FIREBASE DB
        mDatabase = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(mDatabase);
        eventRef=mDatabase.child("Events");
        //ADAPTER
        //adapter = new CustomAdapter(this, helper.retrieve());
        // lv.setAdapter(adapter);

        event_name1 = (EditText) findViewById(R.id.event_name);
        event_club1 = (EditText) findViewById(R.id.club_name);
        decription1 = (EditText) findViewById(R.id.decription_edit);
        postbtn = (Button) findViewById(R.id.post);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name1 = event_name1.getText().toString();
                String club1 = event_club1.getText().toString();
                String desc = decription1.getText().toString();
                Query queryRef = eventRef.orderByKey().equalTo(String.valueOf(desc));

                queryRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        model data = dataSnapshot.getValue(model.class);
                        Toast.makeText(input_events.this, "TIME CLASH", Toast.LENGTH_SHORT).show();

                        //System.out.println(data.description);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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






                //SET DATA
                model s = new model();
                s.setEventName(name1);
                s.setClubName(club1);
                s.setDescription(desc);
                //SIMPLE VALIDATION
                if (name1 != null && name1.length() > 0) {
                    //THEN SAVE
                    if (helper.save(s)) {
                        //IF SAVED CLEAR EDITXT
                        event_name1.setText("");
                        event_club1.setText("");
                        decription1.setText("");
                        startActivity(new Intent(input_events.this, post_event.class));

                        //adapter = new CustomAdapter(input_events.this, helper.retrieve());
                        //lv.setAdapter(adapter);
                    }

                }else{
                    Toast.makeText(input_events.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //show();






    }
}


