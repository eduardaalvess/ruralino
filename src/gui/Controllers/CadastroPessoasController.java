package gui.Controllers;

import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroPessoasController {

    @FXML
    private TextField nomeCadastro;

    @FXML
    private TextField apelidoCadastro;

    @FXML
    private PasswordField senhaCadastro;

    @FXML
    private Button salvarCadastro;

    @FXML
    private Button adcPresentesButton;

    @FXML
    private Button cancelarCadastro;

    @FXML
    void clickCancelButton(ActionEvent event) throws IOException {
        Stage close = (Stage) cancelarCadastro.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void clickGiftsButton(ActionEvent event) throws IOException {
        Stage close = (Stage) adcPresentesButton.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.adcPresentes();
    }

    @FXML
    void clickSaveButton(ActionEvent event) {

    }

}

