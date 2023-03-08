package com.example.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView signUp;
    private EditText email;
    private EditText password;
    private EditText name;
    private Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}