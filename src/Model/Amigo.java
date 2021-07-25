package Model;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Amigo {

    private String nome;
    private String apelido;
    private String senha;
    private ArrayList<Presente> presentes;


    /**
     *
     * REQ1. O sistema deve permitir o cadastramento de pessoas com as seguintes informações: nome
     * completo, apelido, senha e lista de presentes que deseja ganhar. Não deve ser permitido que
     * duas pessoas tenham o mesmo apelido. Essa lista de presentes poderá ser adicionada em
     * outro momento que não seja a criação da pessoa.
     *
     */


    public Amigo() {

    }

    public Amigo(String nome, String apelido, String senha) {
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
        presentes = new ArrayList<>();
    }

    /**

    private StringProperty nomes;

    public Amigo(StringProperty nomes) {
        this.nomes = nomes;
    }

    public String getNomes() {
        return nomes.get();
    }

     public void setNomes(String nomes) {
     this.nomes.set(nomes);
     }

    public StringProperty nomesProperty() {
        return nomes;
    }

     **/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Presente> getPresentes() {
        return presentes;
    }

    public void setPresentes(ArrayList<Presente> presentes) {
        this.presentes = presentes;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nApelido: %s\nPresentes: %s\n", this.nome, this.apelido, this.presentes);
    }
}
