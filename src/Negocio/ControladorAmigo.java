package Negocio;

import Model.Amigo;

import java.util.List;

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

    public void cadastrarAmigo() {

    } {

    }

    public List<Amigo> list() {

    }

}
