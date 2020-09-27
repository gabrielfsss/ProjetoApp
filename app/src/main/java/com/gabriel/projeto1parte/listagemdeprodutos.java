package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gabriel.projeto1parte.BDHelper.CadastrarProdBD;
import com.gabriel.projeto1parte.model.Cadastro;

import java.util.ArrayList;

public class listagemdeprodutos extends AppCompatActivity {

    ListView lista;
    CadastrarProdBD bdhelper;
    ArrayList<Cadastro> listview;
    Cadastro cadastro;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagemdeprodutos);

        lista = (ListView)findViewById(R.id.listviewProdutos);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Cadastro cadastros = (Cadastro) adapter.getItemAtPosition(position);

                Intent intent = new Intent(listagemdeprodutos.this, telacadastro.class);
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

                bdhelper = new CadastrarProdBD(listagemdeprodutos.this);
                bdhelper.deletarCadastro(cadastro);
                bdhelper.close();

                carregarProduto();
                return true;
            }
        });
    }

    protected void onResume(){

        super.onResume();
        carregarProduto();
    }

    public void carregarProduto(){

        bdhelper = new CadastrarProdBD(listagemdeprodutos.this);
        listview = bdhelper.getLista();
        bdhelper.close();

        if(listview!=null){

            adapter = new ArrayAdapter<Cadastro>(listagemdeprodutos.this, android.R.layout.simple_list_item_1, listview);
            lista.setAdapter(adapter);
        }
    }
}
