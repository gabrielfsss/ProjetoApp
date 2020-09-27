package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gabriel.projeto1parte.BDHelper.CadastrarProdBD;
import com.gabriel.projeto1parte.BDHelper.CadastrarUsuarioBD;
import com.gabriel.projeto1parte.model.CadastroUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button entrar = (Button) findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProxTela = new Intent(MainActivity.this,telainicialprojeto.class);
                startActivity(ProxTela);
            }
        });*/
    }

    public void Entrar (View v){

        Intent intent = new Intent(getApplicationContext(), telainicialprojeto.class);
        startActivity(intent);
    }
}
