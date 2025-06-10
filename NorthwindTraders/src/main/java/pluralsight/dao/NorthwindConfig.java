package pluralsight.dao;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class NorthwindConfig {
    private static final BasicDataSource dataSource = new BasicDataSource();

    public static Connection getConnection() throws SQLException {
        dataSource.setUrl(System.getenv("DB_URL"));
        dataSource.setUsername(System.getenv("DB_USER"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}