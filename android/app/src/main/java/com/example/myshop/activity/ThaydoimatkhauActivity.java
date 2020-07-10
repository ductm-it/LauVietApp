package com.example.myshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.ultil.server;

import java.util.HashMap;
import java.util.Map;

public class ThaydoimatkhauActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    private EditText edtmatkhaucu, edtmatkhaumoi;
    Button btnEditPass;
    String cu = "";
    String moi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thaydoimatkhau);
        AnhXa();
        ActionToolbar();
        EventButton();
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        //nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }


    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        edtmatkhaucu=(EditText) findViewById(R.id.idmatkhaucu);
        edtmatkhaumoi=(EditText) findViewById(R.id.idmatkhaumoi);
        btnEditPass=(Button) findViewById(R.id.btnEditPass);
    }


    private void EventButton() {
        btnEditPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                Integer user_id = preferences.getInt("user_id",0);
                cu = edtmatkhaucu.getText().toString();
                moi = edtmatkhaumoi.getText().toString();
                ChangePass(user_id, cu, moi);

            }
        });

    }

    private void ChangePass(final int user_id, final String cu, final String moi) {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String duongdan= server.ChangePass;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Đẩy và truyền dữ liệu lên server
                HashMap<String, String> data=new HashMap<String, String>();
                data.put("user_id", String.valueOf(user_id));

                data.put("cu",cu);

                data.put("moi",moi);


                return data;
            }
        };
        requestQueue.add(stringRequest);
    }
}

