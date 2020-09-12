package com.example.student.clubhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Pretha_2015 on 08-09-2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<model> models;
    public CustomAdapter(Context c, ArrayList<model> models) {
        this.c = c;
        this.models = models;
    }
    @Override
    public int getCount() {
        return models.size();
    }
    @Override
    public Object getItem(int position) {
        return models.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model1,parent,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.evt_nameTxt);
        TextView evtTxt= (TextView) convertView.findViewById(R.id.club_Txt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
        final model md= (model) this.getItem(position);
        nameTxt.setText(md.getEventName());
        evtTxt.setText(md.getClubName());
        descTxt.setText(md.getDescription());
        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,md.getEventName(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

}
