package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Manga;
import javacore2.Vio.Test.Colecoes.Dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

//caso não tenha acesso a classe que está mexendo, crie uma pois pedirá o comparator:

class SmartphoneMarcaComparator implements Comparator<Smartphone>{

    @Override
    public int compare(Smartphone o1, Smartphone o2) {

        return o1.getMarca().compareTo(o2.getMarca());
    }
}
class MangaPrecoComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga o3, Manga o4) {
        return Double.compare(o3.getPreco(), o4.getPreco());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        /*Navigable é uma interface que extends de SortedSet, que extends do Set, significa que obrigatoriamente
        precisamos tomar cuidado quando inserimos elementos duplicados. Adiciona alguns metodos que podemos trabalhar
        para pegar elementos baseados em posiçoes e existencias.
        TreeSet não se baseia no equals para saber se os elementos são iguais e sim no compareTo, ou no Comparator.
        */
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);
        System.out.println(set);

        System.out.println("------------------");

        //está imprimindo por ordem alfabetica por conta do compareTo em Manga. Pois o Tree irá fazer a comparação baseado nele.
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L,"Berserk",19.9,0));
        mangas.add(new Manga(1L,"Hellsing Ultimate",9.5,5));
        mangas.add(new Manga(3L,"Pokemon",3.2,0));
        mangas.add(new Manga(2L,"Dragon ball z",2.20,2));
        mangas.add(new Manga(4L,"Attact on titan",2.99,0));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("------------------");

        //ordem alfabetica/numeros inversa
        for (Manga manga1 : mangas.descendingSet()) {
            System.out.println(manga1);
        }

        //metodos para comparação interessante saber:
        //lower: vai trazer dentro dessa coleção o que é imediatamente menor <
        //floor: vai trazer o mesmo elemento ou caso não exista mostra o imediato ou logo abaixo dele <=
        //higher: primeiro maior >
        //ceiling: >=
        System.out.println("-----------");
        Manga yuyu = new Manga(21L, "Yuyu Hakusho", 8, 5);
        System.out.println(mangas.lower(yuyu)); //trouxe o valor mais proximo porem mais baixo, Ex: preço yuyuy = 8, preço Pokemon = 3.2
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        //remover item da lista sendo um por um, do primeiro para o ultimo ou do ultimo para o primeiro
        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); //retorna/remove o primeiro elemento da lista
        System.out.println(mangas.size());
        System.out.println(mangas.pollLast()); //ultimas posições
        System.out.println(mangas.size());
    }
}
