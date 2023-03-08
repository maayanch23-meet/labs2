package com.example.labs;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private EditText email;
    private EditText password;
    private Button signin;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.signintext);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signinbutton);
        signup = findViewById(R.id.signupbutton);
        signin.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == signin){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if(view == signup){
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}