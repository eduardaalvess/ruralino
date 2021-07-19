package gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.io.IOException;

public class CadastroPresentesPessoasController {

    @FXML
    private ChoiceBox<?> selecionarPessoa;

    @FXML
    private Button salvaPessoaPresente;

    @FXML
    private ListView<?> tableListTodosPresentes;

    @FXML
    private ListView<?> tableListPresentesParticipantes;

    @FXML
    private Button cancelarEscolhaPresente;

    @FXML
    private Button addPresentePessoaButton;

    @FXML
    private Button deletePessoaPresente;

    @FXML
    void addPresenteDoParticipante(ActionEvent event) {

    }

    @FXML
    void cancelButton(ActionEvent event) throws IOException {
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void deletarPresenteDoParticipante(ActionEvent event) {

    }

    @FXML
    void saveButton(ActionEvent event) {

    }

}

