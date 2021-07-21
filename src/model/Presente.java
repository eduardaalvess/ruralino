package model;

import DAO.PresenteDAO;
import dados.ConnectionFactory;

public class Presente {

    private String categoria;
    private String descricao;
    private String preco;


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

}
