package com.ingenico.contactform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String date;
    private String phone;
    private String email;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickNext(View view) {
        Intent intent = new Intent(this, ShowContact.class);

        //--- name
        EditText edt_name = (EditText)findViewById(R.id.edt_name);
        name = edt_name.getText().toString().trim();

        //--- Date
        DatePicker pick_date = (DatePicker)findViewById(R.id.pick_date);
        int   day  = pick_date.getDayOfMonth();
        int   month= pick_date.getMonth();
        int   year = pick_date.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        date = sdf.format(calendar.getTime());

        //--- phone
        EditText edt_phone = (EditText)findViewById(R.id.edt_phone);
        phone = edt_phone.getText().toString().trim();

        //--- email
        EditText edt_email = (EditText)findViewById(R.id.edt_email);
        email = edt_email.getText().toString().trim();

        //--- Description
        EditText edt_description = (EditText)findViewById(R.id.edt_description);
        description = edt_description.getText().toString().trim();

        intent.putExtra(String.valueOf(R.string.pform_name), name);
        intent.putExtra(String.valueOf(R.string.pform_date), date);
        intent.putExtra(String.valueOf(R.string.pform_phone), phone);
        intent.putExtra(String.valueOf(R.string.pform_email), email);
        intent.putExtra(String.valueOf(R.string.pform_description), description);

        startActivity(intent);
    }
}
