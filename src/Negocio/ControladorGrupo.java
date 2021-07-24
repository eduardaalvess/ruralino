package Negocio;

import Dados.InterfaceRepositorioGrupo;
import Dados.RepositorioGrupo;
import Exceptions.GrupoJaExiste;
import Model.Grupo;

public class ControladorGrupo {

    private InterfaceRepositorioGrupo<Grupo> repositorioGrupo;

    private static ControladorGrupo instance;

    private ControladorGrupo() {

        this.repositorioGrupo = new RepositorioGrupo<>();
    }

    static ControladorGrupo getInstance() {

        if (instance == null) {
            instance = new ControladorGrupo();
        }

        return instance;

    }

    public void cadastrarGrupo(Grupo gp) throws GrupoJaExiste {

    }
}
