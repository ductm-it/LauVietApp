package com.example.myshop.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myshop.R;
import com.example.myshop.adapter.GioHangAdapter;
import com.example.myshop.model.GioHang;
import com.example.myshop.ultil.checkConnect;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnthanhtoan,btntieptucmua;
    Toolbar toolbargiohang;
    GioHangAdapter  gioHangAdapter;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        AnhXa();
        ActionToolbar();
        CheckData();
        EventUltil();
        CatchOnItemListView();
        EventClick();
        get();
    }

    private void EventClick() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioHangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size()>0){
                    Intent intent = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                    startActivity(intent);

                }else {
                    checkConnect.ShowToast_Short(getApplicationContext(),"Giở hàng trống không thể thực hiện");
                }
            }
        });
    }

    private void CatchOnItemListView() {
        this.lvgiohang.setLongClickable(true);
        this.lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(MainActivity.manggiohang.size()<=0){
                            txtthongbao.setVisibility((View.VISIBLE));
                        }else {
                            MainActivity.manggiohang.remove(position);
                            gioHangAdapter.notifyDataSetChanged();
                            EventUltil();
                            if(MainActivity.manggiohang.size()<=0){
                                txtthongbao.setVisibility((View.VISIBLE));
                            }
                            else {
                                txtthongbao.setVisibility((View.INVISIBLE));
                                gioHangAdapter.notifyDataSetChanged();
                                EventUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gioHangAdapter.notifyDataSetChanged();
                        EventUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static   void EventUltil() {
        long tongtien=0;
        for(int i=0;i<MainActivity.manggiohang.size();i++){
            tongtien+=MainActivity.manggiohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat=new DecimalFormat(("###,###,###"));
        txttongtien.setText(decimalFormat.format(tongtien)+" Đồng");


    }
    public  void get(){
        //SAVE
        long tongtien=0;
        for(int i=0;i<MainActivity.manggiohang.size();i++){
            tongtien+=MainActivity.manggiohang.get(i).getGiasp();
        }
        SharedPreferences ui = getSharedPreferences("price", MODE_PRIVATE);
        SharedPreferences.Editor edUi = ui.edit();
        edUi.putFloat("tongtien", tongtien);
        edUi.commit();
    }

    private void CheckData() {
        if(MainActivity.manggiohang.size()<=0){
            gioHangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility((View.VISIBLE));
            lvgiohang.setVisibility(View.INVISIBLE);
        }else {
            gioHangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility((View.INVISIBLE));
            lvgiohang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbargiohang);
        //nút home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        lvgiohang=(ListView)findViewById(R.id.listviewgiohang);
        txtthongbao=(TextView)findViewById(R.id.textviewthongbao);
        txttongtien=(TextView)findViewById(R.id.textviewtongtien);
        btnthanhtoan=(Button) findViewById(R.id.buttonthanhtoangiohang);
        btntieptucmua=(Button) findViewById(R.id.buttontieptucmuahang);
        toolbargiohang=(Toolbar) findViewById(R.id.toolbargiohang);
        gioHangAdapter=new GioHangAdapter(GioHangActivity.this,MainActivity.manggiohang);
        lvgiohang.setAdapter(gioHangAdapter);
    }

}
