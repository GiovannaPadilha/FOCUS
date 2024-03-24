package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.respDao;
import etec.com.br.giovanna.focus.modelo.tarefa;
import etec.com.br.giovanna.focus.modelo.tarefaDAO;

public class telaJogosTarefas extends AppCompatActivity {
ImageButton imBFrases, imBNumeros, imBMemoria, imBvelha, imBmenu;
Button btVoltarjt;
String nomeRespo, nomeUsua;
int idTJ, acessojogos, acessF, pontN, pontF;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogos_tarefas);
        imBvelha=findViewById(R.id.imBtVelha);
        imBFrases=findViewById(R.id.imBtFrases);
        imBMemoria=findViewById(R.id.imBtnmMemoria);
        imBNumeros=findViewById(R.id.imgBtNumeros);
        imBMemoria = findViewById(R.id.imBtnmMemoria);
        imBmenu = findViewById(R.id.imgBmenu);

        btVoltarjt=findViewById(R.id.btnVoltarJT);

            //LIBERANDO ACESSO PELA TAREFA NUMEROS
        Intent telaj = getIntent();
        Bundle acesso = telaj.getExtras();
        acessojogos = acesso.getInt("acess");
        pontN=acesso.getInt("pontuN");

        // LIBERANDO ACESSO PELA TAREFA FRASE
        Intent telajf = getIntent();
        Bundle acessoF = telajf.getExtras();
        acessF = acessoF.getInt("acessF");
        pontF=acessoF.getInt("pontuF");


        //PEGANDO NOME DO USUARIO E DO RESPONSAVEL
        Intent telajf1 = getIntent();
        Bundle nomeRespeUsu = telajf1.getExtras();
        nomeRespo = nomeRespeUsu.getString("nomeRes");
        nomeUsua=nomeRespeUsu.getString("nomeUsu");





        imBmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirDesempenho = new Intent(telaJogosTarefas.this, desempenho.class);

                abrirDesempenho.putExtra("nomeFrase", "Indicando o nome");
                abrirDesempenho.putExtra("nomeTarefa", "Aprendendo números");
                abrirDesempenho.putExtra("nomeUsu", nomeUsua);
                abrirDesempenho.putExtra("nomeResp", nomeRespo);
                abrirDesempenho.putExtra("pontF", pontF);
                abrirDesempenho.putExtra("pontN", pontN);

                startActivity(abrirDesempenho);

            }
        });


        imBFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AbrirFrases = new Intent(telaJogosTarefas.this, tarefaFrases.class);
                AbrirFrases.putExtra("nomeFrase", "Indicando o nome");
                startActivity(AbrirFrases);
            }

        });
        imBvelha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(acessojogos<1){
                    if(acessF <1){
                    imBvelha.setEnabled(false);
                    Toast.makeText(telaJogosTarefas.this, "Faça suas tarefas antes de jogar ", Toast.LENGTH_SHORT).show();
                }}else{
                    imBvelha.setEnabled(true);
                    Intent AbrirJogodaVelha = new Intent(telaJogosTarefas.this, jogodaVelha.class);
                    startActivity(AbrirJogodaVelha);
                }

            }
        });
        btVoltarjt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltarPrin = new Intent(telaJogosTarefas.this, Telaprincipal.class);
                startActivity(voltarPrin);
            }
        });

        imBNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirNumeros = new Intent (telaJogosTarefas.this, numeros.class);

                Intent telanum = getIntent();
                Bundle nomel = telanum.getExtras();
                idTJ = nomel.getInt("idUsu");


                abrirNumeros.putExtra("nomeTarefa", "Aprendendo números");
                abrirNumeros.putExtra("idUsu", idTJ);

                startActivity(abrirNumeros);
            }
        });

        imBMemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(acessojogos<1){if( acessF<1){
                    imBMemoria.setEnabled(false);
                    Toast.makeText(telaJogosTarefas.this, "Faça suas tarefas antes de jogar", Toast.LENGTH_SHORT).show();
                }}else{
                    imBMemoria.setEnabled(true);
                    Intent abrirJogodaMemoria = new Intent(telaJogosTarefas.this, jogodamemoria.class);
                    startActivity(abrirJogodaMemoria);
                }
            }
        });



    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }

}