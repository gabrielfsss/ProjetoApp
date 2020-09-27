package com.gabriel.projeto1parte.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.gabriel.projeto1parte.model.Cadastro;
import com.gabriel.projeto1parte.model.CadastroUsuario;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

public class CadastrarUsuarioBD extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String NOME = "CadastroUsuario.sqlite";
    private static final String CREATE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario VARCHAR( 20 ) NOT NULL, senha VARCHAR( 20 ));";
    protected SQLiteDatabase database;

    public CadastrarUsuarioBD(Context context) {
        super(context, NOME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }
        return database;
    }




    public class UsuarioDAO extends CadastrarProdBD {

        private final String TABLE = "usuario";

        public UsuarioDAO(Context context) {
            super(context);
        }

        public void insert(CadastroUsuario usuario) throws Exception {
            ContentValues values = new ContentValues();

            values.put("usuario", usuario.getNomeUsuario());
            values.put("senha", usuario.getSenhaUsuario());

            getDatabase().insert(TABLE, null, values);
        }

        public void update(CadastroUsuario usuario) throws Exception {
            ContentValues values = new ContentValues();

            values.put("usuario", usuario.getNomeUsuario());
            values.put("senha", usuario.getSenhaUsuario());

            getDatabase().update(TABLE, values, "id = ?", new String[] { "" + usuario.getId() });
        }

        public CadastroUsuario findById(Integer id) {

            String sql = "SELECT * FROM " + TABLE + " WHERE id = ?";
            String[] selectionArgs = new String[] { "" + id };
            Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
            cursor.moveToFirst();

            return montaUsuario(cursor);
        }

        /*public List&lt;Usuario&gt; findAll() throws Exception {
            List&lt;Usuario&gt; retorno = new ArrayList&lt;Usuario&gt;();
            String sql = "SELECT * FROM " + TABLE;
            Cursor cursor = getDatabase().rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                retorno.add(montaUsuario(cursor));
                cursor.moveToNext();
            }
            return retorno;
        }*/

        public CadastroUsuario montaUsuario(Cursor cursor) {
            if (cursor.getCount() == 0) {
                return null;
            }
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String usuario = cursor.getString(cursor.getColumnIndex("usuario"));
            String senha = cursor.getString(cursor.getColumnIndex("senha"));

            return new CadastroUsuario(id, usuario, senha);

        }

        public CadastroUsuario findByLogin(String usuario, String senha) {
            String sql = "SELECT * FROM " + TABLE + " WHERE usuario = ? AND senha = ?";
            String[] selectionArgs = new String[] { usuario, senha };
            Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
            cursor.moveToFirst();

            return montaUsuario(cursor);
        }

    }

}

