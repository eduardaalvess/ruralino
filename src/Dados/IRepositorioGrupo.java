package Dados;

import Model.Grupo;

import java.util.List;

public interface IRepositorioGrupo {
    boolean salvarGrupo(Grupo g);

    boolean deletarGrupo(String g);

    List<Grupo> grupoList();
}
