package javacore2.Vio.Test.Zgenerics.Test;

import javacore2.Vio.Test.Zgenerics.Dominio.Barco;
import javacore2.Vio.Test.Zgenerics.Dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("canoa Marota")); //especificamos onde queremos que o metodo atue
        System.out.println(barcoList);
        System.out.println("------------");

        List<Carro> carroList = criarUmArray(new Carro("Gol bolinha"));
        System.out.println(carroList);
    }


    //metodo com generics:
    //caso quisesse retornar alguma coisa, tem que tirar o void:
    //private static <T> List<T> criarArrayComUmObjeto (T t){List<T> list =List.of(t); return list;}
    //digamos que queremos receber objetos que extends do comparable:
    //private static <T extends Comparable> List<T> criarArrayComUmObjeto(T t){ return List.of(t);


    private static <T> List<T> criarArrayComUmObjeto(T t){
        return List.of(t);
        // ou new ArrayList<>(); list.add(t)
    }

    private static <I> List<I> criarUmArray(I i){
        return List.of(i);
    }
}
//quando estamos trabalhando com generics podemos colocar quantos atributos queremos
//podendo criar tbm get/set
/*
main{
new DoisAtributos<Cachorro, Gato, Carro>();
}
class DoisAtributos<T, X, I> {
    private T t;
    private X x;
    private I i;
}
 */