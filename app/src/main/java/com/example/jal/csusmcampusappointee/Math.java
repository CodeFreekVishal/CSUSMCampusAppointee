package com.example.jal.csusmcampusappointee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Math extends AppCompatActivity {

    Button bRam, bNash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths);

        bRam = (Button) findViewById(R.id.btnRam);
        bNash = (Button) findViewById(R.id.btnNash);

        bRam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatePickerClass.class);
                startActivity(intent);
            }
        });

        bNash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatePickerClass.class);
                startActivity(intent);
            }
        });

    }

}
