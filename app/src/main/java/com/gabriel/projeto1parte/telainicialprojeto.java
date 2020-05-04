package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.gabriel.projeto1parte.BDHelper.CadastrarProdBD;
import com.gabriel.projeto1parte.model.Cadastro;

import java.util.ArrayList;

public class telainicialprojeto extends AppCompatActivity {

    ListView lista;
    CadastrarProdBD bdhelper;
    ArrayList<Cadastro> listview;
    Cadastro cadastro;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicialprojeto);

        lista = (ListView)findViewById(R.id.listview);


        Button CadastroProd = (Button) findViewById(R.id.CadastroProd);
        CadastroProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProxTela = new Intent(telainicialprojeto.this,telacadastro.class);
                startActivity(ProxTela);
            }
        });
    }

    public void irTelaCadastro (View v){

        Intent intent = new Intent(getApplicationContext(), telacadastro.class);
        startActivity(intent);
    }

    protected void onResume(){

        super.onResume();
        carregarProduto();
    }

    public void carregarProduto(){

        bdhelper = new CadastrarProdBD(telainicialprojeto.this);
        listview = bdhelper.getLista();
        bdhelper.close();

        if(listview!=null){

            adapter = new ArrayAdapter<Cadastro>(telainicialprojeto.this, android.R.layout.simple_list_item_1, listview);
            lista.setAdapter(adapter);
        }

        //finish();
    }
}
