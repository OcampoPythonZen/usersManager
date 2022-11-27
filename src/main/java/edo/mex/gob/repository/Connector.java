package edo.mex.gob.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class Connector {

    Logger logger = Logger.getLogger(Connector.class.getName());
    String url = "jdbc:postgresql://localhost:5432/users_manager_db?socketTimeout=30";
    String username = "rappipay";
    String password = "secret";

    public Connector() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        logger.info("USER_MANAGERS --Just Connector --Successfully Database Connection");
        connection.close();
    }

    public Connector(List<String> queries) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        logger.info("USER_MANAGERS --Connector with these list of queries --Successfully Database Connection");
        Statement stm = connection.createStatement();
        queries.forEach(
                (q) -> {
                    try {
                        stm.execute(q);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
        connection.close();
    }

    public ResultSet resultSetConn(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        logger.info("USER_MANAGERS --Connector with this one query --Successfully Database Connection");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(query);
        connection.close();
        return rs;
    }

    public Connector insertIntoTable(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(query);
        logger.info("USER_MANAGERS --insertIntoTable --Inserted into db");
        connection.close();
        return null;
    }
}
