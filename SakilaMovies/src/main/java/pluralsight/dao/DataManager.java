package pluralsight.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataManager {
    private static final BasicDataSource dataSource = new BasicDataSource();

    public static Connection getConnection() throws SQLException{
        try {
            dataSource.setUrl(System.getenv("SAKILA_DB"));
            dataSource.setUsername(System.getenv("DB_USER"));
            dataSource.setPassword(System.getenv("DB_PASSWORD"));
            return dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

}
