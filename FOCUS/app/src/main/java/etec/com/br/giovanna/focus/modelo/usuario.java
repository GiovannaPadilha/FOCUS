package etec.com.br.giovanna.focus.modelo;

import java.io.Serializable;
import java.io.StringReader;

public class usuario implements Serializable {
    public String nomeUsu;
    public String comorbidade;
    public int idResp;



    public usuario(String nomeUsu, String comorbidade, int fk_idResp) {
        this.nomeUsu = nomeUsu;
        this.comorbidade = comorbidade;
        this.idResp = fk_idResp;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getComorbidade() {
        return comorbidade;
    }

    public void setComorbidade(String comorbidade) {
        this.comorbidade = comorbidade;
    }
    public int getIdRespon() {

        return idResp;
    }
    /*    @Override
    public String toString()
    {
        return nomeUsu.toString();

    }*/
}
