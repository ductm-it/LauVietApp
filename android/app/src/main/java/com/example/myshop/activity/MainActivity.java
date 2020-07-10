package com.example.myshop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.adapter.LoaispAdapter;
import com.example.myshop.adapter.SanPhamAdapter;
import com.example.myshop.model.GioHang;
import com.example.myshop.model.LoaiSP;
import com.example.myshop.model.SanPham;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

TextView txtten,txtemail,txtlogout;
Button btnLogout;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView1;
    NavigationView navigationView;
    ListView listView1;
    DrawerLayout drawerLayout;
    ArrayList<LoaiSP> mangloaisp;
    ArrayList<SanPham> mangsanpham;
    SanPhamAdapter sanPhamAdapter;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";
    public static  ArrayList<GioHang> manggiohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();


        if (checkConnect.haveNetworkConnection(getApplicationContext())) {
            //
            ActionBar();
            //slide3
            ActionViewFlipper();
            getdulieuloaiSP();
            getdulieuSPMoi();
            getInformation();
            //sự kien menu
            catchOnItemListView();
            //logout
            ButtonLogout();
        } else {
            checkConnect.ShowToast_Short(getApplicationContext(), "kiem tra ket noi");
            finish();
        }


    }

    private void catchOnItemListView() {
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                    if(checkConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                    case 1:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this, LauActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(position).getId());
                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this, ThucAnThemActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(position).getId());
                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this, NuocUongActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(position).getId());
                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this, RauActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(position).getId());
                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this, TimKiemActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(position).getId());
                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case 6:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,ThongTinActivity.class);

                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case 7:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);

                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 8:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,ThongBaoActivity.class);

                           startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 9:
                        if(checkConnect.haveNetworkConnection(getApplicationContext())){
                            Intent intent=new Intent(MainActivity.this,LichSuDHActivity.class);

                            startActivity(intent);
                        }
                        else {
                            checkConnect.ShowToast_Short(getApplicationContext(),"Lỗi mạng");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void getdulieuSPMoi() {
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
    JsonRequest jsonRequest=new JsonArrayRequest(server.DuongdanSPmoi, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            if(response!=null){
                int ID=0;
                String Tensanpham="";
    Integer Giasanpham=0;
    String Hinhanhsanpham="";
                String Mau="";
                String ChatLieu="";
    String Motasanpham="";
    int IDtype=0;
    for (int i=0;i<response.length();i++){
        try {
            JSONObject jsonObject = response.getJSONObject(i);
            ID = jsonObject.getInt("id");
            Tensanpham = jsonObject.getString("name");
            Hinhanhsanpham = jsonObject.getString("image");
            Giasanpham = jsonObject.getInt("price");
            Mau = jsonObject.getString("color");
            ChatLieu = jsonObject.getString("material");
            Motasanpham = jsonObject.getString("description");
            IDtype = jsonObject.getInt("id_type");
            mangsanpham.add((new SanPham(ID,Tensanpham,Hinhanhsanpham,Giasanpham,Mau,ChatLieu,Motasanpham,IDtype)));
            sanPhamAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
       requestQueue.add(jsonRequest);
    }

    private void getdulieuloaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.Duongdanloaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("name");
                            hinhanhloaisp = jsonObject.getString("image");
                            mangloaisp.add((new LoaiSP(id, tenloaisp, hinhanhloaisp)));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
//mangloaisp.add(3,new LoaiSP())
                    mangloaisp.add(5, new LoaiSP(0, "Search...", "https://img.icons8.com/clouds/2x/search.png"));
                    mangloaisp.add(6, new LoaiSP(0, "Change Info", "https://cdn3.iconfinder.com/data/icons/team-and-work/100/work_process_man_management-13-512.png"));
                    mangloaisp.add(7, new LoaiSP(0, "Login", "https://img.pngio.com/login-icons-free-download-png-and-svg-login-icon-png-200_200.png"));
                    mangloaisp.add(8, new LoaiSP(0, "Notification", "https://elib.ntt.edu.vn/KIPOSDATA0/KIPOSSysWebFiles/images/ThongBao/iconThongBao.png"));
                    if(txtten.getText().toString() == ""){ }
                    else {

                        mangloaisp.add(9, new LoaiSP(0, "Lịch sử đơn hàng", "https://img.icons8.com/ios/2x/order-history.png"));
                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                checkConnect.ShowToast_Short(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    //slide
    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add ("https://hotpotstory.vn/wp-content/uploads/2019/07/banner_trong.jpg");
        mangquangcao.add("https://cdn-www.vinid.net/2020/01/Hotpot-Story-he-thong-Mien-Nam-gia-chi-250.000-dong.jpg");
        mangquangcao.add("https://cdn.jamja.vn/blog/wp-content/uploads/2019/09/Hotpot-Story-1.jpeg");
        mangquangcao.add("https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/81/2016/12/02064629/Restaurants_Bars-Section-1st-Restaurant-Detail-The-Square-restaurant1.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(8000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }


    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }

    private void AnhXa() {
//      btnLogout=(Button) findViewById(R.id.btnlogout);
        txtlogout=(TextView) findViewById(R.id.txtlogout);
        txtten=(TextView) findViewById(R.id.txttenDN);
        txtemail=(TextView) findViewById(R.id.txtemail);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerView1 = (RecyclerView) findViewById(R.id.RecyclerView1);
        navigationView = (NavigationView) findViewById(R.id.NavigationView);
        listView1 = (ListView) findViewById(R.id.listview1);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        //loai san pham
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0, new LoaiSP(0, "LẨU VIỆT", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR36957IwlV0-Hi53dLK39T8feD5K9NCls4pCsit49AVInYTD0&s"));
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listView1.setAdapter(loaispAdapter);
        //san pham
        mangsanpham=new ArrayList<>();
        sanPhamAdapter=new SanPhamAdapter(getApplicationContext(),mangsanpham);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView1.setAdapter(sanPhamAdapter);
        if(manggiohang!=null){

        }else {
            manggiohang=new ArrayList<>();
        }
    }
    private void getInformation() {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String user_name = preferences.getString("user_name", "");
        String email = preferences.getString("email", "");
        txtten.setText(user_name);
        txtemail.setText(email);

        if(txtten.getText().toString() == ""){
            txtlogout.setVisibility((View.INVISIBLE));
        }
        else {
            txtlogout.setVisibility((View.VISIBLE));
        }


    }

    private void ButtonLogout() {

txtlogout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        finish();

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }
});
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

