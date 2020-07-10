package com.example.myshop.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.model.Account;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ThanhToanActivity extends AppCompatActivity {
    Toolbar toolbarthanhtoan;
    private EditText edtUserName,edtPassWord,edtEmail,edtPhone,edtAddress;
    String userName="";
    String email="";
    String phone="";
    String address="";
    Button btnMuahang,btnThanhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        AnhXa();
        ActionToolbar();
        getInformation();
        EventButton();
    }
    private void EventButton() {
        btnMuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                final Integer user_id = preferences.getInt("user_id",0);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                final  String currentDateandTime = dateFormat.format(new Date());

                RequestQueue queue=Volley.newRequestQueue((getApplicationContext()));
                StringRequest request=new StringRequest(Request.Method.POST, server.DuongdanDonHang, new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {


                        //chi tiet don hang
                        RequestQueue queue=Volley.newRequestQueue((getApplicationContext()));
                        StringRequest request=new StringRequest(Request.Method.POST, server.DuongdanCTDonHang, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("1")){


                                    checkConnect.ShowToast_Short(getApplicationContext(),"Success");
                                    Intent intent = new Intent(ThanhToanActivity.this, RatingActivity.class);
                                    startActivity(intent);
                                }else {
                                    checkConnect.ShowToast_Short(getApplicationContext(),"Error");
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                JSONArray jsonArray=new JSONArray();
                                for(int i=0;i<MainActivity.manggiohang.size();i++){
                                    //JSonObject chứa các sản phẩm
                                    JSONObject jsonObject=new JSONObject();
                                    try {
                                        jsonObject.put("id_bill",response);
                                        jsonObject.put("id_product",MainActivity.manggiohang.get(i).getIdsp());
                                        jsonObject.put("quantity",MainActivity.manggiohang.get(i).getSoluongsanpham());
                                        jsonObject.put("price",MainActivity.manggiohang.get(i).getGiasp());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jsonArray.put(jsonObject);
                                }
                                Map<String, String> params = new HashMap<>();
                                //Đẩy và truyền dữ liệu lên server
                                params.put("json", jsonArray.toString());
                                return params;
                            }
                        };
                        queue.add(request);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        JSONArray jsonArray=new JSONArray();
                        long tongtien=0;
                        for(int i=0;i<MainActivity.manggiohang.size();i++){
                            tongtien+=MainActivity.manggiohang.get(i).getGiasp();
                        }

                        Map<String, String> params = new HashMap<>();
                        //Đẩy và truyền dữ liệu lên server
                        params.put("id_customer", String.valueOf(user_id));
                        params.put("date_order", currentDateandTime);
                        params.put("total", String.valueOf(tongtien));


                        return params;
                    }
                };
                queue.add(request);

            }
        });

    }

    private void AnhXa() {
        toolbarthanhtoan=(Toolbar) findViewById(R.id.toolbar);
        btnThanhToan = (Button) findViewById(R.id.btnThanhToan);
        btnMuahang = (Button) findViewById(R.id.btnMuahang);
        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtPhone = (EditText) findViewById(R.id.editPhone);
        edtAddress = (EditText) findViewById(R.id.editAddress);
        edtUserName = (EditText) findViewById(R.id.editUsername);
        edtPassWord = (EditText) findViewById(R.id.editPassword);
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbarthanhtoan);
        //nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarthanhtoan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void getInformation() {

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String user_name = preferences.getString("user_name", "");
        String email = preferences.getString("email", "");
        String phone = preferences.getString("phone", "");
        String address = preferences.getString("address", "");



        edtUserName.setText(user_name);
        edtEmail.setText(email);
        edtPhone.setText(phone);
        edtAddress.setText(address);





    }
}
