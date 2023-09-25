package com.example.food2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food2.Domain.FoodDomain;
import com.example.food2.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
    private ImageView plusBtn ,minusBtn,picFood;
    public static FoodDomain object;
    int numberOrder=1;
    private ManagementCart managementCart;
    public static Drawable d;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);
        initview();
        meaw();



        Intent intent=getIntent();
        String tite=intent.getStringExtra("type");
        String fee=intent.getStringExtra("price");
        titleTxt.setText(tite);
        feeTxt.setText(fee);
            getBundele();



        picFood.setImageDrawable(d);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

    }


    private void getBundele() {

       /* object=(FoodDomain) getIntent().getSerializableExtra("object");
        //int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());*/
        Glide.with(this)
                .load(object.getPic())
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText(""+object.getFee()+" Dh");
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insetFood(object);
           }
        });

    }

    private void initview() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picFood);
    }

    private void meaw(){

//        if(tite.equals("Quatre Saisons")){
//            descriptionTxt.setText("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//        }
    }
}