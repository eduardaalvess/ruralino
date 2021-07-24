package Negocio;

public class ControladorGrupo {

    private static ControladorGrupo instance;

    private ControladorGrupo() {

    }

    static ControladorGrupo getInstance() {

        if (instance == null) {
            instance = new ControladorGrupo();
        }

        return instance;

    }
}
