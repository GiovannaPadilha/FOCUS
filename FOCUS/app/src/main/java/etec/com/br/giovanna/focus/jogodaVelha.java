package etec.com.br.giovanna.focus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class jogodaVelha extends AppCompatActivity {
    private int qtde;
    private int jogador;
    private int mat [][] = new int[3][3];
    private Button b[] = new Button[9];
    private String ganhador;
    private String jogador1;
    private String jogador2;
    Button btVoltar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogoda_velha);

        btVoltar = findViewById(R.id.btnVoltarJogodaVelha);
        qtde = 1;
        jogador = 1;
        b[0] = findViewById(R.id.bt_1);
        b[1] = findViewById(R.id.bt_2);
        b[2] = findViewById(R.id.bt_3);
        b[3] = findViewById(R.id.bt_4);
        b[4] = findViewById(R.id.bt_5);
        b[5] = findViewById(R.id.bt_6);
        b[6] = findViewById(R.id.bt_7);
        b[7] = findViewById(R.id.bt_8);
        b[8] = findViewById(R.id.bt_9);


        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

       // mapeando os botoes

        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[0], 0, 0);

            }
        });

        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[1], 0, 1);
            }
        });

        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[2], 0, 2);
            }
        });

        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada(b[3], 1, 0);
            }
        });

        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[4], 1, 1);
            }
        });

        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[5], 1, 2);
            }
        });

        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jogada(b[6], 2, 0);
            }
        });

        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada(b[7], 2, 1);
            }
        });

        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogada(b[8], 2, 2);
            }
        });
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuprincipal,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemNovo:
                //chamando metodo limpar
                limpar();

                //criando um alert com uma editText para informar nome de jogadores
                final EditText edtText2= new EditText(this);
                AlertDialog.Builder segundjogador = new AlertDialog.Builder(this);
                segundjogador.setMessage("Digite o nome do jogador 2");
                segundjogador.setTitle("JOGADOR 2");
                segundjogador.setView(edtText2);

                segundjogador.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        jogador2 = edtText2.getText().toString();
                    }
                });
                        segundjogador.create();
                        segundjogador.show();

                final EditText edtText1= new EditText(this);
                AlertDialog.Builder primeirojogador = new AlertDialog.Builder(this);
                primeirojogador.setMessage("Digite o nome do jogador 1");
                primeirojogador.setTitle("JOGADOR 1");
                primeirojogador.setView(edtText1);
                primeirojogador.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        jogador1 = edtText1.getText().toString();
                        if(jogador1.isEmpty()){
                            Toast.makeText(jogodaVelha.this, "Digite o nome do Jogador1", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                primeirojogador.create();
                primeirojogador.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void jogada(Button b, int x, int y){
        b.setEnabled(true);
        if(jogador==1){
            mat[x][y]=1;
            b.setText("X");
            jogador=2;
            ganhador=jogador1;
            checarJogada(1);
        }else{
            mat[x][y]=2;
            b.setText("O");
            jogador=1;
            ganhador=jogador2;
            checarJogada(2);
        }
        qtde++;
    }

    public boolean vitoria(int x){

        // horizontal
        if(mat[0][0]==x && mat[0][1]==x && mat[0][2]==x){
            return true;
        }
        if(mat[1][0]==x && mat[1][1]==x && mat[1][2]==x){
            return true;
        }
        if(mat[2][0]==x && mat[2][1]==x && mat[2][2]==x){
            return true;
        }
        // vertical
        if(mat[0][0]==x && mat[1][0]==x && mat[2][0]==x){
            return true;
        }
        if(mat[0][1]==x && mat[1][1]==x && mat[2][1]==x){
            return true;
        }
        if(mat[0][2]==x && mat[1][2]==x && mat[2][2]==x){
            return true;
        }

        //diagonal
        if(mat[0][0]==x && mat[1][1]==x && mat[2][2]==x){
            return true;
        }
        if(mat[0][2]==x && mat[1][1]==x && mat[2][0]==x){
            return true;
        }
        return false;
    }
    public void checarJogada(int x){
        if(vitoria(x)==true){
            AlertDialog.Builder alertavenceu = new AlertDialog.Builder(this);
            alertavenceu.setTitle("VITÓRIA!!");
            alertavenceu.setMessage("O jogador " + ganhador + " venceu!!");
            alertavenceu.setIcon(android.R.drawable.star_on);
            alertavenceu.setPositiveButton("OK", null);
            alertavenceu.create();
            alertavenceu.show();
            fimJogo();

        }


    }
    public void fimJogo(){
        for(int i=0; i<9; i ++){
            b[i].setEnabled(false);
        }
    }
    public void limpar (){
        for( int i=0;i<9;i++){
            b[i].setEnabled(true);
            b[i].setText("");
        }
        for(int x=0;x<3;x++){
            for(int y = 0; y<3; y++){
                mat[x][y]=0;
            }
        }
        jogador=1;
        jogador1="";
        jogador2="";
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }


}