package controller;

import DAO.PresenteDAO;
import dados.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

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
        Stage close = (Stage) cancelarPresente.getScene().getWindow();
        close.close();
        TelasController telasController = new TelasController();
        telasController.cancelAndReturn();
    }

    @FXML
    void saveButton(ActionEvent event) {

        String categoria = categoriaField.getText();
        String descricao = descricaoField.getText();
        String preco = precoField.getText();

        if(categoria.isEmpty() || descricao.isEmpty() || preco.isEmpty()) {

            System.out.println("Erro ao salvar informações");

        } else {
            validarPresente();
        }
    }

    public void validarPresente() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        PresenteDAO presenteDAO = new PresenteDAO();

        if(presenteDAO.create(categoriaField.getText(), descricaoField.getText(), precoField.getText())) {

            System.out.println("Informações salvas com sucesso!");

        }

    }

}
