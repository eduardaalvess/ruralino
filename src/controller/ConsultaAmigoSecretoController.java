package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsultaAmigoSecretoController {

    @FXML
    private ComboBox<?> grupoConsulta;

    @FXML
    private ComboBox<?> amigoConsulta;

    @FXML
    private PasswordField senhaConsulta;

    @FXML
    private Button consultarAmigoSecretoButton;

    @FXML
    private Button cancelarButton;

    @FXML
    void checarSenha(ActionEvent event) {

    }

    @FXML
    void consultarAmigoSecretoAction(ActionEvent event) {

    }

    @FXML
    void retornarPagInicial(ActionEvent event) throws IOException {

        Stage close = (Stage) cancelarButton.getScene().getWindow();
        close.close();
        TelasController telasController = new TelasController();
        telasController.cancelAndReturn();

    }

    @FXML
    void selecionarAmigo(ActionEvent event) {

    }

    @FXML
    void selecionarGrupo(ActionEvent event) {

    }

}

