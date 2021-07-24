package GUI.Controllers;

import App.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InicioController{

    @FXML
    public BorderPane inicioPane;

    @FXML
    private Button sairButton;

    @FXML
    void amigosScene(ActionEvent event) {

        Scenes object = new Scenes();
        Pane view = object.getPage("cadastroAmigo");
        inicioPane.setCenter(view);

    }

    @FXML
    void gruposScene(ActionEvent event) {

        Scenes object = new Scenes();
        Pane view = object.getPage("cadastroGrupos");
        inicioPane.setCenter(view);

    }

    @FXML
    void presentesScene(ActionEvent event) {

        Scenes object = new Scenes();
        Pane view = object.getPage("cadastroPresentes");
        inicioPane.setCenter(view);

    }

    @FXML
    void sairSistema(ActionEvent event) {

        Stage close = (Stage) sairButton.getScene().getWindow();
        close.close();

    }

    @FXML
    void sorteioScene(ActionEvent event) {

        Scenes object = new Scenes();
        Pane view = object.getPage("sorteio");
        inicioPane.setCenter(view);

    }





}
