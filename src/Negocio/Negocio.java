package Negocio;

import Dados.*;

import Model.Amigo;
import Model.Grupo;
import Model.Presente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.Collections;
import java.util.List;

public class Negocio implements Serializable {

    private static Negocio instance;

    @Serial
    private static final long serialVersionUID = 2906642554793891381L;

    private RepositorioAmigo repositorioAmigo;
    private RepositorioGrupo repositorioGrupo;
    private RepositorioPresentes repositorioPresentes;

    public static Negocio getInstance() {
        if(instance == null) {
            instance = new Negocio();
        }

        return instance;

    }

    private Negocio() {

        super();

        this.repositorioAmigo = RepositorioAmigo.getInstance();
        this.repositorioGrupo = RepositorioGrupo.getInstance();
        this.repositorioPresentes = RepositorioPresentes.getInstance();
    }

    /*
    ---------------AMIGOS-----------------
     */

    public boolean salvarAmigo(String nome, String apelido, String senha) {
        if(nome == null || apelido == null || senha == null) {
            return false;
        } else {
            Amigo salvo = new Amigo(nome, apelido, senha);
            this.repositorioAmigo.salvarAmigo(salvo);
            this.repositorioAmigo.saveFile();
            return true;
        }
    }

    List<Amigo> amigoList() {
        return this.repositorioAmigo.amigoList();
    }

    public boolean addAmigoAoGrupo(Amigo a, Grupo g) {
        if(g.getAmigos().contains(a)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Amigo já está no grupo");
            alert.setContentText(a.getNome() + " já está no grupo " + g.getNomeDoGrupo());
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
            return false;
        }
        if(a == null) {
            return false;
        }
        if(g == null) {
            return false;
        } else {
            g.addAmigo(a);
            g.setSorteados(false);
            return true;
        }
    }

    public boolean rmvAmigoDoGrupo(Grupo g, Amigo a) {
        if(g == null || a == null) {
            return false;
        }
        if(g != null && a != null){
        for(int i = 0; i < grupoList().size(); i++) {
            if (grupoList().get(i).equals(g)) {
                grupoList().get(i).removeAmigo(a);
                return true;
            }
        }
        }

        return false;
    }

    public boolean addPresenteAoAmigo(Presente p, Amigo a) {
        if(a.getPresentes().contains(p)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Presente já foi adicionado");
            alert.setContentText("Presente já adicionado");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
            return false;
        }
        if(p == null) {
            return false;
        }
        if(a == null) {
            return false;
        }
        else {
            a.addPresente(p);
            return true;
        }
    }

    public boolean rmvPresenteDoAmigo(Presente p, Amigo a) {
        if(p == null || a == null) {
            return false;
        }
        else {
            for(int i = 0; i < presenteList().size(); i++) {
                if(presenteList().get(i).equals(p)) {
                    presenteList().get(i).removeAmigo(a);
                    return true;
                }
            }
        }

        return false;

    }

    /*
    -----------------------GRUPOS-------------------------
     */

    public boolean salvarGrupo(String nome, LocalDate dataDoSorteio) {
        if(nome == null || dataDoSorteio == null) {
            return false;
        }
        if(dataDoSorteio.isBefore(LocalDate.now())) {
            return false;
        } else {
            Grupo salvo = new Grupo(nome, dataDoSorteio);
            this.repositorioGrupo.salvarGrupo(salvo);
            this.repositorioGrupo.saveFile();
            return true;
        }
    }

    List<Grupo> grupoList() {
        return this.repositorioGrupo.grupoList();
    }

    /*
    -----------------------PRESENTES-------------------------
     */

    public boolean salvarPresentes(String categoria, String descricao, String preco) {
        if(categoria == null || descricao == null || preco == null) {
            return false;
        } else {
            Presente salvo = new Presente(categoria, descricao, preco);
            this.repositorioPresentes.salvarPresente(salvo);
            this.repositorioPresentes.saveFile();
            return true;
        }
    }

    List<Presente> presenteList() {
        return this.repositorioPresentes.presenteList();
    }

    public List<Presente> listPresentes() {
        return this.presenteList();
    }

    /*
    -----------------------SORTEIO-------------------------
     */

    public boolean sorteio(Grupo gp) {
        if(gp == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Selecione um grupo válido");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
            return false;
        }
        if(gp.getDataSorteio().isAfter(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("O sorteio ainda não pode ser realizado");
            alert.setContentText("Eu sei que a ansiedade está demais! " +
                    "Mas a data do sorteio ainda não chegou!");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
            return false;
        }
        else {
            Collections.shuffle(gp.getAmigos());
            gp.setSorteados(true);
            // repositorioGrupo.atualizarGrupo(gp);
            // repositorioGrupo.amigosSecretos(gp);
            return true;
        }
    }

    public Amigo consultarAmigoSecreto(Grupo g, Amigo a, String senha) {
        return null;
        //TO DO
    }

     /*
    -----------------------OBSERVABLE LIST-------------------------
     */

    public ObservableList<Amigo> amigosEmGrupo(Grupo g) {
        for(int i = 0; i < grupoList().size(); i++) {
            if(grupoList().get(i).equals(g)) {
                return FXCollections.observableArrayList(grupoList().get(i).getAmigos());
            }
        }

        return null;

    }

    public ObservableList<Presente> presentesDosAmigos(Amigo a) {
        for(int i = 0; i < amigoList().size(); i++) {
            if(amigoList().get(i).equals(a)) {
                return FXCollections.observableArrayList(amigoList().get(i).getPresentes());
            }
        }

        return null;

    }
}
