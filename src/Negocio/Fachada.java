package Negocio;

import Model.Amigo;
import Model.Grupo;
import Model.Presente;

import java.time.LocalDate;
import java.util.List;

public class Fachada {

    private static Fachada instance;

    private Negocio negocios;

    private Fachada() {
        this.negocios = Negocio.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }


    /*
    -----------------------AMIGOS-------------------------
     */


    public void salvarAmigo(String nome, String apelido, String senha) {
        negocios.salvarAmigo(nome, apelido, senha);
    }

    public List<Amigo> listAmigos() {
        return negocios.listAmigos();
    }

    public void addAmigoAoGrupo(Amigo a, Grupo g) {
        negocios.addAmigoAoGrupo(a, g);
    }

    public void addPresenteAoAmigo(Presente p, Amigo a) {
        negocios.addPresenteAoAmigo(p, a);
    }

    public void rmvPresenteDoAmigo(Presente p, Amigo a) {
        negocios.rmvPresenteDoAmigo(p, a);
    }

    /*
    -----------------------GRUPOS-------------------------
     */

    public void salvarGrupo(String nome, LocalDate dataDoSorteio) {
        negocios.salvarGrupo(nome, dataDoSorteio);
    }

    public void addAmigoAoGrupo(Grupo g, Amigo a) {
        negocios.addAmigoAoGrupo(g, a);
    }

    public void rmvAmigoDoGrupo(Grupo g, Amigo a) {
        negocios.rmvAmigoDoGrupo(g, a);
    }

    public List<Grupo> listGrupo() {
        return negocios.listGrupo();
    }

    /*
    -----------------------PRESENTES-------------------------
     */

    public void salvarPresentes(String categoria, String descricao, String preco) {
        negocios.salvarPresentes(categoria, descricao, preco);
    }

    public List<Presente> listPresentes() {
        return negocios.listPresentes();
    }

}
