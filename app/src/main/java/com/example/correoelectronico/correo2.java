package com.example.correoelectronico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class correo2 extends AppCompatActivity {
Button enviar,limpiar;
EditText asunto,mensaje,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo2);
        enviar=findViewById(R.id.btnenviar);
        asunto=findViewById(R.id.idasunto);
        mensaje=findViewById(R.id.idmensaje);
        correo=findViewById(R.id.idcorreo);
        limpiar=findViewById(R.id.btnlimpiar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (asunto.getText().toString().trim().equals("")||mensaje.getText().toString().trim().equals("")||correo.getText().toString().trim().equals(""))
                {
                    Toast.makeText(correo2.this,"Rellene todos lo campos necesarios",Toast.LENGTH_LONG).show();
                }
                else {
                    if (Patterns.EMAIL_ADDRESS.matcher(correo.getText().toString().trim()).matches()){
                        Intent intent=new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:"));
                        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{correo.getText().toString().trim()});
                        intent.putExtra(Intent.EXTRA_SUBJECT,asunto.getText().toString().trim());
                        intent.putExtra(Intent.EXTRA_TEXT,mensaje.getText().toString().trim());

                        startActivity(Intent.createChooser(intent,"Selecciona un correo...anashe"));
                    }
                 else {
                     Toast.makeText(correo2.this,"Diereccion invalida",Toast.LENGTH_LONG).show();
                    }
                }

                limpiar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        asunto.getText().clear();
                        mensaje.getText().clear();
                        correo.getText().clear();
                    }
                });
            }
        });

    }
}