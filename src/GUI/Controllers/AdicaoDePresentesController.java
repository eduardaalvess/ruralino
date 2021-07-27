package GUI.Controllers;

import Model.Amigo;
import Model.Presente;
import Negocio.Fachada;
import Negocio.Negocio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class AdicaoDePresentesController implements Initializable {

    Fachada f = Fachada.getInstance();
    Negocio n = Negocio.getInstance();

    @FXML
    private ComboBox<Amigo> selecioneParticipante;
    ObservableList<Amigo> amigoObservableList = FXCollections.observableList(f.listAmigos());

    @FXML
    private ListView<Presente> todosPresentesList;
    ObservableList<Presente> presenteObservableList = FXCollections.observableList(f.listPresentes());

    @FXML
    private Button salvarAdicionePresente;

    @FXML
    private Button cancelar;

    @FXML
    private Button addPresente;

    @FXML
    private Button delPresente;

    @FXML
    private ListView<Presente> presentesEscolhidosList;
    ObservableList<Presente> presentesEscolhidosObservableList;

    @FXML
    void adicionarPresente(ActionEvent event) {

        Presente p = todosPresentesList.getSelectionModel().getSelectedItem();
        Amigo a = selecioneParticipante.getSelectionModel().getSelectedItem();
        f.addPresenteAoAmigo(p, a);

    }

    @FXML
    void deletarPresente(ActionEvent event) {

        Presente p = todosPresentesList.getSelectionModel().getSelectedItem();
        Amigo a = selecioneParticipante.getSelectionModel().getSelectedItem();
        f.rmvPresenteDoAmigo(p, a);

    }

    @FXML
    void salvarAdicionarPresente(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("blablabla");
        alert.setContentText("Informações salvas com sucesso!");
    }

    @FXML
    void selecionarParticipante(ActionEvent event) {
        selecioneParticipante.setItems(amigoObservableList);
        atualizar();
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
        cancelar.show();

    }

    public void atualizar() {
        selecioneParticipante.setItems(amigoObservableList);
        todosPresentesList.setItems(presenteObservableList);
        presentesEscolhidosList.setItems(presentesEscolhidosObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizar();
    }
}

