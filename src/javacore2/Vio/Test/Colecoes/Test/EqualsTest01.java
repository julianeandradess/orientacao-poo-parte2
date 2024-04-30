package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        /*para que usamos o equals: serve para comparar os valores, independente da forma anunciada, String/new String
        String nome = "Juliane";
        String nome2 = new String("Juliane");
        System.out.println(nome.equals(nome2));*/

        //abaixo vemos um resultado diferente pois cada smart1/2 estão fazendo referencia a um obj distintos, é false
        //só daria true se referenciassemos um ao outro, ex: martphone smart2 = smart1.
        Smartphone smart1 = new Smartphone("1BC1","iPhone");
        Smartphone smart2 = new Smartphone("1BC1","iPhone");
        System.out.println(smart1.equals(smart2));
    }
}
