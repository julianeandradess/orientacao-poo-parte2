package academy.dev.jdbc.service;

import academy.dev.jdbc.dominio.Producer;
import academy.dev.jdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id){
        requeriValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        requeriValidId(producer.getId());
        ProducerRepository.update(producer);
    }
    public static void updatePreparedStatement(Producer producer){
        requeriValidId(producer.getId());
        ProducerRepository.updatePreparedStatement(producer);
    }

    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name){
        return ProducerRepository.findByName(name);
    }

    public static void showProducerMetaData(){
        ProducerRepository.showProducerMetaData();
    }

    public static void showDriverMetaData(){
        ProducerRepository.showDriverMetaData();
    }

    public static void showTypeScrollWorking(){
        ProducerRepository.showTypeScrollWorking();
    }

    private static void requeriValidId(Integer id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Invalid value for id");
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name){
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name){
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }
    public static void findByNameAndDelete(String name){
        ProducerRepository.findByNameAndDelete(name);
    }

    public static List<Producer> findByNamePreparedStatement(String name){
        return ProducerRepository.findByNamePreparedStatement(name);
    }

    public static List<Producer> findByNameCallableStatement(String name){
        return ProducerRepository.findByNameCallableStatement(name);
    }

}
