package academy.dev.crud.service;

import academy.dev.crud.dominio.Anime;
import academy.dev.crud.dominio.Producer;
import academy.dev.crud.repository.AnimeRepository;
import academy.dev.crud.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void menu(int op){
        switch (op){ //tem como mudar a sintaxe alt+enter
            case 1: findByName(); break;
            case 2: delete(); break;
            case 3: save(); break;
            case 4: update(); break;
        }
    }

    private static void findByName(){
        System.out.println("Type the name or empty to all");
        String nome = SCANNER.nextLine();
        List<Anime> animes =AnimeRepository.findByName(nome);
        animes.forEach(p-> System.out.printf("[%d] - %s %d %s%n", p.getId(), p.getNome(), p.getEpisodios(), p.getProducer().getName()));
        /*for (int i = 0; i < animes.size(); i++) {
            Anime animes = animes.get(i);
            System.out.printf("[%d] - %d | %s%n", i, animes.getId(), animes.getName());
        }*/
    }

    // pode deixar assim :if (choice.toLowerCase().startsWith("s")); ou:
    private static void delete(){
        System.out.println("Type the id of the animes you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if ("S".equalsIgnoreCase(choice)){
            AnimeRepository.delete(id);
        }
    }

    private static void save(){
        System.out.println("Type the name of the animes");
        String nome = SCANNER.nextLine();

        System.out.println("Type the number of the episodios");
        int episodios = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());
        Anime animes = Anime.builder().episodios(episodios).nome(nome)
                .producer(Producer.builder().id(producerId).build()).build();
        AnimeRepository.save(animes);
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional <Anime> optionalAnime = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (optionalAnime.isEmpty()) {
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDb = optionalAnime.get();
        System.out.println("Anime found " + animeFromDb);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getNome() : name;

        System.out.println("Type the new number of the episodios");
        int episodios = Integer.parseInt(SCANNER.nextLine());
        name = name.isEmpty() ? animeFromDb.getNome() : name;

        Anime producerToUpdate = Anime.builder().id(animeFromDb.getId())
                .nome(name).episodios(episodios).producer(animeFromDb.getProducer()).build();
       AnimeRepository.update(producerToUpdate);
    }
}
