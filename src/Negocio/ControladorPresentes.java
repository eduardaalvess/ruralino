package Negocio;

import Model.Presente;

public class ControladorPresentes {

    private static ControladorPresentes instance;

    private ControladorPresentes() {

    }

    static ControladorPresentes getInstance() {

        if (instance == null) {
            instance = new ControladorPresentes();
        }

        return instance;

    }

    public void salvarPresente(Presente object) {

    }

}
