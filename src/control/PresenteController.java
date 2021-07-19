package control;

import model.Presente;

public class PresenteController {

    public boolean cadastrarPresente(String categoria, String descricao, String preco) {

        if(categoria != null && categoria.length() > 0 && descricao != null && descricao.length() > 0 && preco != null && preco.length() > 0) {

            Presente presente = new Presente(categoria, descricao, preco);
            presente.cadastrarPresente(presente);
            return true;

        }

        return false;
    }
}
