package com.example.labs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signUp;
    private EditText email;
    private EditText password;
    private EditText name;
    private Button submit;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        signUp = findViewById(R.id.signuptext1);
        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        name = findViewById(R.id.name1);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == submit){
            create_user(email.getText().toString(), password.getText().toString());
        }
    }
    public void create_user(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            User user = new User(name.getText().toString(), email.toString(), password.toString());
                            String uid = mAuth.getCurrentUser().getUid().toString();
                            database.getReference("users").child(uid).setValue(user);
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
}