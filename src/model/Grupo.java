package model;

import java.util.ArrayList;
import java.util.Date;

public class Grupo {

    private String nomeDoGrupo;
    private Date dataSorteio;
    private ArrayList<Amigo> amigos = new ArrayList<Amigo>();

    public Grupo() {

    }

    public Grupo(String nomeDoGrupo, Date dataSorteio){
        this.nomeDoGrupo = nomeDoGrupo;
        this.dataSorteio = dataSorteio;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Amigo> amigos) {
        this.amigos = amigos;
    }
}
