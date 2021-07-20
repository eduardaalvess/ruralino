package controller;

import dados.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Amigo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ConsultaAmigoSecretoController implements Initializable {

    @FXML
    private ComboBox<?> grupoConsulta;

    @FXML
    private ComboBox<String> amigoConsulta;

    @FXML
    private PasswordField senhaConsulta;

    @FXML
    private Button consultarAmigoSecretoButton;

    @FXML
    private Button cancelarButton;

    // TENTATIVA 1

    ConnectionFactory jdbc;

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
        listarAmigos();
    }

    @FXML
    void selecionarGrupo(ActionEvent event) {

    }

    public void listarAmigos() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        jdbc = new ConnectionFactory();

    }
}

