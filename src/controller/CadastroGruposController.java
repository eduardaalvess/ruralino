package controller;

import DAO.GrupoDAO;
import dados.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

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
    void clickToAddPersonInGroup(ActionEvent event) throws IOException {

        Stage close = (Stage) addPessoaEmGrupo.getScene().getWindow();
        close.close();
        TelasController telasController = new TelasController();
        telasController.adcPessoas();

    }

    @FXML
    void clickToCancel(ActionEvent event) throws IOException {
        Stage close = (Stage) cancelarGrupo.getScene().getWindow();
        close.close();
        TelasController telasController = new TelasController();
        telasController.cancelAndReturn();
    }

    @FXML
    void clickToSave(ActionEvent event) {

        String nomeDoGrupo = nomeGrupo.getText();
        String data = String.valueOf(dataSorteio.getValue());

        if(nomeDoGrupo.isEmpty() || data.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Insira todas as informações!");
            alert.showAndWait();

        } else {

            validarGrupo();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Grupo Salvo com Sucesso!");
            alert.showAndWait();
        }

        }

    private void validarGrupo() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        GrupoDAO grupoDAO = new GrupoDAO();

        if(grupoDAO.create(nomeGrupo.getText(), Date.valueOf(dataSorteio.toString()))) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(" As Informações do Grupo foram Salvas com Sucesso!");
        }

    }

}
