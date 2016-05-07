package com.example.jal.csusmcampusappointee;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    AutoCompleteTextView email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Button sendbutton = (Button) findViewById(R.id.email_sign_in_button);

        sendbutton.setOnClickListener(
                new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        String emailText = email.getText().toString();
                        String pwdText = password.getText().toString();

                        if (emailText.isEmpty() || pwdText.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Please enter proper login credentials", Toast.LENGTH_LONG).show();

                        } else {
                            Intent intent = new Intent(getApplicationContext(), Homepage.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    ;


}



