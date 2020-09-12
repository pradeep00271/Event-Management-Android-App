package com.example.student.clubhub;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by student on 11/8/17.
 */

public class PlayersFragment extends ListFragment {
    String[] players={"Rotract club","Leo club","GT", "CTF","Aakriti","Capitalize","Green brigade","Robotics","Siruthuligal","Spartanz"};
    int[] images={R.drawable.rot,R.drawable.leo,R.drawable.gt,R.drawable.ctf,R.drawable.images,R.drawable.cap,R.drawable.gb,R.drawable.robo,R.drawable.siru,R.drawable.spar};
    ArrayList<HashMap<String, String>> data= new ArrayList<>();
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
//MAP
        HashMap<String, String> map;
        //FILL
        for(int i=0;i<players.length;i++)
        {
            map= new HashMap<>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"Player","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,long id) {
                // TODO Auto-generated method stub
               // Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

               // players.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                   // public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        if (pos == 0) {
                            Intent rotract = new Intent(getActivity(),rotract.class);
                            startActivity(rotract);
                        }
                        else if (pos == 1) {
                            Intent pakistan = new Intent(getActivity(),Leo.class);
                            startActivity(pakistan);
                        }
                        else if (pos == 2) {
                            Intent shriLanka = new Intent(getActivity(), Gtimes.class);
                            startActivity(shriLanka);
                        }
                        else if (pos == 3) {
                            Intent china= new Intent(getActivity(), Ctf.class);
                            startActivity(china);
                        }
                        else if (pos == 4) {
                            Intent aakriti= new Intent(getActivity(), Aakriti.class);
                            startActivity(aakriti);
                        }
                        else if (pos == 5) {
                            Intent cap= new Intent(getActivity(), Capitalize.class);
                            startActivity(cap);
                        }
                        else if (pos == 6) {
                            Intent gb= new Intent(getActivity(), Green.class);
                            startActivity(gb);
                        }
                        else if (pos == 7) {
                            Intent robo= new Intent(getActivity(), Robo.class);
                            startActivity(robo);
                        }
                        else if (pos == 8) {
                            Intent siru= new Intent(getActivity(), Siru.class);
                            startActivity(siru);
                        }
                        else if (pos == 9) {
                            Intent spar= new Intent(getActivity(), Spar.class);
                            startActivity(spar);
                        }

            }
       // });
    });

}
}