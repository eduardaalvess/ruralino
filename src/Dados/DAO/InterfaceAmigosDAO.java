package Dados.DAO;

import Model.Amigo;
import Model.Presente;

import java.util.List;

public interface InterfaceAmigosDAO {
    static void addPresenteAmigo(Amigo amigo, Presente presente) {
    }

    static void rmvPresenteAmigo(Amigo amigo, Presente presente) {
    }

    List<Amigo> listAmigos();
}
