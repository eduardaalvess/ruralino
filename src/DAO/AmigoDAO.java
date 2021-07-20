package DAO;

import dados.ConnectionFactory;
import javafx.scene.control.Alert;
import model.Amigo;

import java.sql.*;

public class AmigoDAO {

    private Connection connect;

    public AmigoDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connect = connectionFactory.getConnection();
    }

    public boolean create(String nomeCompleto, String apelido, String senha) {

        PreparedStatement statement = null;

        try {
                statement = connect.prepareStatement("INSERT INTO amigos (name, apelido, senha) VALUES (?,?,?)");
                statement.setString(1, nomeCompleto);
                statement.setString(2, apelido);
                statement.setString(3, senha);

                statement.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Informações salvas com sucesso!");
                alert.showAndWait();

        } catch (Exception exception)  {

            exception.printStackTrace();

            // Alert alert = new Alert(Alert.AlertType.ERROR);
            // alert.setContentText("Não foi possivel atender a solicitação");

        } finally {
            ConnectionFactory.closeConnection(connect, statement);
        }

        return false;
    }

}
