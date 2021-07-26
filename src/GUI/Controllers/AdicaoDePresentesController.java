package GUI.Controllers;

import Dados.ConnectionFactory;
import Dados.DAO.AmigosDAO;
import Dados.DAO.PresenteDAO;
import Model.Amigo;
import Model.Presente;
import Negocio.Negocio;
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

public class AdicaoDePresentesController implements Initializable {

    private Connection connection;

    @FXML
    private ComboBox<String> selecioneParticipante;
    ObservableList<String> Nomes;

    @FXML
    private ListView<String> todosPresentesList;
    ObservableList<String> Presentes;

    @FXML
    private Button salvarAdicionePresente;

    @FXML
    private Button cancelar;

    @FXML
    private Button addPresente;

    @FXML
    private Button delPresente;

    @FXML
    private ListView<String> presentesEscolhidosList;

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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/View/inicio.fxml"));
        cancelar.setTitle("Ruralino E Seus Amigos");
        cancelar.setScene(new Scene(root, 700, 500));
        cancelar.setResizable(false);
        cancelar.initStyle(StageStyle.TRANSPARENT);
        cancelar.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Nomes = FXCollections.observableArrayList();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
        AmigosDAO.getNomes(connection, Nomes);
        selecioneParticipante.setItems(Nomes);

        Presentes = FXCollections.observableArrayList();
        PresenteDAO.getPresentes(connection, Presentes);
        todosPresentesList.setItems(Presentes);
    }
}

