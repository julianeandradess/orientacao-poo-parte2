package academy.dev.jdbc.repository;

import academy.dev.jdbc.conn.ConnectionFactory;
import academy.dev.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2

public class ProducerRepository {
    public static void save(Producer producer){
        //quando queremos alterar algo no banco usamos o statement
        //usamos o log no lugar do sout

        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement()){
            int rownsAffected = stmt.executeUpdate(sql);//inserir
            log.info("Inserted producer '{}' in the database, rowns affected '{}'", producer.getName(), rownsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id){
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement()){
            int rownsAffected = stmt.executeUpdate(sql);//inserir
            log.info("Deleted producer '{}' from the database, rowns affected '{}'", id, rownsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public static void update(Producer producer){
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement()){
            int rownsAffected = stmt.executeUpdate(sql);//inserir
            log.info("Updated producer '{}', rowns affected '{}'", producer.getId(), rownsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    /*public static List<Producer> findAll(){
        log.info("Finding all Producers");
        String sql = "SELECT id, name FROM anime_store.producer;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                var id = rs.getInt("id");
                var name = rs.getString("name");
                Producer producer = Producer.builder().id(id).name(name).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", e);
        }
    }*/

    //maneira mais pratica:
    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding by Name Producers");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder().id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
        return producers;
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer MetaData");
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Colums count '{}' ", columnCount);
            for (int i = 1; i <= columnCount ; i++) {
                log.info("Table name '{}' ", rsMetaData.getTableName(i));
                log.info("Column name '{}' ", rsMetaData.getColumnName(i));
                log.info("Column size '{}' ", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}' ", rsMetaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver MetaData");
        try (Connection conn = ConnectionFactory.getConecction()){
            DatabaseMetaData dbmetaData = conn.getMetaData();
            if (dbmetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                log.info("Supports TYPE_FORWARD_ONLY");
                if (dbmetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
            if (dbmetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbmetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
            if (dbmetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (dbmetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
        }catch (SQLException e){
            log.error("Error while trying to finding all producers.", e);
        }

    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            log.info("Last row '{}' ", rs.last()); // vai pra ultima linha
            log.info("Row number '{}' ", rs.getRow());

            log.info("Last row '{}' ", rs.first()); // vai pra primeira linha
            log.info("Row number '{}' ", rs.getRow()); // numero da ultima linha

            log.info("Row absolute '{}' ", rs.absolute(2));// ir para uma linha especifica
            log.info("Row number '{}' ", rs.getRow());

            log.info("Row relative '{}' ", rs.relative(-1)); // digamos que quer voltar 1 linha
            log.info("Row number '{}' ", rs.getRow());

            log.info("is last? '{}' ", rs.isLast()); // verifica se é a ultima
            log.info("Row number '{}' ", rs.getRow());

            log.info("is first '{}' ", rs.isFirst());
            log.info("Row number '{}' ", rs.getRow());

            log.info("is before '{}' ", rs.isBeforeFirst());
            log.info("Row number '{}' ", rs.getRow());
            log.info("----");

            //ir de baixo pra cima
            log.info("Last '{}' ", rs.last());
            while (rs.previous()){
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
    }
    //sempre que quiser voltar ao estado normal use: rs.cancelRowUpdates
    //só podendo ser usado antes do RowUpdate
    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding by Name Producers");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase()); //atualiza o nome para que possamos colocar em upper
                //rs.cancelRowUpdates();
                rs.updateRow(); //para que atualize e mostre o que pediu atualizado
                Producer producer = Producer
                        .builder().id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
        return producers;
    }

    //caso queira diminuir o codigo, reveja a aula, 267
    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding by Name Producers");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.next()){
                rs.moveToInsertRow();//mover o objeto para uma linha temporaria para inserir
                rs.updateString("name", name); //atualiza
                rs.insertRow(); //inserir
                rs.beforeFirst();
                rs.next();
                Producer producer = Producer
                        .builder().id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding by Name Producers");
        String sql = "SELECT * FROM anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        try (Connection conn = ConnectionFactory.getConecction();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
             log.info("Deleting '{}' ", rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
    }
//prepared statement pré compila o sql
    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding by Name Producers");
        List<Producer> producers = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory.getConecction();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Producer producer = Producer
                        .builder().id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
        return producers;
    }
    //metodo de fora que complementa dentro
    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    //usado para chamar a funções ou stored Procedures
    public static List<Producer> findByNameCallableStatement(String name) {
        log.info("Finding by Name Producers");
        List<Producer> producers = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory.getConecction();
             PreparedStatement ps = callableStatementFindByName(conn, name);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Producer producer = Producer
                        .builder().id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producer ", e);
        }
        return producers;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, String.format("%%%s%%", name));
        return cs;
    }

    public static void updatePreparedStatement(Producer producer){
        try (Connection conn = ConnectionFactory.getConecction();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)){
            int rownsAffected = ps.executeUpdate();//inserir
            log.info("Updated producer '{}', rowns affected '{}'", producer.getId(), rownsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }
    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }
    /* metodo basico de prepared statement
    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }*/
}
