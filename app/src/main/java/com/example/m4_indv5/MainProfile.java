package com.example.m4_indv5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        TextView txtNom = findViewById(R.id.txtNom);
        TextView txtAp = findViewById(R.id.txtAp);
        TextView txtMail = findViewById(R.id.txtMail);
        TextView txtPsw = findViewById(R.id.txtPsw);
        Button exit = findViewById(R.id.exit);

        Bundle extras = getIntent().getExtras();
        if (extras !=null){
            txtNom.setText("Nombre:" + extras.getString("nom"));
            txtAp.setText("Apellido:" + extras.getString("ape"));
            txtMail.setText("E-mail:" + extras.getString("correo"));
            txtPsw.setText("Password:" + extras.getString("password"));

        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}