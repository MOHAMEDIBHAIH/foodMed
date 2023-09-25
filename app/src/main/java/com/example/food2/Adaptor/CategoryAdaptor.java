package com.example.food2.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food2.CartListActivity;
import com.example.food2.CategoryAct;
import com.example.food2.Domain.CategoryDomain;
import com.example.food2.MainActivity;
import com.example.food2.R;

import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    ArrayList<CategoryDomain>categoryDomains;

    Context cont;



    public CategoryAdaptor(Context cont ,ArrayList<CategoryDomain> categoryDomains) {
        this.cont = cont;
        this.categoryDomains = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatre= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
//        ((Button)inflatre.findViewById(R.id.)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        inflatre.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            TextView txt = view.findViewById(R.id.categoryName);

                                            String name = txt.getText().toString();
                                            Intent i = new Intent(cont, CategoryAct.class);
                                            i.putExtra("type", name);
                                            cont.startActivity(i);
                                        }
                                    });



            /*

                switch(name){
                    case "Pizza":
                        i.putExtra("type","pizza");
                        break;
                    case "Burger":
                        i.putExtra("type","burg");
                        break;
                    case "Hotdog":
                        i.putExtra("type","hotdog");
                        break;
                    case "Drink":
                        i.putExtra("type","drink");
                        break;
                    case "Donut":*/

                // break;

                // }
                // cont.startActivity(i);


        return new ViewHolder(inflatre);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.categoryName.setText(categoryDomains.get(position).getTitle());
String picUrl="";
        switch(position){
            case 0:{
                picUrl="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
            break;
            }
            case 1:{
                picUrl="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
            break;
            }
            case 2:{
                picUrl="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
            break;
            }
            case 3:{
                picUrl="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
            break;
            }
            case 4:{
                picUrl="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
            break;
            }
        }
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);

    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById((R.id.mainLayout));

        }
    }
}
