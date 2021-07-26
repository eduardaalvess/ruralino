package GUI.Controllers;

import Dados.ConnectionFactory;
import Dados.DAO.AmigosDAO;
import Dados.DAO.GrupoDAO;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class AdicaoDeAmigoController implements Initializable {

    private Connection connection;

    @FXML
    private ComboBox<String> selecioneGrupo;
    ObservableList<String> Grupos;

    @FXML
    private ListView<String> todosAmigosList;
    ObservableList<String> Nomes;

    @FXML
    private ListView<String> amigosSelecionadosList;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Grupos = FXCollections.observableArrayList();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
        GrupoDAO.getGrupos(connection, Grupos);
        selecioneGrupo.setItems(Grupos);

        Nomes = FXCollections.observableArrayList();
        AmigosDAO.getNomes(connection, Nomes);
        todosAmigosList.setItems(Nomes);
    }
}

