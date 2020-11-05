package com.gabriel.projeto1parte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gabriel.projeto1parte.usuario.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class TelaCadastrarUsuario extends AppCompatActivity {

    private EditText txtNome, txtEmail, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_usuario);

        txtNome= findViewById(R.id.txtNome);
        txtEmail= findViewById(R.id.txtEmail);
        txtSenha= findViewById(R.id.txtSenha);
    }

    public void cadastrar(View view){
        final String nome = txtNome.getText().toString().trim();
        final String email = txtEmail.getText().toString().trim();
        final String senha = txtSenha.getText().toString().trim();

        if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()){
            Log.d("TESTE", "ENTROU");
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(nome, senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Usuario usuario = new Usuario();
                                usuario.setId(task.getResult().getUser().getUid());
                                usuario.setNome(nome);
                                usuario.setEmail(email);
                                usuario.setSenha(senha);
                                FirebaseFirestore.getInstance().collection("usuario")
                                        .document(usuario.getId())
                                        .set(usuario)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(getApplicationContext(), "Realize seu Login!", Toast.LENGTH_LONG).show();
                                                finish();
                                            }
                                        });
                            }else Toast.makeText(getApplicationContext(), "Deu erro", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }
}