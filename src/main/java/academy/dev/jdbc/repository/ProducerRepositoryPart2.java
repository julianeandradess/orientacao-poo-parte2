package academy.dev.jdbc.repository;

import academy.dev.jdbc.conn.ConnectionFactory;
import academy.dev.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.List;

@Log4j2

public class ProducerRepositoryPart2 {
    //Transation, é basicamente em nivel atomico, ou executa um ou não executa nada
    //mandaremos varios dados que queremos que sejam todos salvos ou não sejam inseridos no banco
    //caso 1 dê problemas
    //autocommit = não queremos que o banco dê conta de salvar tudo que estamos mandando, somente o que queremos
    //para que se tiver um erro, não salve errado

    //apesar de parecer salvo, no banco não estará, nós passamos pra ele não se autocommitar consequentemente, não salvar
    //logo, após toda nossa operação estando feita, ai sim, poderá commitar.
    //se estivessemos em um metodo maior, precisariamos voltar o commit para true
    public static void saveTransaction(List<Producer> producers){
        try (Connection conn = ConnectionFactory.getConecction()){
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            conn.commit(); //aval para commitar
            //conn.setAutoCommit(true);
        } catch (SQLException e) {
            log.error("Error while trying to save producer '{}'", producers, e);
        }
    }
    //if abaixo: tratando casos excepcioanais, não poderá salvar o erro no banco
    //rollback não pode ser encaixado dentro do catch, pois a conexão já está fechada, quando chamado direto no metodo
    //não irá salvar nenhum pois um teve erro
    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouRollBack = false; //se der algum problema, volte

        for (Producer p : producers){
            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                ps.setString(1, p.getName());
                if (p.getName().equals("Fox")) throw new SQLException("Can't save Fox"); //é o que estamos tratando
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
                shouRollBack = true;
            }
        }
        if (shouRollBack) {
            log.warn("Transaction is going be rollback");
            conn.rollback();
        }
    }
}
