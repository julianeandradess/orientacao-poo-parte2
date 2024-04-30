package javacore2.Vio.Test.Zgenerics.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        //como começou o generics, antes não usavam e com isso ficava restrito a colocação da variavel dentro
        //do proprio for, usando como objeto, porem atrapalhava quando se criava outra lista ou quando se tinha que chamar o objeto
        //uso do generics nos permite classifica o que vamos colocar dentro de uma lista. String, Double...
        //Porem, não faça uma lista sem generics e dps com, causa excessão
        List<String> lista = new ArrayList<>();
        lista.add("blablabla");
        lista.add("blebleble");

        for (String object : lista) {
            System.out.println(object);
        }
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1234);
        numeros.add(5678);

        for (Integer numero : numeros) {
            System.out.println(numero);
        }


    }
}
