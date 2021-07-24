package Dados;

import Model.Amigo;

import java.util.List;

public interface InterfaceRepositorioAmigo<T> {

    void salvarAmigo(Amigo amigo);

    List<Amigo> listAmigo();

    void remove(Amigo amigo);

}
