package Negocio;


import Dados.DAO.*;
import Model.Amigo;
import Model.Grupo;
import Model.Presente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Negocio {

    private AmigosDAO amigosDAO;
    private GrupoDAO grupoDAO;
    private PresenteDAO presenteDAO;

    private static Negocio instance;

    public Negocio() {
        amigosDAO = AmigosDAO.getInstance();
        grupoDAO = GrupoDAO.getInstance();
        presenteDAO = PresenteDAO.getInstance();
    }

    public static Negocio getInstance() {
        if (instance == null) {
            instance = new Negocio();
        }

        return instance;
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
            grupo.addAmigo(amigo);
        }
    }

    public void addPresente(Presente presente, Amigo amigo) {
        InterfaceAmigosDAO.addPresenteAmigo(amigo, presente);
    }

    public void rmvPresente(Presente presente, Amigo amigo) {
        InterfaceAmigosDAO.rmvPresenteAmigo(amigo, presente);
    }

    public ObservableList<Amigo> listAmigoGrupo(Grupo gp) {
        for (int i = 0; i < grupoList().size(); i++) {
            if(grupoList().get(i).equals(gp)) {
                return FXCollections.observableArrayList(grupoList().get(i).getAmigos());
            }
        }

        return null;
    }

    public void sorteio (Grupo grupo) {
        if(grupo != null) {
            System.out.println("Erro 1");
        }
        if(grupo.getDataSorteio().isAfter(LocalDate.now())) {
            System.out.println("Erro 2");
        }
        else {

            Collections.shuffle(grupo.getAmigos());
            grupo.setSorteados(true);
            InterfaceGrupoDAO.changeGrupo(grupo);
            // grupo.listAmigos();
            // grupo.listAmigoSecreto();

        }
    }



}
