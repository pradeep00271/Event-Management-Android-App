package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondPage extends AppCompatActivity {
    private Button insert_btn1;
    private DatabaseReference mDatabase,eventRef,detailsRef;

    private EditText name_field;
    private EditText rollno_field;
    private EditText email_field;
    private EditText phone_field;

    ArrayList<String> selection=new ArrayList<String>();



    public void insert(View view){
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId())
        {
            case R.id.rotract_chk:
                if(checked){
                    selection.add("Rotract");

                }else
                {
                    selection.remove("Rotract");
                }
                // break;

            case R.id.ctf_chk:
                if(checked){
                    selection.add("CTF");

                }else
                {
                    selection.remove("CTF");
                }
                // break;


            case R.id.leo_chk:
                if(checked){
                    selection.add("LEO");

                }else
                {
                    selection.remove("LEO");
                }
                // break;

            case R.id.madavam_chk:
                if(checked){
                    selection.add("MADAVAM");

                }else
                {
                    selection.remove("MADAVAM");
                }
                break;

            case R.id.akriti_chk:
                if(checked){
                    selection.add("AKRITI");

                }else
                {
                    selection.remove("AKRITI");
                }
                break;



        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        insert_btn1=(Button) findViewById(R.id.insert);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        detailsRef=mDatabase.child("Details");
        name_field=(EditText)findViewById(R.id.event_name);
        rollno_field=(EditText)findViewById(R.id.rollno);
        email_field=(EditText)findViewById(R.id.email);
        phone_field=(EditText)findViewById(R.id.phone);


        insert_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_field.getText().toString().trim();
                String rollno = rollno_field.getText().toString().trim();
                String email = email_field.getText().toString().trim();
                String phone = phone_field.getText().toString().trim();
                // ArrayList<String> selection=new ArrayList<String>();

                Map dataMap=new HashMap<String, String>();
                //  HashMap<String,String> dataMap1 =new HashMap<String, String>();
                dataMap.put("Name",name);
                dataMap.put("Rollno",rollno);
                dataMap.put("Email",email);
                dataMap.put("PhoneNumber",phone);
                dataMap.put("Sequences",selection);
                // dataMap1.put("Email",email);
                //dataMap1.put("Phone",phone);
              /*  String key = mDatabase.push().getKey();
                Map mWayPointsMap = new HashMap();
                mWayPointsMap.put(key, dataMap);

                Map mParent = new HashMap();
                mParent.put("Email", email);
                mParent.put("PhoneNumber", phone);
                mParent.put("Name and RollNo", mWayPointsMap);

                String key1 = mDatabase.push().getKey();
                Map array = new HashMap();
                array.put(key1,mParent);

                Map marray=new HashMap();
                marray.put("Sequences",selection);
                marray.put("Details",array);*/
                //    myFirebaseRef.push().setValue(mParent);
                detailsRef.push().setValue(dataMap);
                Toast.makeText(SecondPage.this,"Successfully registered",Toast.LENGTH_LONG).show();
                startActivity(new Intent(SecondPage.this, Homepage.class));


            }
        });



    }
}


