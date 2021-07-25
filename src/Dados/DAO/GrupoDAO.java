package Dados.DAO;

import Dados.ConnectionFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GrupoDAO {

    private Connection connection;

    public GrupoDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();

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
}
