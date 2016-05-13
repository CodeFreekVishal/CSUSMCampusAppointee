package com.example.jal.csusmcampusappointee;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Vishal on 13-05-2016.
 */
public class TimePick extends Activity {

    TimePicker timePick;
    Button doMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepiker);

        timePick = (TimePicker) findViewById(R.id.timer);

        doMail = (Button) findViewById(R.id.confirmMail);

        doMail.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String name = bundle.getString("name");
                int day = bundle.getInt("day");
                int month  = bundle.getInt("month");
                int year = bundle.getInt("year");

                timePick.is24HourView();
                int currenthour = timePick.getCurrentHour();
                int currentmin = timePick.getCurrentMinute();

                Toast.makeText(TimePick.this, currenthour+""+currentmin, Toast.LENGTH_SHORT).show();

               // Toast.makeText(getApplicationContext(), name+""+day+""+month+""+year, Toast.LENGTH_LONG).show();


                /*
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"astrovishy@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT, "body of email");
                //     i.putExtra(Intent.EXTRA_TEXT, dpc.getAppointmentName().getText().toString().trim());

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

                */

                //sendEmail();
            }
        });

    }

    public void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"astrovishy@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
   //     i.putExtra(Intent.EXTRA_TEXT, dpc.getAppointmentName().getText().toString().trim());

        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
