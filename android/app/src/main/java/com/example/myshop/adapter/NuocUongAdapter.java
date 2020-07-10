package com.example.myshop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NuocUongAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraynuocuong;

    public NuocUongAdapter(Context context, ArrayList<SanPham> arraynuocuong) {
        this.context = context;
        this.arraynuocuong = arraynuocuong;
    }
    public void setfilter(List<SanPham> actorsList){
        arraynuocuong=new ArrayList<>();
        arraynuocuong.addAll(actorsList);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return arraynuocuong.size();
    }

    @Override
    public Object getItem(int position) {
        return arraynuocuong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class ViewHolder{
        public TextView txtnuocuongTen,getTxtnuocuongGia,getTxtnuocuongMota;
        public ImageView imgnuocuong;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NuocUongAdapter.ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_nuocuong,null);
            viewHolder.txtnuocuongTen=(TextView) convertView.findViewById(R.id.txtnuocuongTen);
            viewHolder.getTxtnuocuongGia=(TextView) convertView.findViewById(R.id.txtnuocuongGia);
            viewHolder.getTxtnuocuongMota=(TextView) convertView.findViewById(R.id.txtnuocuongMota);
            viewHolder.imgnuocuong=convertView.findViewById(R.id.imagenuocuong);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (NuocUongAdapter.ViewHolder) convertView.getTag();
        }
        SanPham sanPham=(SanPham) getItem(position);
        viewHolder.txtnuocuongTen.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.getTxtnuocuongGia.setText("Giá: "+decimalFormat.format(sanPham.getPrice())+" Đồng");
        viewHolder.getTxtnuocuongMota.setMaxLines(2);
        viewHolder.getTxtnuocuongMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.getTxtnuocuongMota.setText(sanPham.getDescription() );
        Picasso.with(context).load(sanPham.getImage())
                //     .placeholder(R.drawable.loader)
                //     .error(R.drawable.close)
                .into(viewHolder.imgnuocuong);
        return convertView;
    }
}
