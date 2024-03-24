package etec.com.br.giovanna.focus.modelo;

import java.io.Serializable;

public class pontuacao implements Serializable {
    public int idUsuario;
    public String nomeTarefa;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public int getPont() {
        return pont;
    }

    public void setPont(int pont) {
        this.pont = pont;
    }

    public pontuacao(int idUsuario, String nomeTarefa, int pont) {
        this.idUsuario = idUsuario;
        this.nomeTarefa = nomeTarefa;
        this.pont = pont;
    }

    public int pont;
}



