package GUI.Controllers;

import Model.Amigo;
import Model.Grupo;

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

import java.util.ResourceBundle;

public class AdicaoDeAmigoController implements Initializable {

    Fachada f = Fachada.getInstance();
    Negocio n = Negocio.getInstance();

    @FXML
    private ComboBox<Grupo> selecioneGrupo;
    ObservableList<Grupo> grupoObservableList = FXCollections.observableArrayList(f.listGrupos());

    @FXML
    private ListView<Amigo> todosAmigosList;
    ObservableList<Amigo> amigoObservableList = FXCollections.observableArrayList(f.listAmigos());

    @FXML
    private ListView<Amigo> amigosSelecionadosList;
    ObservableList<Amigo> amigosSelecionadosObservableList = FXCollections.observableArrayList();

    @FXML
    private Button addAmigo;

    @FXML
    private Button delAmigo;

    @FXML
    private Button salvarAdicionarAmigo;

    @FXML
    private Button cancelar;


    @FXML
    void adicionarAmigo(ActionEvent event) {

        Amigo a = todosAmigosList.getSelectionModel().getSelectedItem();
        Grupo g = selecioneGrupo.getSelectionModel().getSelectedItem();

        if(selecioneGrupo != null && todosAmigosList != null) {

            f.addAmigoAoGrupo(a, g);
            atualizar();
        }

    }

    @FXML
    void deletarAmigo(ActionEvent event) {

        Amigo a = todosAmigosList.getSelectionModel().getSelectedItem();
        Grupo g = selecioneGrupo.getSelectionModel().getSelectedItem();
        f.rmvAmigoDoGrupo(g, a);
        atualizar();

    }

    @FXML
    void salvarAdicaoDeAmigo(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Amigo(s) adicionado(s)");
            alert.setContentText("Informações salvas com sucesso!");
    }

    @FXML
    void selecionarGrupo(ActionEvent event) {
        selecioneGrupo.setItems(grupoObservableList);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizar();
    }

    public void atualizar() {

        selecioneGrupo.setItems(grupoObservableList);
        todosAmigosList.setItems(amigoObservableList);

        amigosSelecionadosObservableList = FXCollections.observableArrayList();
        amigosSelecionadosList.setItems((n.amigosEmGrupo(selecioneGrupo.getSelectionModel().getSelectedItem())));
    }
}

