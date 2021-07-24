package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdicaoDePresentesController {

    @FXML
    private ComboBox<?> selecioneParticipante;

    @FXML
    private ListView<?> todosPresentesList;

    @FXML
    private Button salvarAdicionePresente;

    @FXML
    private Button cancelar;

    @FXML
    private Button addPresente;

    @FXML
    private Button delPresente;

    @FXML
    private ListView<?> presentesEscolhidosList;

    @FXML
    void adicionarPresente(ActionEvent event) {

    }

    @FXML
    void deletarPresente(ActionEvent event) {

    }

    @FXML
    void salvarAdicionarPresente(ActionEvent event) {

    }

    @FXML
    void selecionarParticipante(ActionEvent event) {

    }

    @FXML
    void voltarInicio(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) cancelar.getScene().getWindow();
        closeStage.close();

        Stage cancelar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/FXML/View/inicio.fxml"));
        cancelar.setTitle("Ruralino E Seus Amigos");
        cancelar.setScene(new Scene(root, 700, 500));
        cancelar.setResizable(false);
        cancelar.initStyle(StageStyle.TRANSPARENT);
        cancelar.show();

    }

}

