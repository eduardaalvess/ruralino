package Negocio;


import Dados.DAO.AmigosDAO;
import Dados.DAO.GrupoDAO;
import Dados.DAO.PresenteDAO;
import Model.Amigo;
import Model.Grupo;
import Model.Presente;

import java.util.List;

public class Negocio {

    private AmigosDAO amigosDAO;
    private GrupoDAO grupoDAO;
    private PresenteDAO presenteDAO;

    public Negocio() {
        amigosDAO = AmigosDAO.getInstance();
        grupoDAO = GrupoDAO.getInstance();
        presenteDAO = PresenteDAO.getInstance();
    }

    List<Amigo> amigoList() {
        return this.amigosDAO.listAmigos();
    }

    List<Grupo> grupoList() {
        return this.grupoDAO.listGrupo();
    }

    List<Presente> presenteList() {
        return this.presenteDAO.listPresente();
    }

    public void addAmigo(Amigo amigo, Grupo grupo) {
        if(amigo != null && grupo != null && !grupo.getAmigos().contains(amigo)) {

        }
    }

    public void addPresente(Presente presente, Amigo amigo) {

    }

}
