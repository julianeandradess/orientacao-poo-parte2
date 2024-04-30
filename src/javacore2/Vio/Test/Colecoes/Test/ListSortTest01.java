package javacore2.Vio.Test.Colecoes.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        //sortidas, não tem uma ordem especifica.
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Berserk");
        mangas.add("Hellsing Ultimate");
        mangas.add("Pokemon");
        mangas.add("Dragon ball z");
        mangas.add("Attact on titan");

        Collections.sort(mangas); // ordenação dessa lista. Todos os métodos dessa coleção são estáticos
        for (String manga : mangas) {
            System.out.println(manga);
        }

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23.98);
        dinheiros.add(21.21);
        dinheiros.add(98.10);
        Collections.sort(dinheiros);
        for (Double dinheiro : dinheiros) {
            System.out.println(dinheiro);
        }

    }
}
