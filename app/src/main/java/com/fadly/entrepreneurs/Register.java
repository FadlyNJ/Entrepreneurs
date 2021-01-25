package com.fadly.entrepreneurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {
    private TextView login, terms, service, privacy, home;
    private TextInputLayout tilEmail, tilPassword, tilFirst, tilLast, tilNick;
    private TextInputEditText txtEmail, txtPassword, txtFirst, txtLast, txtNick;
    private String email, password, first, last, nick;
    private MaterialButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (MaterialButton) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateData();

            }
        });

        login = (TextView) findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Register.this, Login.class);
                startActivity(login);
                finish();

            }
        });

        home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Register.this, MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);

            }
        });

        terms = (TextView) findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "TERMS AND SERVICE :D", Toast.LENGTH_LONG).show();

            }
        });

        service = (TextView) findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "TERMS OF SERVICE :D", Toast.LENGTH_LONG).show();

            }
        });

        privacy = (TextView) findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "PRIVACY POLICY :D", Toast.LENGTH_LONG).show();
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

        //Initialization firstname variables
        tilFirst = (TextInputLayout) findViewById(R.id.tilFirst);
        txtFirst = (TextInputEditText) findViewById(R.id.txtFirst);
        first = txtFirst.getText().toString();

        //Initialization lastname variables
        tilLast = (TextInputLayout) findViewById(R.id.tilLast);
        txtLast = (TextInputEditText) findViewById(R.id.txtLast);
        last = txtLast.getText().toString();

        //Initialization nickname variables
        tilNick = (TextInputLayout) findViewById(R.id.tilNick);
        txtNick = (TextInputEditText) findViewById(R.id.txtNick);
        nick = txtNick.getText().toString();

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

        //Check firstname input, if empty will show error message
        if(first.isEmpty()){
            tilFirst.setError("Please input your firstname");
        }else{
            if (!first.isEmpty()){
                tilFirst.setError(null);
            }
        }

        //Check lastname input, if empty will show error message
        if(last.isEmpty()){
            tilLast.setError("Please input your lastname");
        }else{
            if (!last.isEmpty()){
                tilLast.setError(null);
            }
        }

        //Check nickname input, if empty will show error message
        if(nick.isEmpty()){
            tilNick.setError("Please input your nickname");
        }else{
            if (!nick.isEmpty()){
                tilNick.setError(null);
            }
        }

    }

    private void registerCheck(){

        Toast.makeText(Register.this, "PENDAFTARAN BERHASIL :D", Toast.LENGTH_LONG).show();
        Intent register = new Intent(Register.this, MainActivity.class);
        register.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(register);

    }

}