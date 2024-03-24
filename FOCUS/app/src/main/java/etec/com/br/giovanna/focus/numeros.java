package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.pontuacao;
import etec.com.br.giovanna.focus.modelo.respDao;

public class numeros extends AppCompatActivity {
    ImageView imCorreta, imCorreta2, imErrada, imErrada2, imErrada3, imErrada4;
    Button btVoltarTN, btFinalizar;

    int clique=0;
    String nomeTarefa;
    int idUsuRecebido, pontuacao = 6, acessoJogo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        imCorreta = findViewById(R.id.imgCorreta);
        imCorreta2 = findViewById(R.id.imgCorreta2);
        imErrada = findViewById(R.id.imgErrada);
        imErrada2 = findViewById(R.id.imgErrada2);
        imErrada3 = findViewById(R.id.imgErrada3);
        imErrada4 = findViewById(R.id.imgErrada4);
        btVoltarTN = findViewById(R.id.btnVoltarTN);
        btFinalizar= findViewById(R.id.btnFinalizar);


        //RECUPERANDO O NOME
        Intent telaNumeros = getIntent();
        Bundle nome = telaNumeros.getExtras();
        nomeTarefa = nome.getString("nomeTarefa");

        //RECUPERANDO O ID DO USUARIO
        Intent telanum = getIntent();
        Bundle nome1 = telanum.getExtras();
        idUsuRecebido = nome1.getInt("idUsu");
        String usu;
        usu = Integer.toString(idUsuRecebido);
        Log.e("id do usuario", usu);



        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //acesso ao jogo
                acessoJogo=1;


                //Instanciando as classes bd de pontuacao
                pontuacao p = new pontuacao(idUsuRecebido,nomeTarefa,pontuacao);
                respDao respdao = new respDao(numeros.this);

                AlertDialog.Builder alertavenceu = new AlertDialog.Builder(numeros.this);
                alertavenceu.setTitle("Parabéns!!");
                alertavenceu.setMessage("Você finalizou a tarefa: "+ nomeTarefa);
                alertavenceu.setIcon(android.R.drawable.star_big_on);
                alertavenceu.setPositiveButton("OK", null);
                alertavenceu.create();
                alertavenceu.show();


            }
        });







        //calculando pontos
        imCorreta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(numeros.this, "Você acertou!! Clique no botão finalizar", Toast.LENGTH_LONG).show();
                pontuacao = +1;
            }
        });

        imCorreta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(numeros.this, "Você errou... Tente novamente", Toast.LENGTH_SHORT).show();

                pontuacao = -1;
            }
        });

        imErrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(numeros.this, "Você errou... Tente novamente", Toast.LENGTH_SHORT).show();
                pontuacao = -1;
            }
        });

        imErrada2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(numeros.this, "Você errou... Tente novamente", Toast.LENGTH_SHORT).show();
                pontuacao = -1;
            }
        });

        imErrada3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(numeros.this, "Você errou... Tente novamente", Toast.LENGTH_SHORT).show();

                pontuacao = -1;
            }
        });

        imErrada4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(numeros.this, "Você errou... Tente novamente", Toast.LENGTH_SHORT).show();

                pontuacao = -1;
            }
        });

        btVoltarTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltarTj = new Intent(numeros.this, telaJogosTarefas.class);

                voltarTj.putExtra("pontuN", pontuacao);
                voltarTj.putExtra("acess", acessoJogo);
                startActivity(voltarTj);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }

}