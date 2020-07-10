package com.example.myshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.adapter.LSDonHangAdapter;
import com.example.myshop.model.DonHang;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LichSuDHActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    ListView listView;
    LSDonHangAdapter donHangAdapter;
    ArrayList<DonHang> mangDonHang;
    private SearchView searchView;

    int page=1;
    View footerview;
    boolean isLoading=false;
    boolean limitData=false;
    mHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_d_h);
        AnhXa();
        if (checkConnect.haveNetworkConnection(getApplicationContext())) {

            ActionToolbar();
            getdulieuDonHang(page);
            LoadMoreData();

        } else {
            checkConnect.ShowToast_Short(getApplicationContext(), "kiem tra ket noi");
            finish();
        }
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
        toolbar=(Toolbar) findViewById(R.id.toolbarDonHang);
        listView=(ListView) findViewById(R.id.listviewDonHang);
        //truyền dữ liệu vào mảng
        mangDonHang=new ArrayList<>();
        donHangAdapter=new LSDonHangAdapter(getApplicationContext(),mangDonHang);
        listView.setAdapter(donHangAdapter);
        //processbar footer
        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview=inflater.inflate(R.layout.progressbar,null);
        mHandler=new mHandler();


    }
    private void getdulieuDonHang(int Page) {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

        final int id_customer = preferences.getInt("user_id",0);

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String duongdan= server.getLSDonHang+String.valueOf(Page);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int Id=0;
                int id_customer=0;
                String date_order="";
                float total=0;

                if(response!=null && response.length()!=2){
                    listView.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            Id=jsonObject.getInt("id");
                            id_customer = jsonObject.getInt("id_customer");
                            date_order =  jsonObject.getString("date_order");
                            total =  jsonObject.getLong("total");

                            // IDtype = jsonObject.getInt("id_type");
                            mangDonHang.add((new DonHang(Id,id_customer,date_order,total)));
                            donHangAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitData=true;
                    listView.removeFooterView(footerview);
                    // checkConnect.ShowToast_Short(getApplicationContext(),"");
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
                map.put("id_customer",String.valueOf(id_customer));
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void LoadMoreData() {
        //chi tiet san pham
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //chuyển màn hình
                Intent intent=new Intent(getApplicationContext(),ChiTietDonHangActivity.class);
                DonHang donHang = (DonHang) donHangAdapter.getItem(position);

                intent.putExtra("thongtindonhang", mangDonHang.get(position).getId());
                startActivity(intent);
            }
        });

        //sự kiện kéo xuống
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
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
                    listView.addFooterView(footerview);
                    break;
                case 1:
                    getdulieuDonHang(++page);
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
                final List<DonHang> filterModList = filter(mangDonHang, newText);
                donHangAdapter.setfilter(filterModList);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    private List<DonHang> filter(List<DonHang> hi, String query) {
        query = query.toLowerCase();
        final List<DonHang> filterModeList = new ArrayList<>();
        for (DonHang modal : hi) {
            final String text = modal.getDate_order().toLowerCase();
            if (text.startsWith(query)) {
                filterModeList.add(modal);
            }
        }
        return filterModeList;
    }

}
