package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Presente implements Serializable {

    private String categoria;
    private String descricao;
    private String preco;
    private ArrayList<Amigo> amigos;


    public Presente() {

    }

    public Presente(String categoria, String descricao, String preco) {

        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    public void addAmigo(Amigo amigo) {
        this.amigos.add(amigo);
    }

    public void removeAmigo(Amigo amigo) {
        this.amigos.remove(amigo);
    }

}
