package GUI.Controllers;

import Model.Amigo;
import Model.Grupo;
import Negocio.ControladorAmigo;
import Negocio.ControladorGrupo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class AdicaoDeAmigoController {

    @FXML
    private ComboBox<Grupo> selecioneGrupo;

    @FXML
    private ListView<Amigo> todosAmigosList;

    @FXML
    private ListView<Amigo> amigosSelecionadosList;

    @FXML
    private Button addAmigo;

    @FXML
    private Button delAmigo;

    @FXML
    private Button salvarAdicionarAmigo;

    @FXML
    private Button cancelar;

    ControladorAmigo controladorAmigo = ControladorAmigo.getInstance();
    ControladorGrupo controladorGrupo = ControladorGrupo.getInstance();

    private ObservableList<Amigo> observableListTodosAmigos = FXCollections.observableArrayList(controladorAmigo.list());

    private ObservableList<Amigo> observableListSelecionados;

    private ObservableList<Grupo> observableListGrupo = FXCollections.observableArrayList(controladorGrupo.listGrupo());

    @FXML
    void adicionarAmigo(ActionEvent event) {

        Amigo amg = todosAmigosList.getSelectionModel().getSelectedItem();
        Grupo gp = selecioneGrupo.getSelectionModel().getSelectedItem();

    }

    @FXML
    void deletarAmigo(ActionEvent event) {

    }

    @FXML
    void salvarAdicaoDeAmigo(ActionEvent event) {

    }

    @FXML
    void selecionarGrupo(ActionEvent event) {

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

}

