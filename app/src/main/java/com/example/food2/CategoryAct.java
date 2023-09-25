package com.example.food2;
import com.example.food2.Adaptor.ProductsAdptor;
import com.example.food2.Domain.FoodDomain;
import com.example.food2.products.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class CategoryAct extends AppCompatActivity {
    private RecyclerView recyclerViewCat;
    String type;
    ArrayList <FoodDomain> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerViewCat=findViewById(R.id.recyclerViewCat);
        Intent iten=getIntent();
        type=iten.getStringExtra("type");
        ProductsAdptor adpt;

        if(type.equals("Pizza")){
            list.add(new FoodDomain("Quatre Saisons",R.drawable.pizza1,21.0,"The fun thing about this pizza is the choice of ingredients, each representing a season of the year, of which they are their own."));
            list.add(new FoodDomain("Double Formage",R.drawable.pizza2,25.6,"Pizza Double Fromage The fun thing about this pizza is the choice of ingredients, each representing a season of the year, of which they are their own."));
            list.add(new FoodDomain("Pizza Dinde",R.drawable.pizza3,30.8,"Pizza Dind The fun thing about this pizza is the choice of ingredients, each representing a season of the year, of which they are their own."));
            list.add(new FoodDomain("Fruit De Mer",R.drawable.pizza4,26.8,"PIZZA Fruit de mer The fun thing about this pizza is the choice of ingredients, each representing a season of the year, of which they are their own."));

        }
        else if(type.equals("Burger")){
            list.add(new FoodDomain("Triple Hamburger",R.drawable.burger1,21.0,"Bread Cut the bread in half and brown the inside in a pan Sauce Mix the Hellmann's mayonnaise with the paprika and chili paste Stuffing Coarsely chop the beef with a knife"));
            list.add(new FoodDomain("Burger Beef",R.drawable.burger2,25.6,"Bread Beef Cut the bread in half and brown the inside in a pan Sauce Mix the Hellmann's mayonnaise with the paprika and chili paste Stuffing Coarsely chop the beef with a knife"));
            list.add(new FoodDomain("Black Burger",R.drawable.burger3,30.8,"Black Bread Cut the bread in half and brown the inside in a pan Sauce Mix the Hellmann's mayonnaise with the paprika and chili paste Stuffing Coarsely chop the beef with a knife"));
            list.add(new FoodDomain("Burger Polet",R.drawable.burger4,26.8,"Bread Polet Cut the bread in half and brown the inside in a pan Sauce Mix the Hellmann's mayonnaise with the paprika and chili paste Stuffing Coarsely chop the beef with a knife"));
        }
        else if(type.equals("Hotdog")){
            list.add(new FoodDomain("Classic Hot dog",R.drawable.hotdog1,21.0,"Classuc Hot dog Faites bouillir les saucisses une dizaine de minutes. Laisser au chaud. 2Dans une poêle, faites revenir les oignons émincés. Versez 4 cuillères à soupe de sucre blanc et deux de ketchup."));
            list.add(new FoodDomain("BLT Hot dog",R.drawable.hotdog2,25.6,"BLT Hot dog Faites bouillir les saucisses une dizaine de minutes. Laisser au chaud. 2Dans une poêle, faites revenir les oignons émincés. Versez 4 cuillères à soupe de sucre blanc et deux de ketchup."));
            list.add(new FoodDomain("Véjé Hot dog",R.drawable.hotdog3,30.8,"Véjé Hot Dog Faites bouillir les saucisses une dizaine de minutes. Laisser au chaud. 2Dans une poêle, faites revenir les oignons émincés. Versez 4 cuillères à soupe de sucre blanc et deux de ketchup."));
            list.add(new FoodDomain("Patagonia Hot dog",R.drawable.hotdog4,26.8,"Patagonia Faites bouillir les saucisses une dizaine de minutes. Laisser au chaud. 2Dans une poêle, faites revenir les oignons émincés. Versez 4 cuillères à soupe de sucre blanc et deux de ketchup."));
        }
        else if(type.equals("Drink")){
            list.add(new FoodDomain("Les Monades",R.drawable.drink1,21.0,"Les Monades : A drink or beverage is a Liquid intended for consumption. There are cold or hot drinks، carbonated."));
            list.add(new FoodDomain("Panaché",R.drawable.drink2,25.6,"Panaché: A drink or beverage is a Liquid intended for consumption. There are cold or hot drinks، carbonated."));
            list.add(new FoodDomain("Za3ze3",R.drawable.drink3,30.8,"Za3za3 : A drink or beverage is a Liquid intended for consumption. There are cold or hot drinks، carbonated."));
            list.add(new FoodDomain("Jus d'Orange",R.drawable.drink4,26.8,"jue d'orange : A drink or beverage is a Liquid intended for consumption. There are cold or hot drinks، carbonated."));
        }
        else if(type.equals("Donut")){
            list.add(new FoodDomain("Donut Sucré",R.drawable.donut1,21.0,"Donut Sucré literally dough nut, means sweet donut in North America."));
            list.add(new FoodDomain("Donut Chokolat",R.drawable.donut2,25.6,"Donut Chokolat, or donut, literally dough nut, means sweet donut in North America."));
            list.add(new FoodDomain("Black Donut",R.drawable.donut3,30.8,"Donut Black literally dough nut, means sweet donut in North America."));
        }

        adpt=new ProductsAdptor(list,this);
        recyclerViewCat.setAdapter(adpt);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this));

    }
}