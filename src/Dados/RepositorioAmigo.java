package Dados;

import Model.Amigo;

import java.util.List;

public class RepositorioAmigo implements InterfaceRepositorioAmigo {

    private List<Amigo> amigoList;
    private static RepositorioAmigo instance;

    public static RepositorioAmigo getInstance() {
        return instance;
    }
}
