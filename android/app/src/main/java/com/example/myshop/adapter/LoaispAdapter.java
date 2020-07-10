package com.example.myshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.model.LoaiSP;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<LoaiSP> ArrayListLoaiSP;
    Context context;

    public LoaispAdapter(ArrayList<LoaiSP> arrayListLoaiSP, Context context) {
        ArrayListLoaiSP = arrayListLoaiSP;
        this.context = context;
    }

    public int getCount() {
        return ArrayListLoaiSP.size();
    }

    @Override
    public Object getItem(int position) {
        return ArrayListLoaiSP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public  class ViewHolder{
      TextView txttenloaisp;
      ImageView imgloaisp;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder =new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listview_loaisp,null);
       viewHolder.txttenloaisp=(TextView) convertView.findViewById(R.id.textviewloaisp);
       viewHolder.imgloaisp=convertView.findViewById(R.id.imageviewloaisp);
       convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        LoaiSP loaiSP=(LoaiSP) getItem(position);
        viewHolder.txttenloaisp.setText(loaiSP.getName());
        Picasso.with(context).load(loaiSP.getImage())
//               .placeholder(R.drawable.loader)
    //            .error(R.drawable.close)
                .into(viewHolder.imgloaisp);
        return convertView;
    }
}
