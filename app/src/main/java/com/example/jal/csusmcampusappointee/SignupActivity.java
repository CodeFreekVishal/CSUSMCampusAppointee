package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vishal on 08-05-2016.
 */
public class SignupActivity extends Activity {

    EditText fullName, emailId, password, confPassword, department, contactNo;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);

        fullName = (EditText) findViewById(R.id.etFullName);
        emailId = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        confPassword = (EditText) findViewById(R.id.etConfPassword);
        department = (EditText) findViewById(R.id.etDepartment);
        contactNo = (EditText) findViewById(R.id.etContact);

        signup = (Button) findViewById(R.id.signupdetails);

        final String fullNameText = fullName.getText().toString().trim();
        final String emailText = emailId.getText().toString().trim();
        final String passwdText = password.getText().toString().trim();
        final String confPasswd = confPassword.getText().toString().trim();
        final String deptText = department.getText().toString().trim();
        final String contactText = contactNo.getText().toString().trim();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fullNameText.isEmpty() || emailText.isEmpty() || passwdText.isEmpty() ||
                        deptText.isEmpty() || contactText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill up all the credentials", Toast.LENGTH_SHORT).show();
                }
                else if(!passwdText.equals(confPasswd)){
                    password.getText().equals("");
                    confPassword.getText().equals("");
                    Toast.makeText(getApplicationContext(), "Passwords do not match. Try again",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
