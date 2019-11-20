package com.brains404.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
 EditText password ;
 EditText email ;
 String userPassword ;
 String userEmail ;
 Button connect ;
 final String USER_PASSWORD="USER_PASSWORD";
 final String USER_EMAIL="USER_EMAIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=findViewById(R.id.user_password);
        email=findViewById(R.id.user_email);
        connect=findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            userPassword=password.getText().toString();
            userEmail=email.getText().toString();
            if(!userEmail.isEmpty() && !userPassword.isEmpty()) {
                Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");

                Matcher matcher = pattern.matcher(userEmail);
                boolean isValidEmail = matcher.matches();
                if(isValidEmail && userPassword.length()>=8) {
                    Intent intent = new Intent(MainActivity.this, LoginDisplay.class);
                    intent.putExtra(USER_PASSWORD, userPassword);
                    intent.putExtra(USER_EMAIL, userEmail);
                    startActivity(intent);
                }
                    else if(userPassword.length()<8){
                        Toast.makeText(MainActivity.this,"Weak Password",Toast.LENGTH_SHORT).show();
                    }
                else {
                    Toast.makeText(MainActivity.this,"Wrong Email",Toast.LENGTH_SHORT).show();
                }

            }else{
                if(userPassword.isEmpty() && !userEmail.isEmpty()){
                    Toast.makeText(MainActivity.this,"Password Required",Toast.LENGTH_SHORT).show();
                }else if (email.getText().toString().isEmpty() && !userPassword.isEmpty()){
                    Toast.makeText(MainActivity.this,"Email Required",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Email/Password Required",Toast.LENGTH_SHORT).show();
                }

            }
            }
        });
    }
}
