package etec.com.br.giovanna.focus.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class pontuacaoDAO {
    private bdConexao con;
    private SQLiteDatabase bd;

    public pontuacaoDAO(Context context) {
        con = new bdConexao(context);
        bd = con.getWritableDatabase();
    }
    public long contarPontuacao(pontuacao p){

        ContentValues contentValues =new  ContentValues();


        contentValues.put("idUsuario",p.getIdUsuario());
        contentValues.put("nomeTarefa", p.getNomeTarefa());
        contentValues.put("pontuacao", p.getPont());


        return bd.insert("pontuacao", null, contentValues);
    }
}
