package view.gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroGruposController {

    @FXML
    private TextField nomeGrupo;

    @FXML
    private DatePicker dataSorteio;

    @FXML
    private Button salvarGrupo;

    @FXML
    private Button cancelarGrupo;

    @FXML
    private Button addPessoaEmGrupo;

    @FXML
    void clickToAddPersonInGroup(ActionEvent event) {

    }

    @FXML
    void clickToCancel(ActionEvent event) throws IOException {
        Stage close = (Stage) cancelarGrupo.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void clickToSave(ActionEvent event) {

    }

}
