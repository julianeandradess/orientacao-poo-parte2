package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new LinkedList<>();
        //para fazer remoção acaba sendo melhor e mais viavel o linkedList, porem podemos fazer tranquilamente com array
        //só não aceita tamanhos, apenas a coleção, diferente do arraylist
        //List<Manga> mangas = new ArrayList<>(6);

        mangas.add(new Manga(5L,"Berserk",19.9,0));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5,5));
        mangas.add(new Manga(3L,"Pokemon",3.2,0));
        mangas.add(new Manga(2L,"Dragon ball z",2.20,2));
        mangas.add(new Manga(4L,"Attact on titan",2.99,0));

        //não usem for it para remoção do jeito abaixo, causará uma excessão
        /*for (Manga manga : mangas) {
            if (manga.getQuantidade() == 0){
                mangas.remove(manga);
            }
        }*/
        //melhor forma:
        //interator é meio que uma classe que checa antes de alguma ação
        //hastNext = enquanto existir - next = proximo

        /*Iterator<Manga> mangaIterator = mangas.iterator(); //é um interator do tipo manga
        while(mangaIterator.hasNext()){
            if (mangaIterator.next().getQuantidade() == 0){
                mangaIterator.remove();
            }
        }*/ 

        //logica de negocio rapido:
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);

    }
}
