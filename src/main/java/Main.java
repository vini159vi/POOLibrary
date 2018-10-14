import DAO.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory fabrica = ConnectionFactory.getInstance();
        Connection con = fabrica.getConnection();

        String sql = "INSERT INTO TESTE (ID, NAME) VALUES (2, 'THON')";
        PreparedStatement prp = null;
        try {
            prp = con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("bosta" + e);
        }
        try {
            prp.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("merda" + e);
        }
    }
}
