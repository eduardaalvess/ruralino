package Negocio;

import Dados.InterfaceRepositorioAmigo;
import Dados.RepositorioAmigo;
import Exceptions.JaExisteEsteApelidoException;
import Model.Amigo;
import Model.Presente;

import java.util.List;

public class ControladorAmigo {

    private InterfaceRepositorioAmigo<Amigo> repositorioAmigo;
    private static ControladorAmigo instance;

    private ControladorAmigo() {
        this.repositorioAmigo = new RepositorioAmigo<>();
    }

    public static ControladorAmigo getInstance() {

        if (instance == null) {
            instance = new ControladorAmigo();
        }

        return instance;

    }

    public void cadastrarAmigo(Amigo amigo) throws JaExisteEsteApelidoException {
        repositorioAmigo.salvarAmigo(amigo);
    }

    public List<Amigo> list() {
        return repositorioAmigo.listAmigo();
    }

    void remove(Amigo amigo) {
        repositorioAmigo.remove(amigo);
    }

    void addPresentes(Amigo amigo, Presente presentes) {
        repositorioAmigo.addPresentes(amigo, presentes);
    }

    void removePresentes(Amigo amigo, Presente presentes) {
        repositorioAmigo.removePresentes(amigo, presentes);
    }


}
