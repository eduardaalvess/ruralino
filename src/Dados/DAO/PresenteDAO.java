package Dados.DAO;

import Dados.ConnectionFactory;
import Model.Presente;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresenteDAO implements InterfacePresenteDAO {

    private Connection connection;
    private static PresenteDAO instance;
    private List<Presente> listaPresentes;

    public PresenteDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
        listaPresentes = new ArrayList<Presente>();

    }

    public static PresenteDAO getInstance() {
        if(instance == null) {
            instance = new PresenteDAO();
        }

        return instance;
    }

    public boolean create(String categoria, String descricao, String preco) {

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("INSERT INTO presente (categoria, descricao, preco) VALUES (?,?,?)");

            statement.setString(1, categoria);
            statement.setString(2, descricao);
            statement.setString(3, preco);

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

    public static void getPresentes(Connection connection, ObservableList<String> Nomes) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT descricao FROM amigosecreto.presente"
            );
            while (resultSet.next()) {
                Nomes.add(
                        new String(
                               resultSet.getString("descricao")
                        )
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            sqlException.getCause();
        }

    }

    @Override
    public List<Presente> listPresente() {
        return listaPresentes;
    }
}
