package com.example.food2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toolbar;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.food2.Adaptor.CategoryAdaptor;
import com.example.food2.Adaptor.PopularAdaptor;
import com.example.food2.Domain.CategoryDomain;
import com.example.food2.Domain.FoodDomain;
import com.example.food2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
TextView textView;
ImageView imageView;
Animation topAnimation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bottomNavigation();
        recyclerViewCategory();
        recyclerViewPopular();
//        text();


        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        textView=findViewById(R.id.textView);
        textView.setAnimation(topAnimation);

        imageView=findViewById(R.id.imageView5);
        imageView.setAnimation(topAnimation);


    }



    @Override
    public void onBackPressed() {
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout Support = findViewById(R.id.supportBtn);
        LinearLayout Sittings = findViewById(R.id.settingsBtn);
        LinearLayout Profil = findViewById(R.id.profileBtn);
        ImageView profile=findViewById(R.id.imageView5);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(MainActivity.this, ProfileActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(o,b);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(MainActivity.this, CartListActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(o,b);
            }
        });

        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(MainActivity.this, SupportActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(o,b);

            }
        });
        Sittings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(i,b);
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain>category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdaptor(this,category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Quatre Saisons",R.drawable.pizza1,"The fun thing about this pizza is the choice of ingredients, each representing a season of the year, of which they are their own.",30.5,10));
        foodList.add(new FoodDomain("Burger Beef",R.drawable.burger2," Bread Cut the bread in half and brown the inside in a pan Sauce Mix the Hellmann's mayonnaise with the paprika and chili paste Stuffing Coarsely chop the beef with a knifeou dans un hachoir",30.5,10));
        foodList.add(new FoodDomain("Za3ze3",R.drawable.drink3,"Za3za3 : A drink or beverage is a Liquid intended for consumption. There are cold or hot drinks، carbonated.",30.5,10));
        foodList.add(new FoodDomain("Tacos",R.drawable.tacos,"Ce dindon déchiqueté est excellent pour les tacos, mais on peut aussi l’utiliser pour les nachos, la pizza ou même les sandwiches.",30.5,10));
        foodList.add(new FoodDomain("Panini",R.drawable.panini,"This Roast Beef Panini recipe has become one of our favorite sandwiches to make for lunch or dinner I’ve always thought the word “sandwich” is such a blasé kind of thing. Not appetizing for me in the least bit. But change “sandwich” to “panini” and it’s like magic happens.",15.5,10));


        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

}