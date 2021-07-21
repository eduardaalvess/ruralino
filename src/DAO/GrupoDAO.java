package DAO;

import dados.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GrupoDAO {

    private Connection connection;

    public GrupoDAO() {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connection = connectionFactory.getConnection();
    }

    public boolean create(String nomeDoGrupo, Date dataSorteio) {

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("INSERT INTO grupos (nomesorteio, datasorteio) VALUES (?,?) ");
            statement.setString(1, nomeDoGrupo);
            statement.setString(2, String.valueOf(dataSorteio));

            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

        return false;
    }
}
