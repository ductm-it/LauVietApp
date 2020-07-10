package com.example.myshop.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myshop.R;
import com.example.myshop.activity.RatingActivity;
import com.example.myshop.activity.MainActivity;
import com.example.myshop.model.GioHang;
import com.example.myshop.model.SanPham;
import com.example.myshop.ultil.checkConnect;
import com.example.myshop.ultil.server;
import com.squareup.picasso.Picasso;
import com.willy.ratingbar.RotationRatingBar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class RatingAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> arrayGioHang;

    public RatingAdapter(Context context, ArrayList<GioHang> arrayGioHang) {
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
    public class ViewHolder{
        public TextView txttengiohang,txtgiagiohang,txtgiatri;
        public ImageView imggiohang;
        public RotationRatingBar ratingbar;
        public Button btnproductrating;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RatingAdapter.ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder= new RatingAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_rating,null);

            viewHolder.txttengiohang=(TextView) convertView.findViewById(R.id.textviewtengiohang);
            viewHolder.txtgiagiohang=(TextView) convertView.findViewById(R.id.textviewgiagiohang);
            viewHolder.imggiohang=(ImageView) convertView.findViewById(R.id.imageviewgiohang);
            viewHolder.txtgiatri=(TextView) convertView.findViewById(R.id.textviewgiatri);
            viewHolder.ratingbar=(RotationRatingBar) convertView.findViewById(R.id.rotationRatingBar);
            viewHolder.btnproductrating=(Button) convertView.findViewById(R.id.buttonproductrating);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (RatingAdapter.ViewHolder) convertView.getTag();
        }
        GioHang gioHang= (GioHang) getItem(position);
        viewHolder.txttengiohang.setText(gioHang.getTensp());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(gioHang.getGiasp())+"Đ");
        Picasso.with(context).load(gioHang.getHinhsp())
                .placeholder(R.drawable.loader)
                .error(R.drawable.close)
                .into(viewHolder.imggiohang);
        viewHolder.txtgiatri.setText(gioHang.getSoluongsanpham()+"");
        viewHolder.ratingbar.setRating(5);
        final float diem = viewHolder.ratingbar.getRating();

        viewHolder.ratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.manggiohang.get(position).setStar(diem);
            }
        });


//        private void Raiting() {
//            viewHolder.btnproductrating.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
//                    user_id = preferences.getInt("user_id", 0);
//                    star = ratingbar.getRating();
//                    getdata(id_product,user_id,star);
//                }
//
//            });
//
//        }
//
//        private void Raiting() {
//            btnratingbar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    GioHang gioHang= (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
//                    id_product=sanPham.getId();
//                    SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
//                    user_id = preferences.getInt("user_id", 0);
//                    star = rating.getRating();
//                    getdata(id_product,user_id,star);
//                }
//
//            });
//
//        }
//
//        private void getdata(final int id_product, final int user_id, final Float star) {
//            RequestQueue requestQueue = Volley.newRequestQueue((context.getApplicationContext()));
//            StringRequest request = new StringRequest(Request.Method.POST, server.DuongdanRaiting,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(final String response) {
//
////                            Toast.makeText(getApplication(),"Số sao: "+rating.getRating(),Toast.LENGTH_LONG).show();
//                            checkConnect.ShowToast_Short(context.getApplicationContext(),"Success ");
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            VolleyLog.d("Error: " + error.getMessage());
//                        }
//                    }) {
//
//                @Override
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<>();
//                    params.put("id_product", String.valueOf(id_product));
//                    params.put("user_id", String.valueOf(user_id));
//                    params.put("star", String.valueOf(star));
//
//                    return params;
//                }
//            };
//            requestQueue.add(request);
//        }


        final RatingAdapter.ViewHolder finalViewHolder = viewHolder;
        return convertView;
    }

}