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

public class ThucAnThemAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraythucanthem;

    public ThucAnThemAdapter(Context context, ArrayList<SanPham> arraythucanthem) {
        this.context = context;
        this.arraythucanthem = arraythucanthem;
    }
    public void setfilter(List<SanPham> actorsList){
        arraythucanthem=new ArrayList<>();
        arraythucanthem.addAll(actorsList);
        notifyDataSetChanged();

    }    @Override
    public int getCount() {
        return arraythucanthem.size();
    }

    @Override
    public Object getItem(int position) {
        return arraythucanthem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class ViewHolder{
        public TextView txtthucanthemTen,getTxtthucanthemGia,getTxtthucanthemMota;
        public ImageView imgthucanthem;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ThucAnThemAdapter.ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_thucanthem,null);
            viewHolder.txtthucanthemTen=(TextView) convertView.findViewById(R.id.txtthucanthemTen);
            viewHolder.getTxtthucanthemGia=(TextView) convertView.findViewById(R.id.txtthucanthemGia);
            viewHolder.getTxtthucanthemMota=(TextView) convertView.findViewById(R.id.txtthucanthemMota);
            viewHolder.imgthucanthem=convertView.findViewById(R.id.imagethucanthem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ThucAnThemAdapter.ViewHolder) convertView.getTag();
        }
        SanPham sanPham=(SanPham) getItem(position);
        viewHolder.txtthucanthemTen.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.getTxtthucanthemGia.setText("Giá: "+decimalFormat.format(sanPham.getPrice())+" Đồng");
        viewHolder.getTxtthucanthemMota.setMaxLines(2);
        viewHolder.getTxtthucanthemMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.getTxtthucanthemMota.setText(sanPham.getDescription() );
        Picasso.with(context).load(sanPham.getImage())
                //     .placeholder(R.drawable.loader)
                //     .error(R.drawable.close)
                .into(viewHolder.imgthucanthem);
        return convertView;
    }
}

