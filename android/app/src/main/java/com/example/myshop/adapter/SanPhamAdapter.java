package com.example.myshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.activity.ChiTietSanPham;
import com.example.myshop.model.Ratings;
import com.example.myshop.model.SanPham;
import com.example.myshop.ultil.checkConnect;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHolder> {
    //man hinh muon ve
    Context context;
    //mảng
    ArrayList<SanPham> arraysanpham;


    public SanPhamAdapter(Context context, ArrayList<SanPham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sanphammoi,null);
        ItemHolder itemHolder=new ItemHolder(view);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        SanPham sanPham=arraysanpham.get(position);
        holder.txttensanpham.setText(sanPham.getName());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá: "+decimalFormat.format(sanPham.getPrice())+" Đồng");
        Picasso.with(context).load(sanPham.getImage())
                .placeholder(R.drawable.loader)
                .error(R.drawable.close)
                .into(holder.imghinhsanpham);



    }

    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public  class ItemHolder extends  RecyclerView.ViewHolder{
    public ImageView imghinhsanpham;
    public TextView txttensanpham,txtgiasanpham;
    public  ItemHolder(View itemView){
        super(itemView);
        imghinhsanpham=(ImageView) itemView.findViewById(R.id.imgSanPham);
        txttensanpham=(TextView) itemView.findViewById(R.id.txtTenSanPham);
        txtgiasanpham=(TextView) itemView.findViewById(R.id.txtgiaSanPham);
   itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(context, ChiTietSanPham.class);
           intent.putExtra("thongtinsanpham",arraysanpham.get(getPosition()));
     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           checkConnect.ShowToast_Short(context,arraysanpham.get(getPosition()).getName());
      context.startActivity(intent);
       }
   });
    }
}
}
