package Negocio;

public class ControladorSorteios {

    private static ControladorSorteios instance;

    private ControladorSorteios() {

    }

    static ControladorSorteios getInstance() {

        if (instance == null) {
            instance = new ControladorSorteios();
        }

        return instance;

    }

}
