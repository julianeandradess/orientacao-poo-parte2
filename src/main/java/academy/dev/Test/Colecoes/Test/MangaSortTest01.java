package academy.dev.Test.Colecoes.Test;

import academy.dev.Test.Colecoes.Dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Berserk",19.9));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5));
        mangas.add(new Manga(3L,"Pokemon",3.2));
        mangas.add(new Manga(2L,"Dragon ball z",2.20));
        mangas.add(new Manga(4L,"Attact on titan",2.99));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("Agora com ordem");


        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("Agora com Comparator");


       //  Collections.sort(mangas, new MangaByIdComparator()); OS DOIS JEITOS FUNCIONAM
        mangas.sort(new MangaByIdComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
