package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String ERS_URL = System.getenv("AWS_RDS_URL");
    private static final String ERS_UN = System.getenv("AWS_RDS_USER");
    private static final String ERS_PW = System.getenv("AWS_RDS_PASS");

    private static Connection conn;

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(ERS_URL, ERS_UN, ERS_PW);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
