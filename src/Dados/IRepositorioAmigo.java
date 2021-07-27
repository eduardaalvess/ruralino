package Dados;

import Model.Amigo;
import Model.Presente;

import java.util.List;

public interface IRepositorioAmigo {
    boolean salvarAmigo(Amigo a);

    List<Amigo> amigoList();

    Amigo verificarApelido(Amigo apelido);

    String getNomes(Amigo amigo);
}
