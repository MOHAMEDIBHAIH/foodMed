package com.example.food2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.food2.Helper.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.github.muddz.styleabletoast.StyleableToast;

public class SingUpActivity extends AppCompatActivity  implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private ConstraintLayout signBtn;
    private EditText FullName, Phone, Age, Email, Password, C_password;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase fire =FirebaseDatabase.getInstance();
        signBtn = (ConstraintLayout) findViewById(R.id.startBtn);
        signBtn.setOnClickListener(this);


        DatabaseReference ref;
        ref = fire.getReference("https://foodmed-abbad-default-rtdb.firebaseio.com/");
        User user = new User("fullName", "065525147", "22", "email", "password", "c_password");
        ref.child("zeb").setValue(user);

        FullName = (EditText) findViewById(R.id.TxtFullName);
        Phone = (EditText) findViewById(R.id.TxtPhone);
        Age = (EditText) findViewById(R.id.TxtAge);
        Email = (EditText) findViewById(R.id.TxtEmail);
        Password = (EditText) findViewById(R.id.TxtPassword);
        C_password = (EditText) findViewById(R.id.TxtConfirmPassword);
    }

    @Override
    public void onClick(View view) {
        start();

    }

    private void start() {
        String email = Email.getText().toString().trim();
        String fullName = FullName.getText().toString().trim();
        String phone = Phone.getText().toString().trim();
        String age = Age.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String c_password = C_password.getText().toString().trim();
        if (fullName.isEmpty()) {

            FullName.setError("First Name is required");
            FullName.requestFocus();
            return;
        }
        if (phone.isEmpty()) {

            Phone.setError("Phone is required");
            Phone.requestFocus();
            return;
        }
        if (age.isEmpty()) {

            Age.setError("Age is required");
            Age.requestFocus();
            return;
        }
        if (age.length() > 2) {
            Age.setError("Age length should be 2 numbers !");
            Age.requestFocus();
            return;
        }


        if (email.isEmpty()) {

            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please proved Valid Email");
            Email.requestFocus();
            return;

        }

        if (password.isEmpty()) {

            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }
        if (password.length() < 6) {
            Password.setError("Min Password length should be 6 characters !");
            Password.requestFocus();
            return;
        }
        if (c_password.isEmpty()) {

            C_password.setError("Confirmed your Password Please");
            C_password.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(fullName, phone, age, email, password, c_password);
                            DatabaseReference ref;
                            ref = FirebaseDatabase.getInstance().getReference("Users");
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            ref.child(currentUser.getUid()).setValue(user);

                                                StyleableToast.makeText(SingUpActivity.this, "User has been Registered successfully", Toast.LENGTH_LONG, R.style.exampleToastSuccessfully).show();
                                                startActivity(new Intent(SingUpActivity.this, LoginActivity.class));
                        } else {
                            StyleableToast.makeText(SingUpActivity.this, "Failed to Registered!", Toast.LENGTH_LONG, R.style.exampleToastEreur).show();
                        }
                    }
                });
    }



}