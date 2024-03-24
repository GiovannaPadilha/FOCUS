package etec.com.br.giovanna.focus.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class tarefaDAO {

    private bdConexao con;
    private SQLiteDatabase bd;

    public tarefaDAO(Context context) {
        con = new bdConexao(context);
        bd = con.getWritableDatabase();
    }

    public long InserirNome(tarefa t) {

        ContentValues contentValues = new ContentValues();


        contentValues.put("nometaf", t.getNometaf());

        return bd.insert("tarefa", null, contentValues);

    }
}
