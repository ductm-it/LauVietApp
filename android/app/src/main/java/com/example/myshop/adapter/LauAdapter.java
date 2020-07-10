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

public class LauAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraylau;

    public LauAdapter(Context context, ArrayList<SanPham> arraylau) {
        this.context = context;
        this.arraylau = arraylau;
    }

    @Override
    public int getCount() {
        return arraylau.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylau.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arraylau.indexOf(getItem(position));

    }
    public void setfilter(List<SanPham>actorsList){
        arraylau=new ArrayList<>();
        arraylau.addAll(actorsList);
        notifyDataSetChanged();

    }

    public  class ViewHolder{
        public TextView txtlauTen,getTxtlauGia,getTxtlauMota;
        public ImageView imglau;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_lau,null);
            viewHolder.txtlauTen=(TextView) convertView.findViewById(R.id.txtlauTen);
            viewHolder.getTxtlauGia=(TextView) convertView.findViewById(R.id.txtlauGia);
            viewHolder.getTxtlauMota=(TextView) convertView.findViewById(R.id.txtmotalau);
            viewHolder.imglau=convertView.findViewById(R.id.imagelau);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        SanPham sanPham=(SanPham) getItem(position);
        viewHolder.txtlauTen.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.getTxtlauGia.setText("Giá: "+decimalFormat.format(sanPham.getPrice())+" Đồng");
        viewHolder.getTxtlauMota.setMaxLines(2);
        viewHolder.getTxtlauMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.getTxtlauMota.setText(sanPham.getDescription() );
        Picasso.with(context).load(sanPham.getImage())
           //     .placeholder(R.drawable.loader)
           //     .error(R.drawable.close)
                .into(viewHolder.imglau);
        return convertView;
    }
}
