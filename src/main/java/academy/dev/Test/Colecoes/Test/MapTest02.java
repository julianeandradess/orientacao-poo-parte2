package academy.dev.Test.Colecoes.Test;


import academy.dev.Test.Colecoes.Dominio.Consumidor;
import academy.dev.Test.Colecoes.Dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        //Map irá guardar o consumidor e o manga que ele comprou
        Consumidor consumidor1 = new Consumidor("Julia");
        Consumidor consumidor2 = new Consumidor("Benicio");

        Manga manga1 = new Manga(5L, "Berserk", 19.9);
        Manga manga2 = new Manga(1L, "Hellsing Ultimate", 9.5);
        Manga manga3 = new Manga(1L, "Pokemon", 3.2);
        Manga manga4 = new Manga(2L, "Dragon ball z", 2.20);
        Manga manga5 = new Manga(4L, "Attact on titan", 2.99);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>(); //sem ordem de inserção
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga2);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()){
            System.out.println(entry.getKey().getNome()+ " : " + entry.getValue().getNome()); //assim fica mais completo
        }
    }
}
