package dbConfig;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConfig {
    private static Connection connection;

    public static Connection open() throws NamingException, SQLException {
        InitialContext initialContext = new InitialContext();
        DataSource context = (DataSource) initialContext.lookup("java:/comp/env/orient");
        return connection = context.getConnection();
    }

    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
