package Lambdas.Service;

import Lambdas.Dominio.Anime;

public class AnimeComparators {
    public static int compareByTitle(Anime a1, Anime a2){
        return a1.getTitulo().compareTo(a2.getTitulo());
    }

    public static int compareByEpisodios(Anime a3, Anime a4){
        return Integer.compare(a3.getEpisodios(), a4.getEpisodios());
    }

    public int compareByEpisodiosNonStatic (Anime a3, Anime a4){
        return Integer.compare(a3.getEpisodios(), a4.getEpisodios());
    }
}
