package com.example.myshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.activity.ChiTietSanPham;
import com.example.myshop.model.Comments;
import com.example.myshop.ultil.checkConnect;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ItemHolder> {
    //man hinh muon ve
    Context context;
    //mảng
    ArrayList<Comments> arrayComment;


    public CommentAdapter(Context context, ArrayList<Comments> arrayComment) {
        this.context = context;
        this.arrayComment = arrayComment;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment,null);
        ItemHolder itemHolder=new ItemHolder(view);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Comments comments=arrayComment.get(position);
        holder.txtTen.setText(comments.getId_customer());
        holder.txtBinhluan.setText(comments.getComments());

    }

    @Override
    public int getItemCount() {
        return arrayComment.size();
    }

    public  class ItemHolder extends  RecyclerView.ViewHolder{
        public TextView txtTen,txtBinhluan;


        public  ItemHolder(View itemView){
            super(itemView);

            txtTen=(TextView) itemView.findViewById(R.id.txtTen);
            txtBinhluan=(TextView) itemView.findViewById(R.id.txtComment);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ChiTietSanPham.class);
                    intent.putExtra("thongtinsanpham",arrayComment.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    checkConnect.ShowToast_Short(context,arrayComment.get(getPosition()).getComments());
                    context.startActivity(intent);
                }
            });
        }
    }
}
