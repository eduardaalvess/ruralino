package Negocio;

import Dados.InterfaceRepositorioAmigo;
import Dados.RepositorioAmigo;
import Exceptions.JaExisteEsteApelidoException;
import Model.Amigo;

public class ControladorAmigo {

    private InterfaceRepositorioAmigo<Amigo> repositorioAmigo;
    private static ControladorAmigo instance;

    private ControladorAmigo() {
        this.repositorioAmigo = new RepositorioAmigo<>();
    }

    static ControladorAmigo getInstance() {

        if (instance == null) {
            instance = new ControladorAmigo();
        }

        return instance;

    }

    public void cadastrarAmigo(Amigo amigo) throws JaExisteEsteApelidoException {
        repositorioAmigo.salvarAmigo(amigo);
    }


}
