package com.example.menu;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView deviceText;
    Button modeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        deviceText = findViewById(R.id.deviceText);
        modeBtn = findViewById(R.id.modeBtn);

        registerForContextMenu(deviceText);

        modeBtn.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, modeBtn);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();

                if (id == R.id.popup_silent) {
                    Toast.makeText(this, "Silent Mode", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.popup_general) {
                    Toast.makeText(this, "Vibration Mode", Toast.LENGTH_SHORT).show();
                }

                return true;
            });

            popup.show();
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_wifi) {
            Toast.makeText(this, "WiFi Settings", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_bluetooth) {
            Toast.makeText(this, "Bluetooth Settings", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_exit) {
            finish();
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.deviceText) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.context_enable) {
            Toast.makeText(this, "Device Enabled", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.context_disable) {
            Toast.makeText(this, "Device Disabled", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}