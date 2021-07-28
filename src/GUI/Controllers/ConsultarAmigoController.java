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
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ConsultarAmigoController implements Initializable {

    private Connection connection;

    @FXML
    private ComboBox<String> selecioneGrupo;
    ObservableList<String> Grupos;

    @FXML
    private PasswordField senhaParticipante;

    @FXML
    private Button consulteAmigoButton;

    @FXML
        private ComboBox<String> selecioneParticipante;
    ObservableList<String> Nomes;

    @FXML
    private Button cancelar;

    @FXML
    void consultarAmigoSecreto(ActionEvent event) {

    }

    @FXML
    void selecionarGrupo(ActionEvent event) {

    }

    @FXML
    void selecionarParticipante(ActionEvent event) {

    }

    @FXML
    void voltarInicio(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) cancelar.getScene().getWindow();
        closeStage.close();

        Stage cancelar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/View/inicio.fxml"));
        cancelar.setTitle("Ruralino E Seus Amigos");
        cancelar.setScene(new Scene(root, 700, 500));
        cancelar.setResizable(false);
        cancelar.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image("/Imagens/wrapped-gift.png");
        cancelar.getIcons().add(image);
        cancelar.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

