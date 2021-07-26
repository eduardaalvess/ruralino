package Dados.DAO;

import Dados.ConnectionFactory;
import Model.Amigo;
import com.mysql.cj.exceptions.ConnectionIsClosedException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmigosDAO implements InterfaceAmigosDAO {

    private Connection con;
    private static AmigosDAO instance;
    private List<Amigo> listaAmigos;

    public AmigosDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        con = connectionFactory.getConnection();

        listaAmigos = new ArrayList<Amigo>();

    }

    public static AmigosDAO getInstance() {
        if(instance == null) {
            instance = new AmigosDAO();
        }
        return instance;
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

    /**

    public List<Amigo> amigoList() {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Amigo> amg = new ArrayList<Amigo>();

        try{

        statement = con.prepareStatement("SELECT nome FROM amigosecreto.amigos");
        resultSet = statement.executeQuery();
        
        while(resultSet.next()) {
            Amigo amigo = new Amigo();
            amigo.setNome(resultSet.getString("nome"));
            
            amg.add(amigo);
        }
    } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }

        return amg;

    }

     **/



    public static void getNomes(Connection connection, ObservableList<String> Nomes) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT nome FROM amigosecreto.amigos"
            );

            Amigo a = new Amigo();

            while (resultSet.next()) {
                Nomes.add(new String(resultSet.getString("nome")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            sqlException.getCause();
        }

    }


    @Override
    public List<Amigo> listAmigos() {
       return listaAmigos;
    }
}
