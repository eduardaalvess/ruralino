package Dados.DAO;

import Model.Grupo;

import java.util.List;

public interface InterfaceGrupoDAO {
    static void changeGrupo(Grupo grupo) {
    }

    List<Grupo> listGrupo();
}
