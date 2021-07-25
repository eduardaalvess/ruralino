package Dados.DAO;

import Dados.ConnectionFactory;
import Model.Grupo;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO implements InterfaceGrupoDAO {

    private Connection connection;
    private static GrupoDAO instance;
    private List<Grupo> listaGrupo;

    public GrupoDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
        listaGrupo = new ArrayList<Grupo>();

    }

    public static GrupoDAO getInstance() {
        if (instance == null) {
            instance = new GrupoDAO();
        }

        return instance;
    }

    public boolean create(String nome, LocalDate data) {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO grupo (nome, data) VALUES (?,?)");

            statement.setString(1, nome);
            statement.setDate(2, Date.valueOf(data));

            statement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Informações salvas com sucesso!");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/confirmacao-icon.png"))));
            image.setFitHeight(48);
            image.setFitWidth(48);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            sqlException.getCause();

        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

        return false;

    }

    public static void getGrupos(Connection connection, ObservableList<String> Grupos) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT nome FROM amigosecreto.grupo"
            );
            while (resultSet.next()) {
                Grupos.add(
                        new String(
                                resultSet.getString("nome")
                        )
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            sqlException.getCause();
        }

    }


    @Override
    public List<Grupo> listGrupo() {
        return listaGrupo;
    }
}
