package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;

public class Homepage extends Activity {

    ListView list;
    String[] itemname ={
      "Writing Center",
      "Math Lab",
      "Language Learning Center",
            "STEM "
    };

    Integer[] imgid={
            R.drawable.ws,
            R.drawable.math,
            R.drawable.lang3,
            R.drawable.stem

    };

    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_homepage);
        CustomListAdapter adapter=new CustomListAdapter(this,itemname,imgid);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Homepage.this, AppointmentBooking.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(Homepage.this, Math.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(Homepage.this, Lang.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(Homepage.this, Stem.class);
                    startActivity(intent);
                }


    }








} );
    }
}


