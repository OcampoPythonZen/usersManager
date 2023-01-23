package edo.mex.gob.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Connector {

    private static final Logger logger = Logger.getLogger(Connector.class.getName());
    private static final String url = "jdbc:postgresql://localhost:5432/users_manager_db?socketTimeout=30";
    private static final String username = "rappipay";
    private static final String password = "secret";
    private final Connection connection;

    public Connector() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        logger.info("USER_MANAGERS --Just Connector --Successfully Database Connection");
    }

    public ResultSet resultSetConn(String query) throws SQLException {
        Statement stm = connection.createStatement();
        logger.info(String.format("USER_MANAGERS --Query{'%s'} --Successfully Database Connection", query));
        return stm.executeQuery(query);
    }

    public void insertIntoTable(String query) throws SQLException {
        Statement stm = connection.createStatement();
        int rs = stm.executeUpdate(query);
        logger.info(String.format("USER_MANAGERS --Query{'%s'} --insertIntoTable --Inserted into db", query));
    }

    public void closeConnection() throws SQLException {
        connection.close();
        logger.info("USER_MANAGERS --closeConnection --Connection closed");
    }
}
