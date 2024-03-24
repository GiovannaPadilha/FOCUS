package etec.com.br.giovanna.focus.modelo;

import java.io.Serializable;

public class tarefa implements Serializable {
        public String nometaf;

    public tarefa(String nometaf) {
        this.nometaf = nometaf;
    }

    public String getNometaf() {
        return nometaf;
    }
}
