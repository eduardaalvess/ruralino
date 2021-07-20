package view.gui.Controllers;

import control.PresenteController;
import control.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        Stage close = (Stage) cancelarPresente.getScene().getWindow();
        close.close();
        Telas telas = new Telas();
        telas.cancelAndReturn();
    }

    @FXML
    void saveButton(ActionEvent event) {
        boolean sucesso;

        try {
            PresenteController presenteController = new PresenteController();
            sucesso = presenteController.cadastrarPresente(categoriaField.getText(), descricaoField.getText(), precoField.getText());
            if(sucesso == true) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Informações salvas com sucesso!");
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Não foi possível salvar as informações!");
            }

        } catch (Exception ex) {
            System.out.println("Ocorreu um erro na execução do sistema.");
        }

    }

}
