package com.example.food2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {
    private TextView Logout;
    private Switch aSwitch;
    ImageView facebook,insta,Email,twitter;
    Animation topAnimation,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bottomNavigation();
        darkMode();


        aSwitch=findViewById(R.id.switch1);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        facebook=findViewById(R.id.facebookBtn);
        facebook.setAnimation(topAnimation);
        twitter=findViewById(R.id.twitterBtn);
        twitter.setAnimation(topAnimation);
        Email=findViewById(R.id.gmailBtn);
        Email.setAnimation(topAnimation);
        insta=findViewById(R.id.instagramBtn);
        insta.setAnimation(topAnimation);

        findViewById(R.id.facebookBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socialM("https://www.facebook.com/mohamed_abhih");
            }
        });
        findViewById(R.id.instagramBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socialM("https://www.instagram.com/01_sokry_01");
            }
        });
        findViewById(R.id.gmailBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socialM("https://myaccount.google.com/profile");
            }
        });
        findViewById(R.id.twitterBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socialM("https://twitter.com/abhih_mohamed");
            }
        });

    }
    public void socialM(String url){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void darkMode() {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }
        else{
            setTheme(R.style.Theme_Light);
        }
        Logout = findViewById(R.id.Sing_out);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout Support = findViewById(R.id.supportBtn);
        LinearLayout profile = findViewById(R.id.profileBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, CartListActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SettingsActivity.this).toBundle();
                startActivity(i,b);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(SettingsActivity.this, MainActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SettingsActivity.this).toBundle();
                startActivity(o,b);
            }
        });
        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, SupportActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SettingsActivity.this).toBundle();
                startActivity(i,b);

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, ProfileActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SettingsActivity.this).toBundle();
                startActivity(i,b);
            }
        });
    }

    public void exit(View view) {
        Intent in = new Intent(getApplicationContext(),introActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        in.putExtra("Exit",true);
        startActivity(in);
        finish();
        System.exit(0);
    }

    public void profile(View view) {
        startActivity(new Intent(SettingsActivity.this, ProfileActivity.class));
    }

    public void cart(View view) {
        startActivity(new Intent(SettingsActivity.this, CartListActivity.class));
    }

    public void info(View view) {
        startActivity(new Intent(SettingsActivity.this, info.class));
    }
}