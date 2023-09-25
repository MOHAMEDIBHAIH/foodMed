package com.example.food2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.github.muddz.styleabletoast.StyleableToast;

public class SupportActivity extends AppCompatActivity {
    ImageView imageView;
    Animation topAnimation,bottomAnim;
    TextView send ,coment1;
    LinearLayout comentVisible;
    EditText txtComent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imageView=findViewById(R.id.imageView9);
        imageView.setAnimation(topAnimation);

        txtComent=findViewById(R.id.txtComent);
        coment1=findViewById(R.id.coment1);
        comentVisible=findViewById(R.id.comentVisible);
        send=findViewById(R.id.sendBtn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtComent.getText().toString().length()>0){
                    comentVisible.setVisibility(View.VISIBLE);
                    coment1.setText(txtComent.getText());
                }
                else{
                    StyleableToast.makeText(SupportActivity.this, "Please fill in the comment!", Toast.LENGTH_LONG, R.style.exampleToastEreur).show();
                }

            }
        });
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout Profile = findViewById(R.id.profileBtn);
        LinearLayout Sittings = findViewById(R.id.settingsBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(SupportActivity.this, MainActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SupportActivity.this).toBundle();
                startActivity(o,b);
            }
        });

        Sittings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, SettingsActivity.class));
            }
        });
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(SupportActivity.this, ProfileActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SupportActivity.this).toBundle();
                startActivity(o,b);
            }
        });


    }
}