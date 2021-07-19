package gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdcPessoasGruposController {

    @FXML
    private ChoiceBox<?> selecioneGrupo;

    @FXML
    private Button salvarPessoaGrupo;

    @FXML
    private ListView<?> tableListTodasPessoas;

    @FXML
    private ListView<?> tableListGrupo;

    @FXML
    private Button cancelButton;

    @FXML
    private Button addPessoaGrupoButton;

    @FXML
    private Button deletePessoaGrupo;

    @FXML
    void addPersonInGroup(ActionEvent event) {

    }

    @FXML
    void returnToPagInicial(ActionEvent event) throws IOException {
        Stage close = (Stage) cancelButton.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void deletePersonInGroup(ActionEvent event) {

    }

    @FXML
    void saveButton(ActionEvent event) {

    }

}
