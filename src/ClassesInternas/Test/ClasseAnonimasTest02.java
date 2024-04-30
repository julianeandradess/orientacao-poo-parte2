package ClassesInternas.Test;


import javacore2.Vio.Test.Zgenerics.Dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
poderiamos criar uma class como fizemos em coleções, assim:
class BarcoNameComparator implements Comparator<Barco>{
    @Override
    public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}*/

public class ClasseAnonimasTest02 {
    public static void main(String[] args) {
        //criação de uma classe anonima, para podermos instanciar uma interface, o comparator de uma class
        List<Barco> barcosList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        barcosList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        }); // em uma linha: barcosList.sort(o1, 02) -> o1.getNome.compareTo(o2.getNome);
        System.out.println(barcosList);

    }

}
