package com.example.coffeeonwheels.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeonwheels.Helper.DBHelper;
import com.example.coffeeonwheels.R;

public class loginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    TextView redirectToSignup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.loginBtn);
        redirectToSignup = (TextView) findViewById(R.id.signupBtn);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(loginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(loginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(loginActivity.this, MainActivity.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        redirectToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, signupActivity.class));
            }
        });
    }
}