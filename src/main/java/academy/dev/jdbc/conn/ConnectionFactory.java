package academy.dev.jdbc.conn;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //jdbc basicamente é uma maneira que o java fez para tentar padronizar a coneção com algum banco de dados
    //temos o pacote do java.sql = java criou uma interface chamada:
    //Connection, Statement, ResultSet, DriverManager
    public static Connection getConecction() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }

    //também é uma forma de conexão com o banco, java bean
    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";

        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();//pega o objeto
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    public static CachedRowSet getCachedRowSet() throws SQLException {
        //String url = "jdbc:mysql://localhost:3306/anime_store";
        //String username = "root";
        //String password = "root";

        return RowSetProvider.newFactory().createCachedRowSet();//pega o objeto
        //cachedRowSet.setUrl(url);     TIRADO POIS FOI REFATORADO
        // cachedRowSet.setUsername(username);
        //cachedRowSet.setPassword(password);
        //return cachedRowSet;
    }
}
