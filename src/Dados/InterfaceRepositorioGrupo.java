package Dados;

import Exceptions.GrupoJaExiste;
import Model.Amigo;
import Model.Grupo;

import java.util.List;

public interface InterfaceRepositorioGrupo<G> {

    void salvarGrupo(Grupo grupo) throws GrupoJaExiste;

    List<Grupo> listGrupo();

    void removeGrupo(Grupo grupo);

    void addAmigoAoGrupo(Grupo grupo, Amigo amigo);

    void removeAmigoDoGrupo(Grupo grupo, Amigo amigo);
}
