package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button sendbutton=(Button)findViewById(R.id.email_sign_in_button);

        sendbutton.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);
            }
        });
        };


}

//sendbutton.setOnClickListener(
  //      new View.OnClickListener() {
//@Override
//public void onClick(View view) {
  //      Intent intent = new Intent(getApplicationContext(), Homepage.class);
    //    startActivity(intent);
      //  }
        //});


