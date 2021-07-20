package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PagInicialController {

    @FXML
    private Button pessoasButton;

    @FXML
    private Button gruposButton;

    @FXML
    private Button presentesButton;

    @FXML
    private Button sorteioButton;

    @FXML
    private Button sairButton;

    @FXML
    void closeSystem(ActionEvent event) {
        Stage closeSys = (Stage) sairButton.getScene().getWindow();
        closeSys.close();
    }

    @FXML
    void goToGrupos(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) gruposButton.getScene().getWindow();
        closeStage.close();
        TelasController tela = new TelasController();
        tela.gruposScene();

    }

    @FXML
    void goToPessoas(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) pessoasButton.getScene().getWindow();
        closeStage.close();
        TelasController tela = new TelasController();
        tela.pessoasScene();

    }

    @FXML
    void goToPresentes(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) presentesButton.getScene().getWindow();
        closeStage.close();
        TelasController tela = new TelasController();
        tela.presentesScene();
    }

    @FXML
    void goToSorteio(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) sorteioButton.getScene().getWindow();
        closeStage.close();
        TelasController sTela = new TelasController();
        sTela.sorteioScene();

    }

}

