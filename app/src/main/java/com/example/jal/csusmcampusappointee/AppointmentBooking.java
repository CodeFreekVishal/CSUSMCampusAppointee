package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Vishal on 13-05-2016.
 */
public class AppointmentBooking extends Activity {

    Button prof1, prof2, prof3, prof4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namelist);

        prof1 = (Button) findViewById(R.id.btnProf1);
        prof2 = (Button) findViewById(R.id.btnProf2);
        prof3 = (Button) findViewById(R.id.btnProf3);


        prof1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatePickerClass.class);
                startActivity(intent);
            }
        });

        prof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatePickerClass.class);
                startActivity(intent);
            }
        });

        prof3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatePickerClass.class);
                startActivity(intent);
            }
        });



    }
}
