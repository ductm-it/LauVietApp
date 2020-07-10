package com.example.myshop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;


import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.adapter.ThucAnThemAdapter;
import com.example.myshop.model.SanPham;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThucAnThemActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbarthucanthem;
    ListView listViewthucanthem;
    ThucAnThemAdapter thucAnThemAdapter;
    ArrayList<SanPham> mangthucanthem;
    private SearchView searchView;
    int idthucanthem=0;
    int page=1;
    View footerview;
    boolean isLoading=false;
    boolean limitData=false;
    mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_an_them);
        AnhXa();
        if (checkConnect.haveNetworkConnection(getApplicationContext())) {
            //
            GetIdLoaiSP();
            ActionToolbar();
            GetData(page);
            //processbar footerview
           LoadMoreData();

        } else {
            checkConnect.ShowToast_Short(getApplicationContext(), "kiem tra ket noi");
            finish();
        }

    }

    private void AnhXa() {
        toolbarthucanthem=(Toolbar) findViewById(R.id.toolbarthucanthem);
        listViewthucanthem=(ListView) findViewById(R.id.listviewthucanthem);
        //truyền dữ liệu vào mảng
        mangthucanthem=new ArrayList<>();
        thucAnThemAdapter =new ThucAnThemAdapter(getApplicationContext(),mangthucanthem);
        listViewthucanthem.setAdapter(thucAnThemAdapter);
        //processbar footer
        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview=inflater.inflate(R.layout.progressbar,null);
        mHandler=new mHandler();
    }
    private void GetIdLoaiSP() {
        idthucanthem=getIntent().getIntExtra("idloaisanpham",-1);
        Log.d("giatriloaisanpham",idthucanthem+"");
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbarthucanthem);
        //nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarthucanthem.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void GetData(int Page) {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String duongdan= server.DuongdanSP+ String.valueOf(Page);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int ID=0;
                String Tensanpham="";
                Integer Giasanpham=0;
                String Hinhanhsanpham="";
                String Motasanpham="";
                String Mau="";
                String ChatLieu="";
                int IDtype=0;
                if(response!=null && response.length()!=2){
                    listViewthucanthem.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            ID=jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("name");
                            Hinhanhsanpham = jsonObject.getString("image");
                            Giasanpham = jsonObject.getInt("price");
                            Mau = jsonObject.getString("color");
                            ChatLieu = jsonObject.getString("material");
                            Motasanpham = jsonObject.getString("description");
                            IDtype = jsonObject.getInt("id_type");
                            mangthucanthem.add((new SanPham(ID,Tensanpham,Hinhanhsanpham,Giasanpham,Mau,ChatLieu,Motasanpham,IDtype)));
                            thucAnThemAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitData=true;
                    listViewthucanthem.removeFooterView(footerview);
                   //checkConnect.ShowToast_Short(getApplicationContext(),"No data");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Đẩy và truyền dữ liệu lên server
                HashMap<String, String> map=new HashMap<String, String>();
                map.put("id_type",String.valueOf(idthucanthem));
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void LoadMoreData() {
        //chi tiet san pham
        listViewthucanthem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //chuyển màn hình
                Intent intent=new Intent(getApplicationContext(),ChiTietSanPham.class);
                SanPham product = (SanPham) thucAnThemAdapter.getItem(position);
                intent.putExtra("thongtinsanpham",product);
                startActivity(intent);
            }
        });

        //sự kiện kéo xuống
        listViewthucanthem.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem+visibleItemCount==totalItemCount && totalItemCount!=0 && isLoading==false &&limitData==false){
                    isLoading=true;
                    ThreadData threadData=new ThreadData();
                    threadData.start();
                }
            }
        });
    }
    public class mHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    listViewthucanthem.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading=false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message=mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_main, menu);

        final MenuItem menuItem = menu.findItem(R.id.search);
        searchView = (SearchView) menuItem.getActionView();
        ((EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.white));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                menuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<SanPham> filterModList = filter(mangthucanthem, newText);
                thucAnThemAdapter.setfilter(filterModList);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    private List<SanPham> filter(List<SanPham> hi, String query) {
        query = query.toLowerCase();
        final List<SanPham> filterModeList = new ArrayList<>();
        for (SanPham modal : hi) {
            final String text = modal.getName().toLowerCase();
            if (text.startsWith(query)) {
                filterModeList.add(modal);
            }
        }
        return filterModeList;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menugiohang,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menugiohang:
//                Intent intent=new Intent(getApplicationContext(), GioHang.class);
//                startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
