package com.example.janetaa.courseselectionapp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.janetaa.courseselectionapp.MainClassList;
import com.example.janetaa.courseselectionapp.R;

public class MainActivity extends AppCompatActivity {
    public enum LoginSuccess {
        login(1),
        password(2),
        success(0);

        private int intValue;

        LoginSuccess(int value) {
            intValue = value;
        }

        public int getIntValue() {
            return intValue;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblLogin = (TextView) findViewById(R.id.lblLogin);
        final TextView lblPassword = (TextView) findViewById(R.id.lblPassword);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
               Toast toastError = null;
               LoginSuccess isOK = null;

               switch (CheckLogin(txtUsername.getText().toString(),txtPassword.getText().toString())){
                   case login:
                       toastError.makeText(getApplicationContext(), getString(R.string.errMessageLogin),toastError.LENGTH_SHORT).show();
                       txtUsername.requestFocus();
                       break;
                   case password:
                       toastError.makeText(getApplicationContext(),getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show();
                       txtPassword.requestFocus();
                       break;
                   default:
                       startActivity(new Intent(MainActivity.this, MainClassList.class));
                       break;

               }
           }
        });
    }
    LoginSuccess CheckLogin(String txtUsername, String txtPassword){
        String holdLogin = "janet";
        String holdPass = "password";

        if(!(holdLogin.equals(txtUsername))){
            return LoginSuccess.login;
        }
        if (!(holdPass.equals(txtPassword))){
            return LoginSuccess.password;
        }
        return LoginSuccess.success;
    }


}
