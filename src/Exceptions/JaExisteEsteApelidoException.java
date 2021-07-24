package Exceptions;


import javafx.scene.control.Alert;

public class JaExisteEsteApelidoException extends Exception{

    private Object jaExisteApelido;

    public JaExisteEsteApelidoException(Object object) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Apelido já existente");
        alert.setContentText("Já existe um usuário com este apelido!");
        alert.showAndWait();

        this.jaExisteApelido = object;
    }

    public Object getJaExisteApelido() {
        return jaExisteApelido;
    }

    public void setJaExisteApelido(Object jaExisteApelido) {
        this.jaExisteApelido = jaExisteApelido;
    }

}
