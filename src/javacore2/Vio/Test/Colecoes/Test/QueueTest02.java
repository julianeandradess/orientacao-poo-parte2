package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Consumidor;
import javacore2.Vio.Test.Colecoes.Dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        //<String> a classe que definimos ali dentro, precisa obrigatoriamente ser um Comparable, sem ela
        // causará uma excessão
        //PriorityQueue, quer dizer que podemos definir a prioridade
        //Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed()); caso quisessemos do mais caro ao mais barato
        Consumidor consumidor = new Consumidor("Leah");
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L,"Berserk",19.9,0));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5,5));
        mangas.add(new Manga(3L,"Pokemon",3.2,0));
        mangas.add(new Manga(2L,"Dragon ball z",2.20,2));
        mangas.add(new Manga(4L,"Attact on titan",2.99,0));

        //ex: vai que voce quer remover/vender os mais importantes de acordo com o preço:
        while(!mangas.isEmpty()){
            System.out.println(mangas.poll()); //nosso comparator ajuda o pool a organizar, nesse caso, pelo o mais barato
        }
    }
}
