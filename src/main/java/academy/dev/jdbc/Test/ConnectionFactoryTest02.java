package academy.dev.jdbc.Test;

import academy.dev.jdbc.dominio.Producer;
import academy.dev.jdbc.repository.ProducerRepositoryPart2;
import academy.dev.jdbc.repository.ProducerRepositoryRowSet;
import academy.dev.jdbc.service.ProducerServiceParte2;
import academy.dev.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        //Producer producer = Producer.builder().id(1).name("MAD-HOUSE").build();
        //ProducerRepositoryRowSet.updateCachedRowSet(producer);
        //log.info("---------");
        //List<Producer> producers = ProducerRepositoryRowSet.findByNameJdbcRowSet("");
        //log.info(producers);

        Producer producer1 = Producer.builder().id(1).name("Animation").build();
        Producer producer2 = Producer.builder().id(1).name("Fox").build();
        Producer producer3 = Producer.builder().id(1).name("Studio Glibi").build();
        ProducerServiceParte2.saveTransaction(List.of(producer1, producer2, producer3));

    }
}
