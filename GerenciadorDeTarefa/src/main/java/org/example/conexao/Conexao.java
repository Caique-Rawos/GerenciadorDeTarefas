package org.example.conexao;

import java.sql.*;

/**
 *
 * @author Caique Rawos.
 */

public class Conexao {
    public Connection getConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:Tarefas.db");
            return connection;
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return null;
        }

    }
}
