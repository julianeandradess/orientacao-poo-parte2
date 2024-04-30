package javacore2.Vio.Test.Colecoes.Test;


import javacore2.Vio.Test.Colecoes.Dominio.Consumidor;
import javacore2.Vio.Test.Colecoes.Dominio.Manga;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        //Map, quando um consumidor compra varios mangas.
        Consumidor consumidor1 = new Consumidor("Julia");
        Consumidor consumidor2 = new Consumidor("Benicio");

        Manga manga1 = new Manga(5L, "Berserk", 19.9);
        Manga manga2 = new Manga(1L, "Hellsing Ultimate", 9.5);
        Manga manga3 = new Manga(1L, "Pokemon", 3.2);
        Manga manga4 = new Manga(2L, "Dragon ball z", 2.20);
        Manga manga5 = new Manga(4L, "Attact on titan", 2.99);

        //colocaremos o manga numa lista, como se fosse uma array multidimensional
        List<Manga> mangaConsumidorList1 = List.of(manga1, manga2, manga3);
        List<Manga> mangaConsumidorList2 = List.of( manga4, manga5);
        Map<Consumidor, List<Manga>> consumidorMangaMap = new LinkedHashMap<>();
        consumidorMangaMap.put(consumidor1, mangaConsumidorList1);
        consumidorMangaMap.put(consumidor2, mangaConsumidorList2);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()){
            System.out.println("----"+ entry.getKey().getNome()+ ":"); //vai imprimir o consumidor
            for (Manga manga : entry.getValue()) { //irá imprimir a lista. entry.getValue(); alt+enter
                System.out.println(manga.getNome());
            }

        }
    }
}
