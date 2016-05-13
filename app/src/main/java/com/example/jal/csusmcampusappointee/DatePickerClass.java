package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Vishal on 13-05-2016.
 */
public class DatePickerClass extends Activity {

    EditText appointmentName, subjectText;
    DatePicker datePicker;
    RadioGroup radioGroup;
    Button proceedAhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepriority);

        appointmentName = (EditText) findViewById(R.id.etAppointmentName);
        subjectText = (EditText) findViewById(R.id.etSubject);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        proceedAhead = (Button) findViewById(R.id.btnProceed);

        proceedAhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appNameText = appointmentName.getText().toString().trim();
                String subject = subjectText.getText().toString().trim();
                int day = datePicker.getDayOfMonth();
                int month = (datePicker.getMonth()+1);
                int year = datePicker.getYear();

                if(appNameText.isEmpty() || subject.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Oops ! Seems you forgot to enter required data !", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), TimePick.class);

                    intent.putExtra("name", appNameText);
                    intent.putExtra("subject", subject);
                    intent.putExtra("day", day);
                    intent.putExtra("month", (datePicker.getMonth() + 1));
                    intent.putExtra("year", year);

                    startActivity(intent);
                }
            }
        });

    }

    public EditText getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(EditText appointmentName) {
        this.appointmentName = appointmentName;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }
}
