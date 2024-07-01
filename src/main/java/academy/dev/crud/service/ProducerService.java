package academy.dev.crud.service;

import academy.dev.crud.dominio.Producer;
import academy.dev.crud.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void menu(int op){
        switch (op){ //tem como mudar a sintaxe alt+enter
            case 1: findByName(); break;
            case 2: delete(); break;
            case 3: save(); break;
            case 4: update(); break;
            default: throw new IllegalArgumentException("Not a invalid option");
        }
    }

    private static void findByName(){
        System.out.println("Type the name or empty to all");
        String nome = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByName(nome);
        producers.forEach(p-> System.out.printf("[%d] - %s%n", p.getId(), p.getName()));
        /*for (int i = 0; i < producers.size(); i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - %d | %s%n", i, producer.getId(), producer.getName());
        }*/
    }

    // pode deixar assim :if (choice.toLowerCase().startsWith("s")); ou:
    private static void delete(){
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)){
            ProducerRepository.delete(id);
        }
    }

    private static void save(){
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional <Producer> optionalProducer = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (optionalProducer.isEmpty()) {
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDb = optionalProducer.get();
        System.out.println("Producer found " + producerFromDb);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;

        Producer producerToUpdate = Producer.builder().id(producerFromDb.getId()).name(name).build();
        ProducerRepository.update(producerToUpdate);
    }
}
