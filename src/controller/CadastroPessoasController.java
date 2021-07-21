package controller;

import DAO.AmigoDAO;
import dados.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

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
        TelasController telasController = new TelasController();
        telasController.cancelAndReturn();
    }

    @FXML
    void clickGiftsButton(ActionEvent event) throws IOException {
        Stage close = (Stage) adcPresentesButton.getScene().getWindow();
        close.close();
        TelasController telasController = new TelasController();
        telasController.adcPresentes();
    }

    @FXML
    void clickSaveButton(ActionEvent event) {

        String nome = nomeCadastro.getText();
        String apelido = apelidoCadastro.getText();
        String senha = senhaCadastro.getText();

        if(nome != null && nome.length() > 0 && apelido != null && apelido.length() > 0 && senha != null && senha.length() > 0) {

            validarCadastro();

        }
        else {
            System.out.println("Erro ao salvar informações");
        }

    }

    public void validarCadastro() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        AmigoDAO amigoDAO = new AmigoDAO();

        if(amigoDAO.create(nomeCadastro.getText(), apelidoCadastro.getText(), senhaCadastro.getText())) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Informações Salvas com Sucesso!");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Não foi possivel salvar as informações");
            alert.showAndWait();
        }

    }

}

