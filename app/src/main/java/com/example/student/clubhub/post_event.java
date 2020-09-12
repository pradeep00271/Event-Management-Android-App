package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class post_event extends AppCompatActivity {
    private DatabaseReference mDatabase;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;
    // Button postbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//INITIALIZE FIREBASE DB
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //eventRef=mDatabase.child("events");

        helper = new FirebaseHelper(mDatabase);
        //ADAPTER
        adapter = new CustomAdapter(this, helper.retrieve());
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // displayInputDialog();
                startActivity(new Intent(post_event.this, Homepage.class));

            }
        });
    }



    //DISPLAY INPUT DIALOG
/*    private void displayInputDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.extra);
        event_name1 = (EditText) d.findViewById(R.id.event_name);
        event_club1 = (EditText) d.findViewById(R.id.club_name);
        decription1 = (EditText) d.findViewById(R.id.decription_edit);
        Button postbtn = (Button) d.findViewById(R.id.post);
        //SAVE
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name1 = event_name1.getText().toString();
                String club1 = event_club1.getText().toString();
                String desc = decription1.getText().toString();
                //SET DATA
                com.example.pretha_2015.firebase.model s = new com.example.pretha_2015.firebase.model();
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
                        adapter = new com.example.pretha_2015.firebase.CustomAdapter(post_event.this, helper.retrieve());
                        lv.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(post_event.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();





*/







      /*  Button postbtn = (Button) findViewById(R.id.post);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        eventRef=mDatabase.child("events");
        final EditText event_name1 = (EditText) findViewById(R.id.event_name);
        final EditText event_club1 = (EditText) findViewById(R.id.club_name);



        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_event = event_name1.getText().toString().trim();
                String club_event = event_club1.getText().toString().trim();

                Map dataMap1=new HashMap<String, String>();
                //  HashMap<String,String> dataMap1 =new HashMap<String, String>();
                dataMap1.put("Event_Name",name_event);
                dataMap1.put("Event Time",club_event);

                eventRef.push().setValue(dataMap1);*/

    //push creates a unique id in database




             /*   Toast.makeText(post_event.this,"Successfully registered",Toast.LENGTH_LONG).show();
                Intent nextpage1 = new Intent(post_event.this, fetch.class);
                startActivity(nextpage1);


            }
        });
*/




    // }
}
