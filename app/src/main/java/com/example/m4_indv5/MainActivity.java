package com.example.m4_indv5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, MainProfile.class);

        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.img);
        TextInputLayout nom = findViewById(R.id.nom);
        TextInputEditText userNom = findViewById(R.id.userNom);
        TextInputLayout ap = findViewById(R.id.ap);
        TextInputEditText userAp = findViewById(R.id.userAp);
        TextInputLayout mail = findViewById(R.id.mail);
        TextInputEditText userMail = findViewById(R.id.userMail);
        TextInputLayout psw = findViewById(R.id.psw);
        TextInputEditText userPsw = findViewById(R.id.userPsw);
        Button submit = findViewById(R.id.submit);
        Button exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombre = userNom.getText().toString().trim();
               String apellido = userAp.getText().toString().trim();
               String email= userMail.getText().toString().toString();
               String pass = userPsw.getText().toString().trim();
               boolean validaOk = true;//Bandera para saber que todas las validaciones estan bien

               //Esto nos ayuda a validar que la variable tenga numeros, simbolos y letras ademas
                //de 8 caracteres como minimo
               String pwdPat = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";


                /* **************************
                 *   validaciones **********
                 ***************************/


                if (TextUtils .isEmpty(nombre)){
                    nom.setError("Debe ingresar un nombre");
                    validaOk=false;
                    Toast.makeText(MainActivity.this,"Debe ingresar su nombre", Toast.LENGTH_LONG).show();

                }

                if (TextUtils.isEmpty(apellido)){
                    ap.setError("Debe ingresar un apellido");
                    validaOk=false;
                    Toast.makeText(MainActivity.this,"Debe ingresar su apellido", Toast.LENGTH_LONG).show();

                }

               if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mail.setError("Ingrese un correo válido");
                    validaOk=false;
                   Toast.makeText(MainActivity.this,"Debe ingresar un e-mail valido", Toast.LENGTH_LONG).show();

               }

                if (!pass.matches(pwdPat)){
                    psw.setError("La contraseña debe tener al menos 8 caracteres y contener letras y números");
                    validaOk=false;
                    Toast.makeText(MainActivity.this,"su password debe tener letras, numeros y 8 caracteres", Toast.LENGTH_LONG).show();

                }

                if (validaOk){
                    Toast.makeText(MainActivity.this,"Usuario Agregado con éxito", Toast.LENGTH_LONG).show();
                    /* *************************
                     *   traspasar info ********
                     ***************************/

                    intent.putExtra("nom", nombre.toUpperCase());
                    intent.putExtra("ape",apellido.toUpperCase());
                    intent.putExtra("correo",email);
                    intent.putExtra("password",pass);
                    startActivity(intent);

                }
            }


        });
    }
}