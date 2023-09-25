package com.example.food2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class introActivity extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    ImageView textLogo;
    TextView food,textStart;
    ConstraintLayout startBtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(getIntent().getBooleanExtra("Exit",false)){
            finish();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_main);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        textLogo=findViewById(R.id.imageView5);
        textLogo.setAnimation(topAnim);
        food=findViewById(R.id.textView2);
        food.setAnimation(bottomAnim);

        textStart=findViewById(R.id.textView7);
        textStart.setAnimation(bottomAnim);



        startBtns=findViewById(R.id.startBtn);
        startBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(introActivity.this, LoginActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(introActivity.this).toBundle();
                startActivity(i,b);
            }
        });
    }
}