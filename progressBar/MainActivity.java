package com.example.inputcontrols2;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    ImageButton button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        button = findViewById(R.id.bookBtn);
        progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(v -> {

            progressBar.setVisibility(ProgressBar.VISIBLE);

            new Handler().postDelayed(() -> {

                progressBar.setVisibility(ProgressBar.GONE);

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String msg = "Booking Confirmed!\nDate: " + day + "/" + month + "/" + year +
                        "\nTime: " + hour + ":" + minute;

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

            }, 3000);
        });
    }
}