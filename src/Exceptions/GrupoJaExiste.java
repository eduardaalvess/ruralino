package Exceptions;

import javafx.scene.control.Alert;

public class GrupoJaExiste extends Exception{

    private Object gpJaExiste;

    public GrupoJaExiste(Object object) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Grupo Existente");
        alert.setContentText("Já existe um grupo com este nome");
        alert.showAndWait();

        this.gpJaExiste = object;
    }

    public Object getGpJaExiste() {
        return gpJaExiste;
    }

    public void setGpJaExiste(Object gpJaExiste) {
        this.gpJaExiste = gpJaExiste;
    }
}
