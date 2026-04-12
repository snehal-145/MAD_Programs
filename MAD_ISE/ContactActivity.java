package com.example.madise;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

public class ContactActivity extends AppCompatActivity {

    TextView tvContact;
    ImageButton btnCall, btnSMS, btnWhatsApp;

    String number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        tvContact = findViewById(R.id.tv);
        btnCall = findViewById(R.id.btn1);
        btnSMS = findViewById(R.id.btn2);
        btnWhatsApp = findViewById(R.id.btn3);

        number = getIntent().getStringExtra("phone");

        tvContact.setText(number);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + number));

                startActivity(callIntent);
            }
        });


        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("sms:" + number));

                startActivity(smsIntent);
            }
        });

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
                whatsappIntent.setData(Uri.parse(
                        "https://wa.me/" + number));

                startActivity(whatsappIntent);
            }
        });
    }
}