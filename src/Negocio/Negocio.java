package Negocio;

import Dados.IRepositorioAmigo;
import Dados.IRepositorioGrupo;
import Dados.IRepositorioPresentes;
import Dados.RepositorioAmigo;
import Dados.RepositorioGrupo;
import Dados.RepositorioPresentes;
import Model.Amigo;
import Model.Grupo;
import Model.Presente;


import java.time.LocalDate;
import java.util.List;

public class Negocio {

    private static Negocio instance;

    private RepositorioAmigo repositorioAmigo;
    private RepositorioGrupo repositorioGrupo;
    private RepositorioPresentes repositorioPresentes;

    public Negocio() {

        super();

        this.repositorioAmigo = RepositorioAmigo.getInstance();
        this.repositorioGrupo = RepositorioGrupo.getInstance();
        this.repositorioPresentes = RepositorioPresentes.getInstance();
    }

    public static Negocio getInstance() {
        if(instance == null) {
            instance = new Negocio();
        }

        return instance;

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

    public List<Amigo> listAmigos() {
        return this.amigoList();
    }

    public boolean addAmigoAoGrupo(Amigo a, Grupo g) {
        //TO-DO
    }

    public boolean addPresenteAoAmigo(Presente p, Amigo a) {
        //TO-DO
    }

    public boolean rmvPresenteDoAmigo(Presente p, Amigo a) {
        //TO-DO
    }

    /*
    ---------------GRUPOS---------------
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

    public boolean addAmigoAoGrupo(Grupo g, Amigo a) {
        //TO-DO
    }

    public boolean rmvAmigoDoGrupo(Grupo g, Amigo a) {
        //TO-DO
    }

    List<Grupo> grupoList() {
        return this.repositorioGrupo.grupoList();
    }

    public List<Grupo> listGrupo() {
        return this.grupoList();
    }

    /*
    -------------------PRESENTES------------------
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
    --------------SORTEIO--------------
     */

    public boolean sorteio() {
        //TO-DO
    }

    public boolean consultarAmigoSecreto() {
        //TO-DO
    }
}
