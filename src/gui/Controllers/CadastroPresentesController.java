package gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CadastroPresentesController {

    @FXML
    private TextField categoriaField;

    @FXML
    private TextField descricaoField;

    @FXML
    private TextField precoField;

    @FXML
    private Button salvarPresente;

    @FXML
    private Button cancelarPresente;

    @FXML
    void cancelButton(ActionEvent event) throws IOException {
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void saveButton(ActionEvent event) {

    }

}
