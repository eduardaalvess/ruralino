package Negocio;

public class ControladorAmigo {

    private static ControladorAmigo instance;

    private ControladorAmigo() {
    }

    static ControladorAmigo getInstance() {

        if (instance == null) {
            instance = new ControladorAmigo();
        }

        return instance;

    }

}
