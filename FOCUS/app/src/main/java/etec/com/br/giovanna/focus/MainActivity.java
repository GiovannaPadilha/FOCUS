package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.respDao;

public class MainActivity extends AppCompatActivity {
Button btJaCadas, btProximo;
EditText edNome, edDataNasc, edEmail, edSenha;
   String nomee,senha, email, datanasc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btJaCadas = findViewById(R.id.btnjaCadas);
        btProximo = findViewById(R.id.btnProx);
        edNome = findViewById(R.id.edtNome);
        edDataNasc = findViewById(R.id.edtDataNasc);
        edEmail = findViewById(R.id.edtEmail);
        edSenha = findViewById(R.id.edtSenha);



        btJaCadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AbrirLogin = new Intent(MainActivity.this, telaLogin.class);
                startActivity(AbrirLogin);
            }
        });


    }
    public void mInserir(View V){

            nomee = edNome.getText().toString();
            senha = edSenha.getText().toString();
            email = edEmail.getText().toString();
            datanasc = edDataNasc.getText().toString();

       Responsavel r = new Responsavel(nomee,datanasc,email,senha);
       respDao respdao = new respDao(this);
       long id = respdao.inserir(r);
       String idR = Long.toString(id);
        int idRespon = Integer.parseInt(idR);



            if (nomee.isEmpty() && senha.isEmpty() && email.isEmpty() && datanasc.isEmpty()) {
                edSenha.setError("Digite a senha");
                edNome.setError("Digite o nome");
                edEmail.setError("Digite seu email");
                edDataNasc.setError("Digite uma data de nascimento");
            } else if (email.contains("@")) {
                Intent AbrirCadasUsuario = new Intent(MainActivity.this, CadastroUsuario.class);
                //pegando id do responsavel e enviando pro usuario
                AbrirCadasUsuario.putExtra("nomeResp", nomee);
                AbrirCadasUsuario.putExtra("idResp", idRespon);

                startActivity(AbrirCadasUsuario);
            }
            else {
                edEmail.setError("Digite um email válido");

            }
        }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar os botões do aplicativo", Toast.LENGTH_SHORT).show();
    }
    }



