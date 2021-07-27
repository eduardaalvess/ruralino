package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Grupo implements Serializable {

    private String nomeDoGrupo;
    private LocalDate dataSorteio;
    private ArrayList<Amigo> amigos;
    private boolean sorteados;



    public Grupo() {

    }

    public Grupo(String nomeDoGrupo, LocalDate dataSorteio){
        this.nomeDoGrupo = nomeDoGrupo;
        this.dataSorteio = dataSorteio;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public LocalDate getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(LocalDate dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public boolean isSorteados() {
        return sorteados;
    }

    public void setSorteados(boolean sorteados) {
        this.sorteados = sorteados;
    }

    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Amigo> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo(Amigo amigo) {
        this.amigos.add(amigo);
    }

    public void removeAmigo(Amigo amigo) {
        this.amigos.remove(amigo);
    }

    @Override
    public String toString() {
        return this.nomeDoGrupo;
    }
}

