package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        //A vantagem do Set é que ele não permite elementos duplicados detro da coleção, apenas unicos.
        //Não existe indice, posições no set, ex: não usamos get posição 1
        //não fica na ordem de inserção, caso queira, use linkedList, mostrará na ordem que botou
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(5L,"Berserk",19.9,0));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5,5));
        mangas.add(new Manga(3L,"Pokemon",3.2,0));
        mangas.add(new Manga(2L,"Dragon ball z",2.20,2));
        mangas.add(new Manga(4L,"Attact on titan",2.99,0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
