package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.bdConexao;

public class telaLogin extends AppCompatActivity {

    EditText edEmailLogin, edSenhaLogin;
    Button btLogin, btCadastrarLogin;
    String email, senha, nomeRes, nomeUsu;
    int idLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btLogin= findViewById(R.id.btnLogin);
        btCadastrarLogin= findViewById(R.id.btnCadastrarLogin);
        edEmailLogin = findViewById(R.id.edtEmailLogin);
        edSenhaLogin = findViewById(R.id.edtSenhaLogin);


        btCadastrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AbrirCadastro = new Intent(telaLogin.this, MainActivity.class);
                startActivity(AbrirCadastro);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senha = edSenhaLogin.getText().toString();
                email = edEmailLogin.getText().toString();

                bdConexao con = new bdConexao(telaLogin.this);
                SQLiteDatabase bd = con.getReadableDatabase();

                Cursor cursor = bd.rawQuery("select * from responsavel where email=? and senha=?", new String[]{email, senha});
                if (cursor.getCount() > 0) {
                    Intent abrirprincipal = new Intent(telaLogin.this, Telaprincipal.class);

                    // recuperando o id usuario
                    Intent telanum = getIntent();
                    Bundle nomel = telanum.getExtras();
                    idLog = nomel.getInt("idUsu");
                    nomeRes= nomel.getString("nomeRespon");
                    nomeUsu= nomel.getString("nomeUsu");


                    abrirprincipal.putExtra("idUsu", idLog);
                    abrirprincipal.putExtra("nomeRespon", nomeRes);
                    abrirprincipal.putExtra("nomeUsu", nomeUsu);

                    startActivity(abrirprincipal);
                    Toast.makeText(telaLogin.this, "Você está logado", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(telaLogin.this, "Login falhou, tente novamente", Toast.LENGTH_LONG).show();
                }



            }

        });

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar os botões do aplicativo", Toast.LENGTH_SHORT).show();
    }
}