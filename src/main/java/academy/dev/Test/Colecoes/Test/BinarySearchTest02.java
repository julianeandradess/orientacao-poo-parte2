package academy.dev.Test.Colecoes.Test;

import academy.dev.Test.Colecoes.Dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Berserk",19.9));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5));
        mangas.add(new Manga(1L,"Pokemon",3.2));
        mangas.add(new Manga(2L,"Dragon ball z",2.20));
        mangas.add(new Manga(4L,"Attact on titan",2.99));

        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        Manga mangaToSearch = new Manga(1L, "Pokemon", 3.2);
        System.out.println(Collections.binarySearch(mangas, mangaToSearch));
        System.out.println("------------");

        mangas.sort(new MangaByIdComparator()); //por ID
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
