package Dados;

import Model.Amigo;
import Model.Presente;

import java.util.List;

public interface IRepositorioAmigo {
    boolean salvarAmigo(Amigo a);

    List<Amigo> amigoList();

    Amigo verificarApelido(Amigo apelido);

    String getNomes(Amigo amigo);

    boolean addPresenteDoAmigo(Amigo a, Presente p);

    boolean rmvPresenteDoAmigo(Amigo a, Presente p);
}
