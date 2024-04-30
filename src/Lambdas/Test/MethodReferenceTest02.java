package Lambdas.Test;


//Reference to an instance method of a particular object
//quando a classe não é static, ela precisa de um objeto
//estamos chamando a lambda diretamente pelo objeto e não pelo nome da classe, atraves do methodReference

import Lambdas.Dominio.Anime;
import Lambdas.Service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 6), new Anime("One Piece", 900), new Anime("Naruto", 500)));
        animeList.sort(animeComparators::compareByEpisodiosNonStatic);
        //animeList.sort((a3, a4) -> animeComparators.compareByEpisodiosNonStatic(a3, a4)); //atraves de uma lambda normal
        System.out.println(animeList);
    }
}
