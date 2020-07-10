package com.example.myshop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.model.Account;
import com.example.myshop.model.GioHang;
import com.example.myshop.model.SanPham;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.willy.ratingbar.RatingReviews;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChiTietSanPham extends AppCompatActivity {
    Toolbar toolbarchitiet;
    ImageView imgchitiet;
    TextView txtten,txtgia,txtmota,txtmau,txtchatlieu,txtcomment,txttong,txtrate;
    Spinner  spinner;
    Button buttonmuahang, btnratingbar ,btnComments;
    RatingBar ratingbar;
    EditText editComments;
    String Tenchitiet="";
    int Giachitiet=0;
    String Hinhanhchitiet="";
    String Motachitiet="";
    int Idsanpham=0;
    String Mau="";
    String ChatLieu="";

    int id_product =0;
    int user_id  =0;
    Float star =0.0f;
    String content = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Anhxa();
        ActionToolbar();
        getInformation();
        catchEventSpinner();
        ratingscore();
        Raiting();
        Comment();
        Evenbutton();
    }

    private void Comment() {
        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content=editComments.getText().toString();
                getComment(id_product,user_id,content);
            }

        });
    }

    private void getComment(final int id_product, final int user_id, final String content) {
        RequestQueue requestQueue = Volley.newRequestQueue((getApplicationContext()));
        StringRequest request = new StringRequest(Request.Method.POST, server.DuongdanComment,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        checkConnect.ShowToast_Short(getApplicationContext(),"Success ");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error: " + error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id_product", String.valueOf(id_product));
                params.put("user_id", String.valueOf(user_id));
                params.put("content", content);

                return params;
            }
        };

        requestQueue.add(request);
    }

    private void Raiting() {
        btnratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham= (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
                id_product=sanPham.getId();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                user_id = preferences.getInt("user_id", 0);
                star = ratingbar.getRating();
                getdata(id_product,user_id,star);
            }

        });

    }

    private void getdata(final int id_product, final int user_id, final Float star) {
        RequestQueue requestQueue = Volley.newRequestQueue((getApplicationContext()));
        StringRequest request = new StringRequest(Request.Method.POST, server.DuongdanRaiting,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        Toast.makeText(getApplication(),"Số sao: "+ratingbar.getRating(),Toast.LENGTH_LONG).show();
                        checkConnect.ShowToast_Short(getApplicationContext(),"Success ");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error: " + error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id_product", String.valueOf(id_product));
                params.put("user_id", String.valueOf(user_id));
                params.put("star", String.valueOf(star));

                return params;
            }
        };
        requestQueue.add(request);
    }


    private void Evenbutton() {
        buttonmuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size()>0){
                    int sl=Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists=false;
                    for (int i=0;i<MainActivity.manggiohang.size();i++){
                        if(MainActivity.manggiohang.get(i).getIdsp()==id_product){
                            MainActivity.manggiohang.get(i).setSoluongsanpham(MainActivity.manggiohang.get(i).getSoluongsanpham()+sl);
                            if(MainActivity.manggiohang.get(i).getSoluongsanpham()>=10){
                                MainActivity.manggiohang.get(i).setSoluongsanpham(10);

                            }
                            MainActivity.manggiohang.get(i).setGiasp(Giachitiet*MainActivity.manggiohang.get(i).getSoluongsanpham());
                            exists=true;
                        }
                    }
                    if(exists==false){
                        int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                        long Giamoi=soluong*Giachitiet;
                        MainActivity.manggiohang.add((new GioHang(id_product,Tenchitiet,Giamoi,Hinhanhchitiet,soluong)));

                    }
                }else{
                    int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi=soluong*Giachitiet;
                    MainActivity.manggiohang.add(new GioHang(id_product,Tenchitiet,Giamoi,Hinhanhchitiet,soluong));
                }
                Intent intent=new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void catchEventSpinner() {
        Integer[] soluong=new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer>arrayAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_dropdown_item_1line,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void getInformation() {

        SanPham sanPham= (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
        id_product=sanPham.getId();
        Tenchitiet=sanPham.getName();
        Giachitiet=sanPham.getPrice();
        Hinhanhchitiet=sanPham.getImage();
        Motachitiet=sanPham.getDescription();
        Mau=sanPham.getColor();
        ChatLieu=sanPham.getMaterial();
        Idsanpham=sanPham.getId_type();
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtten.setText(Tenchitiet);
        txtgia.setText("Giá: "+decimalFormat.format(Giachitiet)+" Đồng");
        txtmau.setText(Mau);
        txtchatlieu.setText(ChatLieu);
        txtmota.setText(Motachitiet);
        Picasso.with(getApplicationContext()).load(Hinhanhchitiet)
                .placeholder(R.drawable.loader)
                .error(R.drawable.close)
                .into(imgchitiet);

    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void ratingscore() {
        com.willy.ratingbar.RatingReviews ratingReviews = (RatingReviews) findViewById(R.id.rating_reviews);
        int colors[] = new int[]{
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259")};
        int raters[] = new int[]{
                new Random().nextInt(10),
                new Random().nextInt(10),
                new Random().nextInt(10),
                new Random().nextInt(10),
                new Random().nextInt(10)
        };
        int count = 0;
        ratingReviews.createRatingBars(5, com.willy.ratingbar.BarLabels.STYPE1, colors, raters);
        float tong = 0;
        int j = 1;
        for (int i = 0; i < 5; i++) {
            tong = (float) ((6 - j) * raters[i] + tong);
            count = count + raters[i];
            j++;
        }
        float tb = tong / count;
        txtrate = findViewById(R.id.ScoreView);
        txtrate.setText(String.format("%.1f", tb));
        txttong = findViewById(R.id.textView2);
        txttong.setText(String.valueOf(count));
        RatingBar rbar = (RatingBar) findViewById(R.id.ratingBar);
        rbar.setRating(tb);
    }

    private void Anhxa() {
        ratingbar=(RatingBar) findViewById(R.id.ratingbar);
        btnratingbar=(Button) findViewById(R.id.btnratingbar);
//        btnratingbar.setVisibility(View.INVISIBLE);
//        ratingbar.setVisibility(View.INVISIBLE);
        toolbarchitiet=(Toolbar) findViewById(R.id.toolbarchitietsanpham);
        imgchitiet=(ImageView) findViewById(R.id.imagechitietsanpham);
        txtten=(TextView) findViewById(R.id.textviewtenchitietsanpham);
        txtgia=(TextView) findViewById(R.id.textviewgiachitietsanpham);
        txtmota=(TextView) findViewById(R.id.textviewmotasanpham);
        txtchatlieu=(TextView) findViewById(R.id.txtchatlieu);
        txtmau=(TextView) findViewById(R.id.txtmau);
        spinner=(Spinner)findViewById(R.id.spinner);
        txtcomment = (TextView)findViewById(R.id.textviewcomment);
        buttonmuahang=(Button)findViewById(R.id.buttonmuahang);
        btnratingbar=(Button)findViewById(R.id.btnratingbar);
        btnComments=(Button)findViewById(R.id.btnComments);
        editComments= (EditText) findViewById(R.id.editComments);
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        user_id = preferences.getInt("user_id", 0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugiohang,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent=new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
