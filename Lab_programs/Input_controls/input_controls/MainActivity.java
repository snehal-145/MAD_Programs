package com.example.pr_6;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    RadioGroup genderGroup;
    CheckBox checkJava, checkPython, checkAndroid,checkc,checkr,checknet;
    ToggleButton toggleNotify;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        genderGroup = findViewById(R.id.genderGroup);
        checkc = findViewById(R.id.checkc);
        checkr = findViewById(R.id.checkr);
        checknet= findViewById(R.id.checknet);
        checkJava = findViewById(R.id.checkjava);
        checkPython = findViewById(R.id.checkpython);
        checkAndroid = findViewById(R.id.checkAndroid);
        toggleNotify = findViewById(R.id.toggleNotify);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> {

            String name = nameInput.getText().toString();

            // Gender
            int selectedId = genderGroup.getCheckedRadioButtonId();
            String gender = "";

            if (selectedId == R.id.radioMale) {
                gender = "Male";
            } else if (selectedId == R.id.radioFemale) {
                gender = "Female";
            }

            // Skills
            String skills = "";
            if (checkc.isChecked()) skills += "C ";
            if (checkr.isChecked()) skills += "R";
            if (checknet.isChecked()) skills += ".Net ";
            if (checkJava.isChecked()) skills += "Java ";
            if (checkPython.isChecked()) skills += "Python ";
            if (checkAndroid.isChecked()) skills += "Android ";

            // Toggle
            String notify = toggleNotify.isChecked() ? "ON" : "OFF";

            String result = "Name: " + name +
                    "\nGender: " + gender +
                    "\nSkills: " + skills +
                    "\nNotifications: " + notify;

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });
    }
}