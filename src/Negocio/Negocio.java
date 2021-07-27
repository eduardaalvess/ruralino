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


import java.util.List;

public class Negocio {

    private IRepositorioAmigo iRepositorioAmigo;
    private IRepositorioGrupo iRepositorioGrupo;
    private IRepositorioPresentes iRepositorioPresentes;

    public Negocio() {
        iRepositorioAmigo = RepositorioAmigo.getInstance();
        iRepositorioGrupo = RepositorioGrupo.getInstance();
        iRepositorioPresentes = RepositorioPresentes.getInstance();
    }

    List<Amigo> amigoList() {
        return this.iRepositorioAmigo.amigoList();
    }
    List<Grupo> grupoList() {
        return this.iRepositorioGrupo.grupoList();
    }
    List<Presente> presenteList() {
        return this.iRepositorioPresentes.presenteList();
    }

    /*
    ---------------AMIGOS-----------------
     */

    public boolean salvarAmigo() {
        //TO-DO
    }

    public boolean listAmigos() {
        //TO-DO
    }

    public boolean addAmigoAoGrupo() {
        //TO-DO
    }

    public boolean addPresenteAoAmigo() {
        //TO-DO
    }

    public boolean rmvAmigoDoGrupo() {
        //TO-DO
    }

    public boolean rmvPresenteDoAmigo() {
        //TO-DO
    }

    /*
    ---------------GRUPOS---------------
     */

    public boolean salvarGrupo() {
        //TO-DO
    }

    public boolean addAmigoAoGrupo() {
        //TO-DO
    }

    public boolean rmvAmigoDoGrupo() {
        //TO-DO
    }

    public boolean listGrupo() {
        //TO-DO
    }

    /*
    -------------------PRESENTES------------------
     */

    public boolean salvarPresentes() {
        //TO-DO
    }

    public boolean listPresentes() {
        //TO-DO
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
