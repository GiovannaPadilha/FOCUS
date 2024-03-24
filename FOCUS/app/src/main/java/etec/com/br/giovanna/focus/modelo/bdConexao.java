package etec.com.br.giovanna.focus.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class bdConexao extends SQLiteOpenHelper {
    private static final String nome = "bdFocus.db";
    private static final int versao = 1;

    public bdConexao(@Nullable Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE responsavel (id integer primary key autoincrement,nome varchar(80), " +
                "dataNasc date, email string, senha string)");

        sqLiteDatabase.execSQL("CREATE TABLE usuario (id_Usu integer primary key autoincrement,nomeUsu varchar(80), " +
                "comorbidade String, idResp int, CONSTRAINT fk_respon FOREIGN KEY (idResp) REFERENCES responsavel(id))");


        sqLiteDatabase.execSQL("CREATE TABLE pontuacao (id_pont integer primary key autoincrement, idUsuario integer, nomeTarefa String, pontuacao int, " +
                "CONSTRAINT fk_idUsu FOREIGN KEY (idUsuario) REFERENCES usuario(id_Usu))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }
}
