package etec.com.br.giovanna.focus.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.bdConexao;

public class respDao {
    private bdConexao con;
    private SQLiteDatabase bd;

    public respDao(Context context){
        con = new bdConexao(context);
        bd = con.getWritableDatabase();
    }
public long inserir(Responsavel res){

    ContentValues contentValues =new  ContentValues();


    contentValues.put("nome", res.getNome());
    contentValues.put("dataNasc", res.getDatanasc());
    contentValues.put("email", res.getEmail());
    contentValues.put("senha", res.getSenha());

    return bd.insert("responsavel", null, contentValues);
}
 /*public List<Responsavel> listar(){
        List<Responsavel> listR = new ArrayList<Responsavel>();

        Cursor cursor= bd.rawQuery("Select * from responsavel", null);

        while(cursor.moveToNext()){
            listR.add(new Responsavel(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));


        }
        return listR;
 }*/
}
