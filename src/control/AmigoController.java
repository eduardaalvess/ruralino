package control;

import model.Amigo;

public class AmigoController {

    public boolean cadastrarAmigo(String nomeCompleto, String apelido, String senha) {
        if(nomeCompleto != null && nomeCompleto.length() > 0 && apelido != null && apelido.length() > 0 && senha != null && senha.length() > 0) {
            Amigo amigo = new Amigo(nomeCompleto, apelido, senha);
            amigo.cadastrarAmigo(amigo);
            return true;
        }
        return false;
    }
}
