package Dados;

import Exceptions.GrupoJaExiste;
import Model.Amigo;
import Model.Grupo;

import java.util.Collections;
import java.util.List;

public class RepositorioGrupo<G> implements InterfaceRepositorioGrupo<G> {
    @Override
    public void salvarGrupo(Grupo grupo) throws GrupoJaExiste {

    }

    @Override
    public List listGrupo() {
        return Collections.unmodifiableList(this.listGrupo());
    }

    @Override
    public void removeGrupo(Grupo grupo) {

    }

    @Override
    public void addAmigoAoGrupo(Grupo grupo, Amigo amigo) {

    }

    @Override
    public void removeAmigoDoGrupo(Grupo grupo, Amigo amigo) {

    }
}
