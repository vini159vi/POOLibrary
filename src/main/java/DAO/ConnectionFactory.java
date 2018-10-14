package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;
    private static ConnectionFactory instance;

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        if(instance == null)
            instance = new ConnectionFactory();
        return instance;
    }

    public Connection getConnection() {

        try {
            if(connection == null) {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                connection = DriverManager.getConnection(
                        "jdbc:hsqldb:hsql://localhost/biblioteca", "SA", "");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao tentar criar conexão!\n" + e);
        }
        finally {
            return connection;
        }
    }
}
