package DAO;

import dados.ConnectionFactory;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PresenteDAO {

    private Connection connection;

    public PresenteDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();
    }

    public boolean create(String categoria, String descricao, String preco) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement("INSERT INTO presentes (categoria, descricao, preco) VALUES (?,?,?)");
            stmt.setString(1, categoria);
            stmt.setString(2, descricao);
            stmt.setString(3, preco);

            stmt.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Informações salvas com sucesso! Clique em OK e volte para fazer login");
            alert.showAndWait();

        } catch (SQLException ex) {

            System.out.println("Falha na conexão");

        }
        finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

        return false;
    }

}
