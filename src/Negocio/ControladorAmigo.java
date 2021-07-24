package Negocio;

import Model.Amigo;

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

    public void cadastrarAmigo(Amigo object) {

    }

}
