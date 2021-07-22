package Controller;


import App.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CadastroGrupoController {

    @FXML
    private Button salvarCadastroGrupo;

    @FXML
    private DatePicker dataSorteio;

    @FXML
    private TextField cadastroNomeGrupo;

    @FXML
    private Button addAmigosButton;

    @FXML
    void adicionarAmigos(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) addAmigosButton.getScene().getWindow();
        closeStage.close();

        Stage addAmigos = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adicaoDeAmigo.fxml"));
        addAmigos.setTitle("Ruralino E Seus Amigos");
        addAmigos.setScene(new Scene(root, 700, 500));
        addAmigos.setResizable(false);
        addAmigos.initStyle(StageStyle.TRANSPARENT);
        addAmigos.show();

    }

    @FXML
    void salvarCadastroDoGrupo(ActionEvent event) {

    }


}

