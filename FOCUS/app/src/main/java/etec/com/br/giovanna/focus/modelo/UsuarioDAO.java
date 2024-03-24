package etec.com.br.giovanna.focus.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private bdConexao con;
    private SQLiteDatabase bd;

    public UsuarioDAO(Context context){
        con = new bdConexao(context);
        bd= con.getWritableDatabase();
    }
    public long InserirUsu(usuario u){
        ContentValues contentValues = new ContentValues();

        contentValues.put("nomeUsu", u.getNomeUsu());
        contentValues.put("comorbidade", u.getComorbidade());
        contentValues.put("idResp", u.getIdRespon());

        return bd.insert("usuario",null, contentValues);
    }


}
