package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telainicialprojeto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicialprojeto);

        /*Button button = (Button) findViewById(R.id.entrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProxTela2 = new Intent(telainicialprojeto.this,MainActivity.class);
                startActivity(ProxTela2);
            }
        });*/

        Button Cadastro = (Button) findViewById(R.id.CadastroProd);
        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProxTela = new Intent(telainicialprojeto.this,telacadastro.class);
                startActivity(ProxTela);
            }
        });

        Button Lista = (Button) findViewById(R.id.ListaProd);
        Lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProxTela = new Intent(telainicialprojeto.this,telacadastro.class);
                startActivity(ProxTela);
            }
        });
    }
}
