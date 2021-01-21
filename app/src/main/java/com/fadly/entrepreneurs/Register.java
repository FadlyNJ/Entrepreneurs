package com.fadly.entrepreneurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {
    private TextView login, terms, service, privacy;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "PENDAFTARAN BERHASIL :D", Toast.LENGTH_LONG).show();
                Intent register = new Intent(Register.this, MainActivity.class);
                startActivity(register);

            }
        });

        login = (TextView) findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Register.this, Login.class);
                startActivity(login);

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
}