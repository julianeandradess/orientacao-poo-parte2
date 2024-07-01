package academy.dev.crud.repository;

import academy.dev.crud.conn.ConnectionFactory2;
import academy.dev.crud.dominio.Anime;
import academy.dev.crud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {
    public static List<Anime> findByName(String name) {
        log.info("Finding by Name Producers '{}'", name);
        List<Anime> animes = new ArrayList<>(); // criando fora para que possamos retornar
        try (Connection conn = ConnectionFactory2.getConecction();
             PreparedStatement ps = createPrepareStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder().name(rs.getString("producer_name"))
                        .id(rs.getInt("producer_id"))
                        .build();

                Anime anime = Anime
                        .builder().id(rs.getInt("id"))
                        .nome(rs.getString("nome"))
                        .episodios(rs.getInt("episodios"))
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all animes ", e);
        }
        return animes;
    }

    //metodo de fora que complementa dentro
    private static PreparedStatement createPrepareStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = """
                SELECT a.id, a.nome, a.episodios, a.producer_id, p.name as 'producer_name' FROM anime_store.anime a inner join
                anime_store.producer p on a.producer_id = p.id
                where a.nome like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static void delete(int id) {
        try (Connection conn = ConnectionFactory2.getConecction();
             PreparedStatement ps = createPrepareStatementDelete(conn, id)) {
            ps.execute();//inserir
            log.info("Deleted Anime '{}' from the database", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete Anime '{}'", id, e);
        }
    }

    private static PreparedStatement createPrepareStatementDelete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(Anime anime) {
        log.info("Salving Producers '{}'", anime);
        try (Connection conn = ConnectionFactory2.getConecction();
             PreparedStatement ps = createPreparedStatementSave(conn, anime)) {
            ps.execute();//inserir
        } catch (SQLException e) {
            log.error("Error while trying to update Anime '{}'", anime.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection conn, Anime anime) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`anime` (`nome`, `episodios`, `producer_id`) VALUES (?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getNome());
        ps.setInt(2, anime.getEpisodios());
        ps.setInt(3, anime.getProducer().getId());
        return ps;
    }

    public static Optional<Anime> findById(Integer id) {
        log.info("Finding by Id Producers '{}'", id);
        try (Connection conn = ConnectionFactory2.getConecction();
             PreparedStatement ps = createPrepareStatementFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder().name(rs.getString("producer_name"))
                    .id(rs.getInt("producer_id"))
                    .build();
            Anime anime = Anime.builder().id(rs.getInt("id")).nome(rs.getString("nome"))
                    .episodios(rs.getInt("episodios")).producer(producer).build();
            return Optional.of(anime);
        } catch (SQLException e) {
            log.error("Error while trying to find all Anime ", e);
        }
        return Optional.empty();
    }

    private static PreparedStatement createPrepareStatementFindById(Connection conn, Integer id) throws SQLException {
        String sql = """
                SELECT a.id, a.nome, a.episodios, a.producer_id, p.name as 'producer_name' FROM anime_store.anime a inner join
                anime_store.producer p on a.producer_id = p.id
                where a.id = ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void update(Anime anime) {
        log.info("Upadating Anime '{}'", anime);
        try (Connection conn = ConnectionFactory2.getConecction();
             PreparedStatement ps = createPreparedStatementUpdate(conn, anime)) {
            ps.executeUpdate();//inserir
        } catch (SQLException e) {
            log.error("Error while trying to update Anime '{}'", anime.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection conn, Anime anime) throws SQLException {
        String sql = "UPDATE `anime_store`.`anime` SET `nome` = ?,`episodios` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getNome());
        ps.setInt(2, anime.getEpisodios());
        ps.setInt(3, anime.getId());
        return ps;
    }
}


