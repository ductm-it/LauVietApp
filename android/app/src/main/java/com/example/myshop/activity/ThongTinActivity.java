package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myshop.R;
import com.example.myshop.model.RegisterUserClass;
import com.example.myshop.ultil.server;

import java.util.HashMap;

public class ThongTinActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;

    private EditText edtUserName, edtPassWord, edtEmail, edtPhone, edtAddress;
    Button btnEditData, btnEditPass;
    String user_name = "";
    String email = "";
    String phone = "";
    String address = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        AnhXa();

        ActionToolbar();
        getInformation();
        EventButton();

    }


    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnEditData = (Button) findViewById(R.id.btnEditData);
        edtEmail = (EditText) findViewById(R.id.editEmail);
        btnEditPass = (Button) findViewById(R.id.btnEditPass);
        edtPhone = (EditText) findViewById(R.id.editPhone);
        edtAddress = (EditText) findViewById(R.id.editAddress);
        edtUserName = (EditText) findViewById(R.id.editUsername);
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

    public void getInformation() {

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        Integer user_id = preferences.getInt("user_id",0);
        String user_name = preferences.getString("user_name", "");
        String email = preferences.getString("email", "");
        String phone = preferences.getString("phone", "");
        String address = preferences.getString("address", "");


        edtUserName.setText(user_name);
        edtEmail.setText(email);
        edtPhone.setText(phone);
        edtAddress.setText(address);
    }

    private void EventButton() {
        btnEditPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ThaydoimatkhauActivity.class);
                startActivity(intent);
            }
            });

        btnEditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                Integer user_id = preferences.getInt("user_id",0);

                    user_name = edtUserName.getText().toString();
                    email = edtEmail.getText().toString();
                    phone = edtPhone.getText().toString();
                    address = edtAddress.getText().toString();


                ChangeInfo(user_id, user_name, email, phone, address);

            }
        });

    }


    private void ChangeInfo(final int user_id, final String user_name, final String email, final String phone, final String address) {
        class ChangeInfo extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ThongTinActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
//                if(s =="1"){
//                    Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_LONG).show();
//                }
//                else if(s=="0"){
//                    Toast.makeText(getApplicationContext(), "Cập nhật thất bại", Toast.LENGTH_LONG).show();
//                }
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();

                data.put("user_id",   params[0]);

                data.put("user_name",  params[1]);

                data.put("email",  params[2]);

                data.put("phone",  params[3]);
                data.put("address",  params[4]);

                String result = ruc.sendPostRequest(server.ChangeInfo, data);

                return result;
            }


        }

        ChangeInfo ru = new ChangeInfo();
        ru.execute(String.valueOf(user_id),user_name,email,phone,address);
    }






}
