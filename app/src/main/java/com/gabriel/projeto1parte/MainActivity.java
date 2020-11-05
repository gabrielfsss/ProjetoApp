package com.gabriel.projeto1parte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gabriel.projeto1parte.BDHelper.CadastrarProdBD;
import com.gabriel.projeto1parte.BDHelper.CadastrarUsuarioBD;
import com.gabriel.projeto1parte.model.CadastroUsuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  Button entrar = (Button) findViewById(R.id.entrar);
       // entrar.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
          //      TextView nomeUsuario = findViewById(R.id.nomeUsuario);
              //  TextView SENHA = findViewById(R.id.SENHA);
              //  if (!nomeUsuario.getText().toString().trim().isEmpty() && !SENHA.getText().toString().trim().isEmpty()) {
              //      FirebaseAuth.getInstance().signInWithEmailAndPassword(nomeUsuario.getText().toString().trim(), SENHA.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              ////          @Override
               //         public void onComplete(@NonNull Task<AuthResult> task) {
                           // if (task.isSuccessful()){
                                Intent ProxTela = new Intent(MainActivity.this,telainicialprojeto.class);
                                startActivity(ProxTela);
                                finish();
                            //}
                       // }
                    //});
                ///}
           // }
        //});
    }

    public void Entrar (View v){

        Intent intent = new Intent(getApplicationContext(), telainicialprojeto.class);
        startActivity(intent);
    }
    public void cadastrar(View view){
        startActivity(new Intent(this, TelaCadastrarUsuario.class));
    }
}
