package com.example.myshop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
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

import com.example.myshop.adapter.RatingAdapter;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RatingActivity extends AppCompatActivity {
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnrating,btnskiprating;
    Toolbar toolbargiohang;
    RatingAdapter ratingAdapter;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        AnhXa();
        ActionToolbar();
        EventClick();

    }


    @Override
    public void onBackPressed() {
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                RatingActivity.this);

        alertDialog.setTitle("Quay về");
        alertDialog.setMessage("Bạn sẽ quay về trang chủ và hủy nhận xét");
        // Setting Positive "Yes" Button

        alertDialog.setPositiveButton("Quay về", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                checkConnect.ShowToast_Short(getApplicationContext(),"Cám ơn bạn mua hàng");
                MainActivity.manggiohang.clear();
                Intent intent = new Intent(RatingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("Ở lại",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private void EventClick() {
        btnskiprating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.manggiohang.clear();
                Intent intent = new Intent(RatingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnrating.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                SharedPreferences ui = getSharedPreferences("price", MODE_PRIVATE);
//                final Float tongtien = ui.getFloat("price",0);

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                final Integer user_id = preferences.getInt("user_id",0);

                RequestQueue queue=Volley.newRequestQueue((getApplicationContext()));
                StringRequest request=new StringRequest(Request.Method.POST, server.DuongdanRatingProduct, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("1")){
                            MainActivity.manggiohang.clear();

                            checkConnect.ShowToast_Short(getApplicationContext(),"Success ");
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            checkConnect.ShowToast_Short(getApplicationContext(),"Cám ơn sự đánh giá của bạn");

                        }else {
                            MainActivity.manggiohang.clear();
                            checkConnect.ShowToast_Short(getApplicationContext(),"Cám ơn bạn đã tham gia mua hàng");
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
//                            checkConnect.ShowToast_Short(getApplicationContext(),"Error");
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
//                                        jsonObject.put("id_rating",response);
                                jsonObject.put("id_product",MainActivity.manggiohang.get(i).getIdsp());
                                jsonObject.put("user_id", String.valueOf(user_id));
                                jsonObject.put("star",MainActivity.manggiohang.get(i).getStar());
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
        });
    }


    private void ActionToolbar() {
        setSupportActionBar(toolbargiohang);
        //nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonHandler();
            }
        });
    }

    private void AnhXa() {
        lvgiohang=(ListView)findViewById(R.id.listviewrating);
        txtthongbao=(TextView)findViewById(R.id.textviewthongbao);
        txttongtien=(TextView)findViewById(R.id.textviewtongtien);
        btnrating=(Button) findViewById(R.id.buttonrating);
        btnskiprating=(Button) findViewById(R.id.buttonskiprating);
        toolbargiohang=(Toolbar) findViewById(R.id.toolbargiohang);
        ratingAdapter= new RatingAdapter(RatingActivity.this,MainActivity.manggiohang);
        this.lvgiohang.setLongClickable(false);
        lvgiohang.setAdapter(ratingAdapter);
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        final Integer user_id = preferences.getInt("user_id",0);

    }

}
