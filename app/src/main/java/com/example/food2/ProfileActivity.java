package com.example.food2;

import androidx.annotation.NonNull;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food2.Helper.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private TextView FullName,TxtFirstName1;
    private EditText emailTxt,phoneTxt,passwordTxt,ageTxt;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private FirebaseAuth authProfile;
    private static final String USERS="Users";
    private  String email,password,fullName,phone,age;
    ProgressBar progressBar;

    TextView textViewUp;
    ImageView imageView,imageView2;
    Animation topAnimation,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        textViewUp=findViewById(R.id.textView7);
        textViewUp.setAnimation(bottomAnim);
        imageView=findViewById(R.id.imageView9);
        imageView2=findViewById(R.id.imageView13);
        imageView.setAnimation(topAnimation);


        FullName=findViewById(R.id.TxtFirstName1);
        emailTxt=findViewById(R.id.TxtEmail1);
        phoneTxt=findViewById(R.id.TxtPhone1);
        passwordTxt=findViewById(R.id.TxtPassword1);
        ageTxt=findViewById(R.id.TxtAge1);
        TxtFirstName1=findViewById(R.id.TxtFirstName1);
        progressBar=findViewById(R.id.progressBar2);

        database=FirebaseDatabase.getInstance();
        userRef=database.getReference(USERS);

        authProfile=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=authProfile.getCurrentUser();

        bottomNavigation();

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageIntent=new Intent(Intent.ACTION_PICK);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent,101);
            }
        });


        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users").child(authProfile.getUid());
        /*ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User us=null;
                for(DataSnapshot item:snapshot.getChildren()){
                 us =item.getValue(User.class);

                }
                emailTxt.setText(us.getEmail());
            }*/
        ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                   String str=task.getResult().child("email").getValue().toString();
                    String age=task.getResult().child("age").getValue().toString();
                    String phone=task.getResult().child("phone").getValue().toString();
                    String pass=task.getResult().child("password").getValue().toString();
                    String fullname=task.getResult().child("fullName").getValue().toString();
                   emailTxt.setText(str);
                   phoneTxt.setText(phone);
                   ageTxt.setText(age);
                   passwordTxt.setText(pass);
                   TxtFirstName1.setText(fullname);
                   progressBar.setVisibility(View.GONE);
            }
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
        LinearLayout Sittings = findViewById(R.id.settingsBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(ProfileActivity.this, MainActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(ProfileActivity.this).toBundle();
                startActivity(o,b);
            }
        });
        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, SupportActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(ProfileActivity.this).toBundle();
                startActivity(i,b);

            }
        });
        Sittings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
            }
        });
    }
}