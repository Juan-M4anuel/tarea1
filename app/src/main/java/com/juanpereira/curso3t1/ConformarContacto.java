package com.juanpereira.curso3t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConformarContacto extends AppCompatActivity {

    TextView tvnombre, tvfecha, tvtelefono, tvemail, tvdescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conformar_contacto);

        tvnombre = (TextView)findViewById(R.id.tvNombre);
        tvfecha = (TextView)findViewById(R.id.tvFecha);
        tvtelefono = (TextView)findViewById(R.id.tvTelefono);
        tvemail = (TextView)findViewById(R.id.tvEmail);
        tvdescripcion = (TextView)findViewById(R.id.tvDesc);
        btnEditar = (Button)findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = tvnombre.getText().toString();
                String fec = tvfecha.getText().toString();
                String tel = tvtelefono.getText().toString();
                String em = tvemail.getText().toString();
                String desc = tvdescripcion.getText().toString();

                Intent intent = new Intent(ConformarContacto.this, MainActivity.class);
                intent.putExtra("nom", nom);
                intent.putExtra("fec", fec);
                intent.putExtra("tel", tel);
                intent.putExtra("em", em);
                intent.putExtra("desc", desc);

                startActivity(intent);
            }
        });

        confirmarDatos();
    }

    private void confirmarDatos() {
        Bundle datos = this.getIntent().getExtras();
        String nom = datos.getString("nom");
        String fec = datos.getString("fec");
        String tel = datos.getString("tel");
        String em = datos.getString("em");
        String desc = datos.getString("desc");

        tvnombre.setText(nom);
        tvfecha.setText(fec);
        tvtelefono.setText(tel);
        tvemail.setText(em);
        tvdescripcion.setText(desc);

    }
}