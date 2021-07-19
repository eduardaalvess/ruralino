package dados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/ruralino";
    private static final String DBUSER = "root";
    private static final String DBPASS = "hoc23357";

    public static Connection getConnection()  {

        try
        {
            Class.forName(DRIVER);

            return DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new RuntimeException("Erro na conexão", ex);
        }

    }

    public static void closeConnection(Connection conEx)
    {

        {
            try {
                if(conEx!=null)
                    conEx.close();

            } catch (SQLException ex)
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection conEx, PreparedStatement pst)
    {
        closeConnection(conEx);

        try
        {
            if(pst!= null)
            {
                pst.close();
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection conEx, PreparedStatement pst, ResultSet rs)
    {
        closeConnection(conEx, pst);

        try
        {
            if(rs!= null)
            {
                rs.close();
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
