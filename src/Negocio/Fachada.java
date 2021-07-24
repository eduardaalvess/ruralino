package Negocio;

import Model.Amigo;

public class Fachada {

    private static Fachada instance;

    private ControladorAmigo controladorAmigo;
    private ControladorGrupo controladorGrupo;
    private ControladorPresentes controladorPresentes;
    private ControladorSorteios controladorSorteios;

    private Fachada() {

        this.controladorAmigo = ControladorAmigo.getInstance();
        this.controladorGrupo = ControladorGrupo.getInstance();
        this.controladorPresentes = ControladorPresentes.getInstance();
        this.controladorSorteios = ControladorSorteios.getInstance();

    }

    public static Fachada getInstance() {

        if (instance == null) {
            instance = new Fachada();
        }

        return instance;

    }

}
