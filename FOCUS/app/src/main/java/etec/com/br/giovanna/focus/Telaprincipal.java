
package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Telaprincipal extends AppCompatActivity {
ImageView imBPlay;
String nomeusu, nomeres;
int idP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal);
        imBPlay=findViewById(R.id.imBtPlay);


        imBPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AbrirTelaJogos = new Intent(Telaprincipal.this, telaJogosTarefas.class);

                Intent telanum = getIntent();
                Bundle nomel = telanum.getExtras();
                idP = nomel.getInt("idUsu");
                nomeres = nomel.getString("nomeRespon");
                nomeusu= nomel.getString("nomeUsu");

                AbrirTelaJogos.putExtra("idUsu", idP);
                AbrirTelaJogos.putExtra("nomeRes", nomeres);
                AbrirTelaJogos.putExtra("nomeUsu", nomeusu);

                startActivity(AbrirTelaJogos);
            }
        });



    }
}