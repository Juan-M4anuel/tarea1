package com.juanpereira.curso3t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, fecha, telefono, email, descripcion;
    Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = (EditText)findViewById(R.id.inNombre);
        fecha       = (EditText)findViewById(R.id.inFecha);
        telefono    = (EditText)findViewById(R.id.inTelofono);
        email       = (EditText)findViewById(R.id.inEmail);
        descripcion = (EditText)findViewById(R.id.inDescripcion);

        siguiente = (Button)findViewById((R.id.siguiente));



        siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nom = nombre.getText().toString();
                String fec = fecha.getText().toString();
                String tel = telefono.getText().toString();
                String em = email.getText().toString();
                String desc = descripcion.getText().toString();

                Intent i = new Intent(MainActivity.this, ConformarContacto.class);

                i.putExtra("nom", nom);
                i.putExtra("fec", fec);
                i.putExtra("tel", tel);
                i.putExtra("em", em);
                i.putExtra("desc", desc);

                startActivity(i);
            }
        });

        rellenardatos();


    }

    private void rellenardatos() {
        Bundle datos = this.getIntent().getExtras();
        if (datos != null){
            String nom = datos.getString("nom");
            String fec = datos.getString("fec");
            String tel = datos.getString("tel");
            String em = datos.getString("em");
            String desc = datos.getString("desc");

            nombre.setText(nom);
            fecha.setText(fec);
            telefono.setText(tel);
            email.setText(em);
            descripcion.setText(desc);
        }

    }
}