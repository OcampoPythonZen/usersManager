package edo.mex.gob.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    String url = "jdbc:postgresql://localhost:5432/users_manager_db?socketTimeout=30";
    String username = "rappipay";
    String password = "secret";

    public Connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Postgres Connection Success...");
    }
}
