package com.ingenico.contactform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickNext(View view) {

        String name;
        String date;
        String phone;
        String email;
        String description;

        Intent intent = new Intent(this, ShowContact.class);

        //--- name
        EditText edt_name = findViewById(R.id.edt_name);
        name = edt_name.getText().toString().trim();

        //--- Date
        DatePicker pick_date = findViewById(R.id.pick_date);
        int   day  = pick_date.getDayOfMonth();
        int   month= pick_date.getMonth();
        int   year = pick_date.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        date = sdf.format(calendar.getTime());

        //--- phone
        EditText edt_phone = findViewById(R.id.edt_phone);
        phone = edt_phone.getText().toString().trim();

        //--- email
        EditText edt_email = findViewById(R.id.edt_email);
        email = edt_email.getText().toString().trim();

        //--- Description
        EditText edt_description = findViewById(R.id.edt_description);
        description = edt_description.getText().toString().trim();

        intent.putExtra(String.valueOf(R.string.pform_name), name);
        intent.putExtra(String.valueOf(R.string.pform_date), date);
        intent.putExtra(String.valueOf(R.string.pform_phone), phone);
        intent.putExtra(String.valueOf(R.string.pform_email), email);
        intent.putExtra(String.valueOf(R.string.pform_description), description);

        //--- Check mandatory fields
        //--- Name
        if(name.length() == 0) {
            Snackbar.make(view, getResources().getString(R.string.mandatory_name), Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryLight))
                    .show();
            edt_name.requestFocus();
            return;
        }
        //--- Phone
        if(phone.length() == 0) {
            Snackbar.make(view, getResources().getString(R.string.mandatory_phone), Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryLight))
                    .show();
            edt_phone.requestFocus();
            return;
        }
        //--- Email
        if(email.length() == 0) {
            Snackbar.make(view, getResources().getString(R.string.mandatory_email), Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryLight))
                    .show();
            edt_email.requestFocus();
            return;
        }
        //--- Description
        if(description.length() == 0) {
            Snackbar.make(view, getResources().getString(R.string.mandatory_description), Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorPrimaryLight))
                    .show();
            edt_description.requestFocus();
            return;
        }

        startActivity(intent);
    }
}
