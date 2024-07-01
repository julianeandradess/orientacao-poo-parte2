package academy.dev.jdbc.repository;

import academy.dev.jdbc.conn.ConnectionFactory;
import academy.dev.jdbc.dominio.Producer;
import academy.dev.jdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    //para pegar os dados no PreparedStatement usamos o next e aqui tbm, trocando somente as variaveis
    //JdbcRowSet é diferente das outras quatro implementações de RowSet
    //porque está sempre conectado ao banco de dados e por isso é mais semelhante ao objeto ResultSet.
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql =  "Select * from anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql); //montamos primeiro o sql
            jrs.setString(1, String.format("%%%s%%", name)); //trocar o ? por um nome
            jrs.execute();//para executar o sql, só serve para buscar, não serve para inserir dados
            while (jrs.next()){
                Producer producer = Producer.builder().id(jrs.getInt("id"))
                        .name(jrs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    //atualizar um campo: o que não fazer
   /* public static void updateJdbcRowSet(Producer producer){
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.setCommand(sql);
            jrs.setString(1, producer.getName());
            jrs.setInt(2, producer.getId());
            jrs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "Select * from anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //diferente do Jdbc rowset é conectado e o cached rowset não é conectado, ele pega os dados e desconecta
    //trabalhamos na memoria. Todas as alteraçoes que fizer com esse metodo terá que mandar de novo para o banco
    //nesse caso o updateRow não é suficiente para enviar
    //por conta do erro que pode ser causado pelo cached, em questão do autocommit estar como true
    //precisamos "ajeitar", colocando uma conexão dentro dele tb e mudando o autommit pra false
    public static void updateCachedRowSet(Producer producer) {
        String sql = "Select * from producer WHERE (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
        Connection connection = ConnectionFactory.getConecction()) {
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();//você precisa aceitar
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
