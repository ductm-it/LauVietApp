package com.example.myshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.model.DonHang;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LSDonHangAdapter extends BaseAdapter {

    Context context;
    ArrayList<DonHang> arrayDonHang;

    public LSDonHangAdapter(Context context, ArrayList<DonHang> arrayDonHang) {
        this.context = context;
        this.arrayDonHang = arrayDonHang;
    }

    @Override
    public int getCount() {
        return arrayDonHang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayDonHang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class ViewHolder{
        public TextView txtmadonhang,txtngaydathang,txttongtien;

    }
    public void setfilter(List<DonHang> actorsList){
        arrayDonHang=new ArrayList<>();
        arrayDonHang.addAll(actorsList);
        notifyDataSetChanged();

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LSDonHangAdapter.ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_lichsudonhang,null);
            viewHolder.txtmadonhang=(TextView) convertView.findViewById(R.id.txtMaDonHang);
            viewHolder.txtngaydathang=(TextView) convertView.findViewById(R.id.txtNgayDatHang);
            viewHolder.txttongtien=(TextView) convertView.findViewById(R.id.txtTongTien);

            convertView.setTag(viewHolder);
        }else {
            viewHolder= (LSDonHangAdapter.ViewHolder) convertView.getTag();
        }
        DonHang donHang=(DonHang) getItem(position);
        viewHolder.txtmadonhang.setText(""+donHang.getId());
        viewHolder.txtngaydathang.setText(donHang.getDate_order());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txttongtien.setText(""+decimalFormat.format(donHang.getTotal())+"Đ");

        return convertView;
    }
}
