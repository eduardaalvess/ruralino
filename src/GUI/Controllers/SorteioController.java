package GUI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

public class SorteioController implements Initializable {

    @FXML
    private ComboBox<String> selecioneGrupo;
    ObservableList<String> Grupos;

    @FXML
    private Button sorteioButton;

    @FXML
    private Button consultaAmigoButton;

    @FXML
    void consultarAmigo(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) consultaAmigoButton.getScene().getWindow();
        closeStage.close();

        Stage consulta = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/View/consultarAmigo.fxml"));
        consulta.setTitle("Ruralino E Seus Amigos");
        consulta.setScene(new Scene(root, 700, 500));
        consulta.setResizable(false);
        consulta.initStyle(StageStyle.TRANSPARENT);
        consulta.show();

    }

    @FXML
    void realizarSorteio(ActionEvent event) {

    }

    @FXML
    void selecionarGrupo(ActionEvent event) {

    }

    public void atualizar() {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

