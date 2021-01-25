package com.fadly.entrepreneurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    private MaterialButton login;
    private TextView create, forgot, home;
    private CheckBox remember;
    private TextInputLayout tilEmail, tilPassword;
    private TextInputEditText txtEmail, txtPassword;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (MaterialButton) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateData();
                //loginCheck();

            }
        });

        create = (TextView) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                startActivity(register);
                finish();

            }
        });

        forgot = (TextView) findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot = new Intent(Login.this, Register.class);
                startActivity(forgot);
                finish();

            }
        });

        home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Login.this, MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);

            }
        });

    }

    private void validateData(){

        //Initialization Email variables
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        email = txtEmail.getText().toString();

        //Initialization Password variables
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        txtPassword = (TextInputEditText) findViewById(R.id.txtPassword);
        password = txtPassword.getText().toString();

        //Check email input, if empty will show error message
        if(email.isEmpty()){
            tilEmail.setError("Please input your email address");
        }else{
            if (!email.isEmpty()){
                tilEmail.setError(null);
            }
        }

        //Check password input, if empty will show error message
        if(password.isEmpty()){
            tilPassword.setError("Please input your password");
        }else{
            if (!password.isEmpty()){
                tilPassword.setError(null);
            }
        }

    }

    private void loginCheck(){

        txtPassword = (TextInputEditText) findViewById(R.id.txtPassword);
        password = txtPassword.getText().toString();
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        email = txtEmail.getText().toString();

        if(email.equals("fadly")
                &&password.equals("fadly")){

            Toast.makeText(Login.this, "LOGIN BERHASIL :D", Toast.LENGTH_LONG).show();
            Intent login = new Intent(Login.this, MainActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);

        }
        else{
            tilEmail.setError("Wrong Password / Username");
            tilPassword.setError("Wrong Password / Username");
        }

    }

}