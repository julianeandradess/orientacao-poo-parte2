package Lambdas.Test;
import Lambdas.Dominio.Anime;
import Lambdas.Service.AnimeComparators;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

//Reference to a constructor
//Supplier: interface funcional, ela não recebe nenhum argumento e retorna um tipo T: Gets a result - Returns: a result
//não tem nenhum argumento () mas retorna um anime, por ex.
public class MethodReferenceTes04 {
    public static void main(String[] args) {
        //AnimeComparators animeComparators = new AnimeComparators();
        //criar um anime atraves do supplier
        //Supplier<AnimeComparators> newAnimeComparators = () -> new AnimeComparators();
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new; //não é nessa linha que o obj está sendo criado
        AnimeComparators animeComparators = newAnimeComparators.get(); //ai sim é criado
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 6), new Anime("One Piece", 900), new Anime("Naruto", 500)));
        animeList.sort(animeComparators::compareByEpisodiosNonStatic);
        System.out.println(animeList);
        System.out.println("-------------");

        //caso fossemos criar um supplier com uma classe que tem um construtor, não rola pq nao tem construtor em parametros
        //precisamos definir algo que irá receber 2 argumentos diferentes e vai retornar um terceiro argumento
        BiFunction<String, Integer, Anime> animeBiFunction = (titulo, episodios) -> new Anime(titulo, episodios); //via lambda
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new; //mesma coisa do de cima
        System.out.println(animeBiFunction2.apply("One Piece", 976)); // o apply se encarrega de criar esse novo anime
        System.out.println(animeBiFunction2.apply("Super", 2));
    }
}
