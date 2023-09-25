package com.example.food2.Adaptor;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food2.Domain.FoodDomain;
import com.example.food2.R;
import com.example.food2.ShowDetailActivity;
import  com.example.food2.products.product;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductsAdptor extends RecyclerView.Adapter<ProductsAdptor.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflatre= LayoutInflater.from(parent.getContext()).inflate(R.layout.productsview,parent,false);



        return  new ViewHolder(inflatre);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.fee.setText( Double.toString(list.get(position).getFee()));

        holder.title.setText(list.get(position).getTitle());
        holder.fee.setText(String.valueOf(list.get(position).getFee()));

        //int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(list.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getPic())
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                ShowDetailActivity.object=list.get(position);
                holder.itemView.getContext().startActivity(intent);
            }
        });

//        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(list.get(position).getName(),"drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.pic);
//        holder.addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
//                intent.putExtra("object",popularFood.get(position));
//                holder.itemView.getContext().startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee,addBtn;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addBtn=itemView.findViewById(R.id.addBtn);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);


            ((TextView)(itemView.findViewById(R.id.addBtn))).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* Bitmap bitm=((BitmapDrawable)pic.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream=new ByteArrayOutputStream();
                    bitm.compress(Bitmap.CompressFormat.PNG,100,stream);
                    byte[]bytes=stream.toByteArray();*/
                    Intent  inten=new Intent(cont, ShowDetailActivity.class);
                    inten.putExtra("type",title.getText().toString());
                    ShowDetailActivity.d=pic.getDrawable();
                    inten.putExtra("price",fee.getText().toString());
                    cont.startActivity(inten);
                }
            });
        }
    }
    ArrayList<FoodDomain> list;
    Context cont;

    public ProductsAdptor(ArrayList<FoodDomain> list, Context cont) {
        this.list = list;
        this.cont = cont;
    }


}
