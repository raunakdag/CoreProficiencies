package com.example.coreproficiencies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://www.eabsentee.org/mobileweb/";
        MyResponseHelper myResponseHelper = new MyResponseHelper();
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                myResponseHelper,
                myResponseHelper);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    protected class MyResponseHelper implements
            Response.Listener<String>, Response.ErrorListener {

        @Override
        public void onResponse(String response) {
                 Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

//                setContentView(R.layout.activity_main);

//                TextView tv1 = (TextView)findViewById(R.id.textView1);
//                tv1.setText("Hello");
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
        }
    }
}