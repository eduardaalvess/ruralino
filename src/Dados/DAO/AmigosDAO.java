package Dados.DAO;

import Dados.ConnectionFactory;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.*;

public class AmigosDAO {

    private Connection con;

    public AmigosDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        con = connectionFactory.getConnection();
    }

    public boolean create(String nome, String apelido, String senha) {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("INSERT INTO amigos (nome, apelido, senha) VALUES (?,?,?)");
            statement.setString(1, nome);
            statement.setString(2, apelido);
            statement.setString(3, senha);

            statement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Informações salvas com sucesso!");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/confirmacao-icon.png"))));
            image.setFitHeight(48);
            image.setFitWidth(48);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();

        } catch (Exception exception)  {

            exception.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }

        return false;
    }

}
