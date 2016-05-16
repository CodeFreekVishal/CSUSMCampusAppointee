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
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Button sendbutton = (Button) findViewById(R.id.email_sign_in_button);
        signup = (Button) findViewById(R.id.signUpButton);

       // final SignupDatabaseAdapter sda = new SignupDatabaseAdapter(this);
        final DbAdapter dba = new DbAdapter(this);

        sendbutton.setOnClickListener(
                new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        String emailText = email.getText().toString().trim();
                        String pwdText = password.getText().toString().trim();
                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                        if (emailText.isEmpty() || pwdText.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Please enter proper login credentials", Toast.LENGTH_LONG).show();

                        } else if (!emailText.matches(emailPattern)) {
                            Toast.makeText(getApplicationContext(), "Please enter a valid email address", Toast.LENGTH_LONG).show();
                        } else if (pwdText.length() < 6) {
                            Toast.makeText(getApplicationContext(), "Please enter minimum 6 characters as your password", Toast.LENGTH_LONG).show();
                        } else if(emailText.equalsIgnoreCase("panch007@cougars.com" )&& pwdText.equalsIgnoreCase("cougars")) {
                            Intent intent = new Intent(getApplicationContext(), Homepage.class);
                            startActivity(intent);
                        }
                        else if(emailText.equalsIgnoreCase("pandi001@cougars.com") && pwdText.equalsIgnoreCase("cougars")){
                            Intent intent = new Intent(getApplicationContext(), Homepage.class);
                            startActivity(intent);
                        }
                        else if(emailText.equalsIgnoreCase("jalcity@cougars.com") && pwdText.equalsIgnoreCase("cougars")){
                            Intent intent = new Intent(getApplicationContext(), Homepage.class);
                            startActivity(intent);
                        }
                         /*   dba.open();
                            if (dba.login(emailText,pwdText).equalsIgnoreCase("yes")) {
                                //dba.getAllRecords();
                                Toast.makeText(getApplicationContext(), "Yay !!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                                startActivity(intent);
                            }
                            else{
                                Intent intent = new Intent(getApplicationContext(), Homepage.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Record not found !", Toast.LENGTH_LONG).show();
                                dba.getAllRecords();
                            } */
                        }

                });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }


}



