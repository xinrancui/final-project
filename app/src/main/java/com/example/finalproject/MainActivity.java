package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        //Date currentTime = new Date();
        //currentTime.setTime(1556222399590);
        final EditText textInput = findViewById(R.id.textInput);
        Button next = findViewById(R.id.nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String firmName = textInput.getText().toString();
                startAPIcall(firmName);
                //Nextstep: import the API
            }
        });
    }
    void startAPIcall(String firmName) {
        try {
            final EditText textInput = findViewById(R.id.textInput);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://cloud.iexapis.com/stable/tops?token=sk_dc9111cd6aea4bcd89363b39fbb856d7&symbols=fb",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("FINAL PROJECT", error.toString());
                        }
                    });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            Log.e("FINAL PROJECT", e.toString());
        }
    }
}
