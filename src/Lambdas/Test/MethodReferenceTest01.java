package Lambdas.Test;

import Lambdas.Dominio.Anime;
import Lambdas.Service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//poderiamos ter criado o comparator com classe aninomas porem fizemos por lambda
//sintaxe do compare: (T o1, T o2)
//digamos que queremos organizar os animes por nome:
//Reference to a static method

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 6), new Anime("One Piece", 900), new Anime("Naruto", 500)));
        //Collections.sort(animeList, (a1, a2) -> a1.getTitulo().compareTo(a2.getTitulo()));
        Collections.sort(animeList, AnimeComparators::compareByTitle);
        System.out.println(animeList);

        List<Anime> animeList1 = new ArrayList<>(List.of(new Anime("Berserk", 1200), new Anime("One Piece", 900), new Anime("Naruto", 500)));
        Collections.sort(animeList1, AnimeComparators::compareByEpisodios);
        System.out.println(animeList1);
    }
}
