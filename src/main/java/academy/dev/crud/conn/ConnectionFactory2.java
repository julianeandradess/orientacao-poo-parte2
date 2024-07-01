package academy.dev.crud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//ctrl alt o = remove os imports não utilizados

public class ConnectionFactory2 {
    public static Connection getConecction() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }
}
