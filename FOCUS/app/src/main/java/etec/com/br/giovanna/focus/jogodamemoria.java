package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class jogodamemoria extends AppCompatActivity {
    ImageView img00, img01, img02, img03, img04, img05, img06, img07, img08, img09, img10, img11,
            img12, img13, img14, img15, imgEscolha1, imgEscolha2;
    private int contadorPontu = 0;
    TextView pontuacao;
    TextView tentativa;
    Integer escolha1 = -1, escolha2 = -1;
    List<Integer> imagens;
    Handler handler = new Handler();
    private int contadorGanhador = 0;
    private  int contadorTentativa = 10;
    int cliques = 0;
    Button btnReiniciar;
    Button btVoltarJM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogodamemoria);

        img00 = findViewById(R.id.img00);
        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
        img03 = findViewById(R.id.img03);
        img04 = findViewById(R.id.img04);
        img05 = findViewById(R.id.img05);
        img06 = findViewById(R.id.img06);
        img07 = findViewById(R.id.img07);
        img08 = findViewById(R.id.img08);
        img09 = findViewById(R.id.img09);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        btVoltarJM = findViewById(R.id.btnVoltarJM);
        pontuacao = findViewById(R.id.pontuacao);
        tentativa = findViewById(R.id.tentativa);

        btVoltarJM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarImagens();
                carregarFundo();
                contadorPontu = 0;
                pontuacao.setText(" " + contadorPontu);

                contadorTentativa = 10;
                tentativa.setText(" " + contadorTentativa);

            }
        });

        carregarImagens();
        carregarFundo();

        //clique da imagem
        img00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(0, img00);
            }
        });

        img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(1, img01);
            }
        });

        img02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(2, img02);
            }
        });


        img03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(3, img03);
            }
        });

        img04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(4, img04);
            }
        });

        img05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(5, img05);
            }
        });

        img06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(6, img06);

            }
        });

        img07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(7, img07);
            }
        });

        img08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(8, img08);
            }
        });

        img09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(9, img09);
            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(10, img10);
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(11, img11);
            }
        });

        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(12, img12);
            }
        });

        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(13, img13);
            }
        });

        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(14, img14);
            }
        });

        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virarImagem(15, img15);
            }
        });

    }

    public void virarImagem(Integer indiceEscolha, ImageView img) {
        img.setImageResource(imagens.get(indiceEscolha));//virar imagem correta

        if (escolha1 == -1) {
            imgEscolha1 = img;
            escolha1 = indiceEscolha;
        } else {
            imgEscolha2 = img;
            escolha2 = indiceEscolha;

            if (escolha1 == escolha2){
                return;
            }


            if (escolha1 != -1 & escolha2 != -1) {
                if (imagens.get(escolha1) == imagens.get(escolha2)) {
                    contadorPontu = contadorPontu +1;
                    pontuacao.setText(" " + contadorPontu);
                    Toast.makeText(this, "Você acertou!", Toast.LENGTH_SHORT).show();

                    desvirar(false);
                    imgEscolha1.setImageResource(R.drawable.acertou);
                    imgEscolha2.setImageResource(R.drawable.acertou);



                    contadorGanhador = contadorGanhador +1;
                    if(contadorGanhador == 8){
                        AlertDialog.Builder errou = new AlertDialog.Builder(jogodamemoria.this);
                        errou.setTitle("Parabéns!");
                        errou.setMessage("Você concluiu o jogo! Aperte OK para continuar.");
                        errou.setIcon(android.R.drawable.star_big_on);
                        errou.setPositiveButton("OK", null);
                        errou.create();
                        errou.show();

                    }
                } else {
                    Toast.makeText(this, "Você errou!", Toast.LENGTH_SHORT).show();
                    desvirar(true);
                }

            }

        }


    }


    public void desvirar(boolean erro) {
        //aguardar um tempo
        handler.postDelayed(new Runnable() {
            public void run() {
                if (erro) {
                    tentativa.setText(" " + contadorTentativa);
                    contadorTentativa = contadorTentativa -1;

                    if(contadorTentativa == 0) {
                        AlertDialog.Builder errou = new AlertDialog.Builder(jogodamemoria.this);
                        errou.setTitle("Poxa!");
                        errou.setMessage("Você esgotou as suas tentativas. Tente novamente ao reinciar jogo");
                        errou.setIcon(android.R.drawable.star_big_on);
                        errou.setPositiveButton("OK", null);
                        errou.create();
                        errou.show();
                        carregarFundo();
                        carregarImagens();
                        contadorTentativa = 10;
                    }

                    imgEscolha1.setImageResource(R.drawable.cerebro);
                    imgEscolha2.setImageResource(R.drawable.cerebro);
                }

                //zerar variaveis de escolha
                imgEscolha1 = null;
                imgEscolha2 = null;
                escolha1 = -1;
                escolha2 = -1;

            }

        }, 1000);
    }

    public void carregarFundo() {
        //carregar as imagens da lista nas ImageView
        img00.setImageResource(R.drawable.cerebro);
        img01.setImageResource(R.drawable.cerebro);
        img02.setImageResource(R.drawable.cerebro);
        img03.setImageResource(R.drawable.cerebro);
        img04.setImageResource(R.drawable.cerebro);
        img05.setImageResource(R.drawable.cerebro);
        img06.setImageResource(R.drawable.cerebro);
        img07.setImageResource(R.drawable.cerebro);
        img08.setImageResource(R.drawable.cerebro);
        img09.setImageResource(R.drawable.cerebro);
        img10.setImageResource(R.drawable.cerebro);
        img11.setImageResource(R.drawable.cerebro);
        img12.setImageResource(R.drawable.cerebro);
        img13.setImageResource(R.drawable.cerebro);
        img14.setImageResource(R.drawable.cerebro);
        img15.setImageResource(R.drawable.cerebro);

        contadorPontu = 0;
        pontuacao.setText(" " + contadorPontu);

        contadorTentativa = 10;
        tentativa.setText(" " + contadorTentativa);
    }




    public void carregarImagens() {
        imagens = new ArrayList<>();
        //adicionar imagens na lista
        imagens.add(R.drawable.abacate1);
        imagens.add(R.drawable.abacate1);
        imagens.add(R.drawable.abacaxi1);
        imagens.add(R.drawable.abacaxi1);
        imagens.add(R.drawable.banana1);
        imagens.add(R.drawable.banana1);
        imagens.add(R.drawable.maca1);
        imagens.add(R.drawable.maca1);
        imagens.add(R.drawable.melancia1);
        imagens.add(R.drawable.melancia1);
        imagens.add(R.drawable.morango1);
        imagens.add(R.drawable.morango1);
        imagens.add(R.drawable.pera1);
        imagens.add(R.drawable.pera1);
        imagens.add(R.drawable.uva1);
        imagens.add(R.drawable.uva1);
        Collections.shuffle(imagens); //embaralhar listas com imagens

        contadorPontu = 0;
        pontuacao.setText(" " + contadorPontu);

        contadorTentativa = 10;
        tentativa.setText(" " + contadorTentativa);
    }




    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }

}