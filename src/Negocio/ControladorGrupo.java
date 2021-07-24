package Negocio;

import Dados.InterfaceRepositorioGrupo;
import Dados.RepositorioGrupo;
import Exceptions.GrupoJaExiste;
import Model.Amigo;
import Model.Grupo;

import java.util.List;

public class ControladorGrupo {

    private InterfaceRepositorioGrupo<Grupo> repositorioGrupo;

    private static ControladorGrupo instance;

    private ControladorGrupo() {

        this.repositorioGrupo = new RepositorioGrupo<>();
    }

    public static ControladorGrupo getInstance() {

        if (instance == null) {
            instance = new ControladorGrupo();
        }

        return instance;

    }

    public void cadastrarGrupo(Grupo gp) throws GrupoJaExiste {

        repositorioGrupo.salvarGrupo(gp);

    }

    public List<Grupo> listGrupo() {
        return repositorioGrupo.listGrupo();
    }

    public void removerGrupo(Grupo grupo) {

        repositorioGrupo.removeGrupo(grupo);

    }

    public void addAmigoAoGrupo(Grupo grupo, Amigo amigo) {

        repositorioGrupo.addAmigoAoGrupo(grupo, amigo);

    }

    public void removeAmigoDoGrupo(Grupo grupo, Amigo amigo) {

        repositorioGrupo.removeAmigoDoGrupo(grupo, amigo);

    }
}
