package Dados;

import Exceptions.JaExisteEsteApelidoException;
import Model.Amigo;
import Model.Presente;

import java.util.List;

public interface InterfaceRepositorioAmigo<A> {

    void salvarAmigo(Amigo amigo) throws JaExisteEsteApelidoException;

    List<Amigo> listAmigo();

    void remove(Amigo amigo);

    void addPresentes(Amigo amigo, Presente presentes);

    void removePresentes(Amigo amigo, Presente presentes);

}
