package com.brains404.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginDisplay extends AppCompatActivity {
TextView email ;
TextView password ;
String userEmail ;
String userPassword;
    final String USER_PASSWORD="USER_PASSWORD";
    final String USER_EMAIL="USER_EMAIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);
        email = findViewById(R.id.email_display);
        password= findViewById(R.id.password_display);
      userEmail= getIntent().getStringExtra(USER_EMAIL);
        userPassword= getIntent().getStringExtra(USER_PASSWORD);
        email.setText(userEmail);
        password.setText(userPassword);
    }
}
