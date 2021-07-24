package Dados;

import Model.Amigo;
import Model.Presente;

import java.util.List;

public interface InterfaceRepositorioPresentes<P> {

    void salvarPresente(Presente presente);

    List<Presente> listPresentes();

    void removePresente(Presente presente);

    void addPresentes(Presente presente, Amigo amigo);
}
