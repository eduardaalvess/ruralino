package Model;

import java.util.ArrayList;

public class Amigo {

    private String nome;
    private String apelido;
    private String senha;
    private ArrayList<Presente> presentes;

    public Amigo() {

    }

    public Amigo(String nome, String apelido, String senha) {
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
        presentes = new ArrayList<>();
    }

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

    public void addPresente(Presente presente) {
        this.presentes.add(presente);
    }

    public void removePresente(Presente presente) {
        this.presentes.remove(presente);
    }


    @Override
    public String toString() {
       return this.nome;
    }
}
