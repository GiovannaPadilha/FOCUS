package etec.com.br.giovanna.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import etec.com.br.giovanna.focus.modelo.Responsavel;
import etec.com.br.giovanna.focus.modelo.UsuarioDAO;
import etec.com.br.giovanna.focus.modelo.respDao;
import etec.com.br.giovanna.focus.modelo.usuario;

public class CadastroUsuario extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
Button btCadastrarUsuario;
EditText edNomeUsu;
String selecao, nomeRespo;
    String nome;
    int idResp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        btCadastrarUsuario = findViewById(R.id.btnCadastrar);
        edNomeUsu = findViewById(R.id.edtNomeUsuario);

        Spinner spinner= findViewById(R.id.spn1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.comorbidade, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
       selecao  = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void inserirUsu(View v){
        nome = edNomeUsu.getText().toString();

        Intent telaAtual = getIntent();

        Bundle valores= telaAtual.getExtras();

        idResp = valores.getInt("idResp");
        nomeRespo = valores.getString("nomeResp");



        usuario r = new usuario(nome,selecao,idResp);
        UsuarioDAO usudao = new UsuarioDAO(this);
        long id = usudao.InserirUsu(r);
        String idU = Long.toString(id);
        int idusua = Integer.parseInt(idU);

        if(nome.isEmpty()){
            edNomeUsu.setError("Informe o nome do Usuário");
        } else if (selecao.contains("Comorbidade")|| selecao.isEmpty()) {
            Toast.makeText(this, "Insira uma comorbidade", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent AbrirLoginF = new Intent(CadastroUsuario.this, telaLogin.class);
            AbrirLoginF.putExtra("nomeUsu",nome);
            AbrirLoginF.putExtra("nomeRespon",nomeRespo);
            AbrirLoginF.putExtra("idUsu", idusua);
            startActivity(AbrirLoginF);
           // Toast.makeText(this, "usuario cadastrado, id: "+idusua, Toast.LENGTH_SHORT).show();


        }
    }
    @Override
    public void onBackPressed() {
        //Toast.makeText(this, "Usar os botões do aplicativo", Toast.LENGTH_SHORT).show();
    }
}