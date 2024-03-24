package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.respDao;

public class desempenho extends AppCompatActivity {
    TextView tdesemResp, tusuario, tTaref, tTarefN;
    RatingBar rTaref, rTaren;
    Button btVoltar;
    String tarefN, tarefF, resp, usu;
    int pontF, pontN;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desempenho);
       tusuario=findViewById(R.id.txUsuario);
       tdesemResp=findViewById(R.id.txDesempenhoResp);
       tTaref=findViewById(R.id.txTarefaF);
       tTarefN=findViewById(R.id.txTarefaN);
       rTaref= findViewById(R.id.rbF);
       rTaren=findViewById(R.id.rbN);
       btVoltar=findViewById(R.id.btnVoltarD);

        Intent teladese = getIntent();
        Bundle nomel = teladese.getExtras();
        tarefF = nomel.getString("nomeFrase");
        tarefN = nomel.getString("nomeTarefa");
        resp= nomel.getString("nomeResp");
        usu=nomel.getString("nomeUsu");
        pontN=nomel.getInt("pontN");
        pontF=nomel.getInt("pontF");


        tusuario.setText("Pontuação de "+ usu);
        tdesemResp.setText("Olá, "+resp +" acompanhe por aqui o desempenho do seu filho!");





       rTaren.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               tTarefN.setText(tarefN );
               float pn = (float)pontN;
               rTaren.setRating(pn);


           }
       });
       rTaref.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               tTaref.setText(tarefF);
               float pf = (float)pontF;
               rTaren.setRating(pf);
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
    public void onBackPressed() {
        Toast.makeText(this, "Usar o botão voltar do aplicativo", Toast.LENGTH_SHORT).show();
    }
}