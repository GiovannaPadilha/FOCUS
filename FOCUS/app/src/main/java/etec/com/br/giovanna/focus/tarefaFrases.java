package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.pontuacao;
import etec.com.br.giovanna.focus.modelo.pontuacaoDAO;
import etec.com.br.giovanna.focus.modelo.respDao;

public class tarefaFrases extends AppCompatActivity {
Button btLimpar, btVoltar, btConferir;
EditText edAviao, edBanana, edCama, edDado;
    String nomeFrase,aviao, banana, cama, dado;;
    int idUsuRecebido, pontuacaof = 0, acessojogoF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_frases);

        btConferir=findViewById(R.id.btnConferir);
        btLimpar=findViewById(R.id.btnLimpar);
        btVoltar=findViewById(R.id.btnVoltarTF);
        edAviao=findViewById(R.id.edtAviao);
        edBanana=findViewById(R.id.edtBanana);
        edCama=findViewById(R.id.edtCama);
        edDado=findViewById(R.id.edtDado);

        //RECUPERANDO O NOME
        Intent telafrase = getIntent();
        Bundle nome = telafrase.getExtras();
        nomeFrase = nome.getString("nomeFrase");


        //recuperando id usuario
        Intent telanum = getIntent();
        Bundle nome1 = telanum.getExtras();
        idUsuRecebido = nome1.getInt("idUsu");


        btConferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // RECUPERANDO PONTUACAO
                aviao = edAviao.getText().toString();
                banana = edBanana.getText().toString();
                cama = edCama.getText().toString();
                dado = edDado.getText().toString();

                acessojogoF=1;

                //verificação das palavras
                if(aviao.contains("aviao") || aviao.contains( "Aviao") || aviao.contains( "avião") || aviao.contains("Avião")
                        || aviao.contains("AVIAO") || aviao.contains("AVIÃO")){

                    pontuacaof=+1;
                }
                if(banana.contains("banana") || banana.contains( "BANANA") || banana.contains( "Banana")){

                    pontuacaof=+1;
                }
                if(cama.contains("cama") || cama.contains( "CAMA") || cama.contains( "Cama")){

                    pontuacaof=+1;
                }
                if(dado.contains("dado") || dado.contains( "DADO") || dado.contains( "Dado")){

                    pontuacaof=+1;
                }

                if(aviao.isEmpty()){
                    edAviao.setError("preencha o nome");
                }
                if(banana.isEmpty()){
                    edBanana.setError("preencha o nome");
                }
                if(cama.isEmpty()){
                    edCama.setError("preencha o nome");
                }
                if(dado.isEmpty()){
                    edDado.setError("preencha o nome");
                }else{
                    AlertDialog.Builder alertavenceu = new AlertDialog.Builder(tarefaFrases.this);
                    alertavenceu.setTitle("Parabéns!!");
                    alertavenceu.setMessage("Você finalizou a tarefa: "+ nomeFrase);
                    alertavenceu.setIcon(android.R.drawable.star_big_on);
                    alertavenceu.setPositiveButton("OK", null);
                    alertavenceu.create();
                    alertavenceu.show();
                }




                //Instanciando as classes bd de pontuacao
                pontuacao p = new pontuacao(idUsuRecebido,nomeFrase,pontuacaof);
                pontuacaoDAO pontDAO = new pontuacaoDAO(tarefaFrases.this);
                long id = pontDAO.contarPontuacao(p);





            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltarTj = new Intent(tarefaFrases.this, telaJogosTarefas.class);
                voltarTj.putExtra("pontuF", pontuacaof);
                voltarTj.putExtra("acessF", acessojogoF);
                startActivity(voltarTj);
                String f;
                f=Integer.toString(pontuacaof);
                Log.e("pontuacao f: ",f);

            }
        });



        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAviao.setText("");
                edDado.setText("");
                edBanana.setText("");
                edCama.setText("");

            }
        });




    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }
}