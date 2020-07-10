package com.example.myshop.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.myshop.R;
import com.example.myshop.activity.GioHangActivity;
import com.example.myshop.activity.MainActivity;
import com.example.myshop.activity.RatingActivity;
import com.example.myshop.model.GioHang;
import com.example.myshop.ultil.checkConnect;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayGioHang;

    public GioHangAdapter(Context context, ArrayList<GioHang> arrayGioHang) {
        this.context = context;
        this.arrayGioHang = arrayGioHang;
    }

    @Override
    public int getCount() {
        return arrayGioHang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayGioHang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imggiohang;
        public Button btntang,btngiam,btngiatri;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_giohang,null);
            viewHolder.txttengiohang=(TextView) convertView.findViewById(R.id.textviewtengiohang);
            viewHolder.txtgiagiohang=(TextView) convertView.findViewById(R.id.textviewgiagiohang);
            viewHolder.imggiohang=(ImageView) convertView.findViewById(R.id.imageviewgiohang);
            viewHolder.btngiam=(Button) convertView.findViewById(R.id.buttongiam);
            viewHolder.btntang=(Button) convertView.findViewById(R.id.buttontang);
            viewHolder.btngiatri=(Button) convertView.findViewById(R.id.buttongiatri);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        GioHang gioHang= (GioHang) getItem(position);
        viewHolder.txttengiohang.setText(gioHang.getTensp());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(gioHang.getGiasp())+"Đ");
        Picasso.with(context).load(gioHang.getHinhsp())
                .placeholder(R.drawable.loader)
                .error(R.drawable.close)
                .into(viewHolder.imggiohang);
        viewHolder.btngiatri.setText(gioHang.getSoluongsanpham()+"");

//       int sl= Integer.parseInt(viewHolder.btngiatri.getText().toString());
//       if(sl>=10){
//
//       }else if(sl<=1){
//           viewHolder.btngiam.setVisibility(View.INVISIBLE);
//        }else if(sl>=1){
//           viewHolder.btntang.setVisibility(View.VISIBLE);
//           viewHolder.btngiam.setVisibility(View.VISIBLE);
//        }
        final ViewHolder finalViewHolder = viewHolder;
        int sl=Integer.parseInt(finalViewHolder.btngiatri.getText().toString());
        if(sl==1) {
            finalViewHolder.btngiam.setText("Huỷ món");
        } else{
            finalViewHolder.btngiam.setText("-");
        }
        viewHolder.btntang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat=Integer.parseInt(finalViewHolder.btngiatri.getText().toString())+1;
                int slht= MainActivity.manggiohang.get(position).getSoluongsanpham();
                long giaht=MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsanpham(slmoinhat);
                long giamoinhat=(giaht*slmoinhat)/slht;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+"Đ");
                GioHangActivity.EventUltil();
                finalViewHolder.btngiam.setText("-");
                if(slmoinhat>9){
                    finalViewHolder.btntang.setVisibility(View.INVISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
                else {
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });

        viewHolder.btngiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat=Integer.parseInt(finalViewHolder.btngiatri.getText().toString())-1;
                int slht= MainActivity.manggiohang.get(position).getSoluongsanpham();
                long giaht=MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsanpham(slmoinhat);
                long giamoinhat=(giaht*slmoinhat)/slht;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+"Đ");
                GioHangActivity.EventUltil();
                if(slmoinhat==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Hủy món");
                    alertDialog.setMessage("Đã hủy món bạn chọn");
                    arrayGioHang.remove(arrayGioHang.get(position));
                    // Setting Positive "Yes" Button

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"Xác nhận", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertDialog.show();

                }
                else if(slmoinhat==1){
                    finalViewHolder.btngiam.setText("Huỷ món");
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
                else {
                    finalViewHolder.btngiam.setText("-");
                    finalViewHolder.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });

        return convertView;
    }


}
