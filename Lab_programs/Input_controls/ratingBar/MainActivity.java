package com.example.inputcontrol;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ToggleButton toggle;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerFood);
        toggle = findViewById(R.id.toggleVeg);
        ratingBar = findViewById(R.id.ratingBar);

        String[] foodItems = {"Pizza", "Burger", "Pasta", "Biryani"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, foodItems);
        spinner.setAdapter(adapter);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this,
                    "Rating: " + rating, Toast.LENGTH_SHORT).show();
        });

        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String type = isChecked ? "Veg Selected" : "Non-Veg Selected";
            Toast.makeText(MainActivity.this, type, Toast.LENGTH_SHORT).show();
        });
    }
}