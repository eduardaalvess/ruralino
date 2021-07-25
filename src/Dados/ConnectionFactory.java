package Dados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    Connection databaseLink;

    public Connection getConnection()  {

        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost/";
        String dbuser = "root";
        String dbpass = "hoc23357";
        String dbname = "amigosecreto";
        String url = dburl + dbname;

        try
        {
            Class.forName(driver);

            databaseLink = DriverManager.getConnection(url, dbuser, dbpass);

        } catch (Exception ex)
        {
            ex.printStackTrace();
            ex.getCause();
        }

        return databaseLink;
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
