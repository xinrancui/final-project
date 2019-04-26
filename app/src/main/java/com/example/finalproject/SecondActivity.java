package com.example.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SecondActivity extends AppCompatActivity {
    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;
    private static final String TAG = "FinalProject:Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);
        requestQueue = Volley.newRequestQueue(this);
        final TextView priceDisplay = findViewById(R.id.priceDisplay);
        priceDisplay.setText(MainActivity.getPrice());
    }

}
