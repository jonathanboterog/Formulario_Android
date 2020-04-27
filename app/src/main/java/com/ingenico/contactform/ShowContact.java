package com.ingenico.contactform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowContact extends AppCompatActivity {

    private String name;
    private String date;
    private String phone;
    private String email;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString(String.valueOf(R.string.pform_name));
            date = extras.getString(String.valueOf(R.string.pform_date));
            phone = extras.getString(String.valueOf(R.string.pform_phone));
            email = extras.getString(String.valueOf(R.string.pform_email));
            description = extras.getString(String.valueOf(R.string.pform_description));
        }

        //--- Set name
        TextView tv_name = findViewById(R.id.tv_name);
        tv_name.setText(name);

        //--- Set Date
        TextView tv_date = findViewById(R.id.tv_date);
        tv_date.setText(getString(R.string.resume_date, date));

        //--- Set phone
        TextView tv_phone = findViewById(R.id.tv_phone);
        tv_phone.setText(getString(R.string.resume_phone, phone));

        //--- Set Email
        TextView tv_email = findViewById(R.id.tv_email);
        tv_email.setText(getString(R.string.resume_email, email));

        //--- Set description
        TextView tv_description = findViewById(R.id.tv_description);
        tv_description.setText(getString(R.string.resume_description, description));
    }

    public void OnClickEdit(View view) {
        finish();
    }
}
