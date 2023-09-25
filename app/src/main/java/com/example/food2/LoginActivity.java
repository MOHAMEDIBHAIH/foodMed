package com.example.food2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.github.muddz.styleabletoast.StyleableToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private  EditText FullName,Email,Password;
    private ConstraintLayout StartBtn;
    private FirebaseAuth mAuth;
    Animation bottomAnim;
    TextView textStar;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       mAuth = FirebaseAuth.getInstance();

        StartBtn=(ConstraintLayout) findViewById(R.id.startBtn);
        StartBtn.setOnClickListener(this);

        FullName= findViewById(R.id.TxtName);
        Email=findViewById(R.id.TxtEmail);
        Password=findViewById(R.id.TxtPassword);


        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        textStar=findViewById(R.id.textView7);
        textStar.setAnimation(bottomAnim);
        progressBar=findViewById(R.id.progressBar);



    }

    @Override
    public void onBackPressed() {
    }

    public void Sign(View view) {
        startActivity(new Intent(this, SingUpActivity.class));
    }



    @Override
    public void onClick(View view) {
         userLogin();
    }

    private void userLogin() {



            String fullName=FullName.getText().toString().trim();
            String email=Email.getText().toString().trim();
            String password=Password.getText().toString().trim();
            Intent i = new Intent(LoginActivity.this,ProfileActivity.class);
            i.putExtra("email",email);



            if (fullName.isEmpty()){

                FullName.setError("Name is required");
                FullName.requestFocus();
                return;
            }

            if (email.isEmpty()){

                Email.setError("Email is required");
                Email.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Email.setError("Please proved Valid Email");
                Email.requestFocus();
                return;

            }

            if (password.isEmpty()){

                Password.setError("Password is required");
                Password.requestFocus();
                return;
            }
            if(password.length()<6){
                Password.setError("Min Password length should be 6 characters !");
                Password.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressBar.setVisibility(View.VISIBLE);
                        textStar.setText("Login ...");
                        StyleableToast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_LONG, R.style.exampleToastSuccessfully).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);

                    }
                    else
                    {
                        StyleableToast.makeText(LoginActivity.this, "Failed to Login! Please check your credentials !", Toast.LENGTH_LONG, R.style.exampleToastEreur).show();                        progressBar.setVisibility(View.GONE);
                    }
                }
            });



        }
}




