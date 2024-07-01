package academy.dev.jdbc.service;

import academy.dev.jdbc.dominio.Producer;
import academy.dev.jdbc.repository.ProducerRepositoryPart2;

import java.util.List;

public class ProducerServiceParte2 {
    public static void saveTransaction(List<Producer> producers){
        ProducerRepositoryPart2.saveTransaction(producers);
    }
}
