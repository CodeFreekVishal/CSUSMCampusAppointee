package com.example.jal.csusmcampusappointee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Vishal on 13-05-2016.
 */
public class DatePickerClass extends Activity {

    EditText appointmentName;
    DatePicker datePicker;
    RadioGroup radioGroup;
    Button proceedAhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepriority);

        appointmentName = (EditText) findViewById(R.id.etAppointmentName);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        radioGroup = (RadioGroup) findViewById(R.id.rgroup);
        proceedAhead = (Button) findViewById(R.id.btnProceed);

        proceedAhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appNameText = appointmentName.getText().toString().trim();

                Intent intent = new Intent(getApplicationContext(), TimePicker.class);
                startActivity(intent);
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
