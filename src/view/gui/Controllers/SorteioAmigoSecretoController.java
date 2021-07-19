package view.gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SorteioAmigoSecretoController {

    @FXML
    private ChoiceBox<?> escolherGrupoParaSorteio;

    @FXML
    private Button realizarSorteioButton;

    @FXML
    private Button consultarAmigoButton;

    @FXML
    private Button cancelButton;

    @FXML
    void consultarAmigoSecreto(ActionEvent event) throws IOException {
        Stage close = (Stage) consultarAmigoButton.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.consultarAmigoSecreto();
    }

    @FXML
    void realizarSorteio(ActionEvent event) throws IOException {

    }

    @FXML
    void returnToPagInicial(ActionEvent event) throws IOException {
        Stage close = (Stage) cancelButton.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

}

