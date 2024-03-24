package etec.com.br.giovanna.focus.modelo;

import java.io.Serializable;
import java.util.Date;

public class Responsavel implements Serializable {


    private String nome;
    private String datanasc;
    private String email;
    private String senha;


    public Responsavel(String nome, String datanasc, String email, String senha) {

        this.nome = nome;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString()
        {
            return nome.toString();
        }

}
