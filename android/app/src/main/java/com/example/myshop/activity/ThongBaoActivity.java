package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myshop.R;
import com.example.myshop.model.RegisterUserClass;
import com.example.myshop.ultil.server;

public class ThongBaoActivity extends AppCompatActivity implements OnClickListener{

    Button button; //Khai báo một button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);

        Button email = (Button) findViewById(R.id.button_email); //Tìm lại button
        email.setOnClickListener(this);

        Button notifi = findViewById(R.id.button_not); //Tìm lại button
        notifi.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_email:
                 {
                    Intent intent = new Intent(ThongBaoActivity.this, SendEmailActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.button_not:
                {
                Intent intent = new Intent(ThongBaoActivity.this, TimerActivity.class);
                startActivity(intent);
                }

                break;
            default:
                break;


        }
           // Toast.makeText(ThongBaoActivity.this,"Bạn đã click",Toast.LENGTH_SHORT).show();


}}
