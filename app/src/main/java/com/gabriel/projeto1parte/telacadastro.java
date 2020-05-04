package com.gabriel.projeto1parte;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import com.gabriel.projeto1parte.BDHelper.CadastrarProdBD;
import com.gabriel.projeto1parte.model.Cadastro;

public class telacadastro extends AppCompatActivity {

    EditText editnome, editquantestoq, editprecounid, editlocalprod;
    Button btnpolimorf;
    Cadastro editarCadastro, cadastro;
    CadastrarProdBD bdhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacadastro); //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

        cadastro = new Cadastro();
        bdhelper = new CadastrarProdBD(telacadastro.this);

        Intent intent = getIntent();
        editarCadastro = (Cadastro) intent.getSerializableExtra("produto_escolhido"); //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

        editnome = (EditText) findViewById(R.id.editnome);
        editquantestoq = (EditText) findViewById(R.id.editquantestoq);
        editprecounid = (EditText) findViewById(R.id.editprecounid);
        editlocalprod = (EditText) findViewById(R.id.editlocalprod);

        btnpolimorf = (Button) findViewById(R.id.btnpolimorf);

        if(editarCadastro != null){

            btnpolimorf.setText("Modificar");

            editnome.setText(editarCadastro.getNomeprod());
            editquantestoq.setText(editarCadastro.getQuantestoq()+"");
            editprecounid.setText(editarCadastro.getPrecoprod()+"");
            editlocalprod.setText(editarCadastro.getLocal());

            cadastro.setId(editarCadastro.getId());

        }else{
            btnpolimorf.setText("Cadastrar");
        }

        btnpolimorf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cadastro.setNomeprod(editnome.getText().toString());
                cadastro.setQuantestoq(Integer.parseInt(editquantestoq.getText().toString()));
                cadastro.setPrecoprod(Integer.parseInt(editprecounid.getText().toString()));
                cadastro.setLocal(editlocalprod.getText().toString());

                if(btnpolimorf.getText().toString().equals("Cadastrar")){

                    bdhelper.salvarProdutosCad(cadastro);
                    bdhelper.close();
                }else if(btnpolimorf.getText().toString().equals("Modificar")){

                    bdhelper.alterarCadastro(cadastro);
                    bdhelper.close();
                }
            }
        });

    }
}
