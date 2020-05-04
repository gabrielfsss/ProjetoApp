package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Cadastro cadastros = (Cadastro) adapter.getItemAtPosition(position);

                Intent intent = new Intent(telainicialprojeto.this, telacadastro.class);
                intent.putExtra("produto_escolhido", cadastros);

                startActivity(intent);

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                cadastro = (Cadastro)adapter.getItemAtPosition(position);

                return false;
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem menuDelete = menu.add("excluir produto");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                bdhelper = new CadastrarProdBD(telainicialprojeto.this);
                bdhelper.deletarCadastro(cadastro);
                bdhelper.close();

                carregarProduto();
                return true;
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
    }
}
