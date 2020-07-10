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

public class RauAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayrau;

    public RauAdapter(Context context, ArrayList<SanPham> arrayrau) {
        this.context = context;
        this.arrayrau = arrayrau;
    }
    public void setfilter(List<SanPham> actorsList){
        arrayrau=new ArrayList<>();
        arrayrau.addAll(actorsList);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return arrayrau.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayrau.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class ViewHolder{
        public TextView txtrauTen,getTxtrauGia,getTxtrauMota;
        public ImageView imgrau;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RauAdapter.ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_rau,null);
            viewHolder.txtrauTen=(TextView) convertView.findViewById(R.id.txtrauTen);
            viewHolder.getTxtrauGia=(TextView) convertView.findViewById(R.id.txtrauGia);
            viewHolder.getTxtrauMota=(TextView) convertView.findViewById(R.id.txtrauMota);
            viewHolder.imgrau=convertView.findViewById(R.id.imagerau);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (RauAdapter.ViewHolder) convertView.getTag();
        }
        SanPham sanPham=(SanPham) getItem(position);
        viewHolder.txtrauTen.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.getTxtrauGia.setText("Giá: "+decimalFormat.format(sanPham.getPrice())+" Đồng");
        viewHolder.getTxtrauMota.setMaxLines(2);
        viewHolder.getTxtrauMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.getTxtrauMota.setText(sanPham.getDescription() );
        Picasso.with(context).load(sanPham.getImage())
                //     .placeholder(R.drawable.loader)
                //     .error(R.drawable.close)
                .into(viewHolder.imgrau);
        return convertView;
    }
}
