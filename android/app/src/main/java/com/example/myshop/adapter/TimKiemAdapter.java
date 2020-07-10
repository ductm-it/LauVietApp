package com.example.myshop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myshop.R;
import com.example.myshop.model.SanPham;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class TimKiemAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> array;

    public TimKiemAdapter(Context context, ArrayList<SanPham> array) {
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return array.indexOf(getItem(position));

    }
    public void setfilter(List<SanPham>actorsList){
        array=new ArrayList<>();
        array.addAll(actorsList);
        notifyDataSetChanged();

    }

    public  class ViewHolder{
        public TextView txtTen,TxtGia,TxtMota;
        public ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_search,null);
            viewHolder.txtTen=(TextView) convertView.findViewById(R.id.txtTen);
            viewHolder.TxtGia=(TextView) convertView.findViewById(R.id.txtGia);
            viewHolder.TxtMota=(TextView) convertView.findViewById(R.id.txtmota);
            viewHolder.img=convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        SanPham sanPham=(SanPham) getItem(position);
        viewHolder.txtTen.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.TxtGia.setText("Giá:"+decimalFormat.format(sanPham.getPrice())+"Đ");
        viewHolder.TxtMota.setMaxLines(2);
        viewHolder.TxtMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.TxtMota.setText(sanPham.getDescription() );
        Picasso.with(context).load(sanPham.getImage())
                //     .placeholder(R.drawable.loader)
                //     .error(R.drawable.close)
                .into(viewHolder.img);
        return convertView;
    }
}