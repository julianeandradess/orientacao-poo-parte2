package academy.dev.Test.Colecoes.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        //desse jeito conseguimos de uma ArrayList pegar valores em um array
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println("----------------");
        //Object[] array = numeros.toArray();//caso você precise de uma array (objetos) ou
        Integer[] listToArray = numeros.toArray(new Integer[0]);//array sobrecarregada, T. Pede um array de objeto
        System.out.println(Arrays.toString(listToArray));

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        //asList é problemático, cria um link com a forma original, nesse caso seria a numerosArray
        //complicando não só a performance como para adicionar, pq causará uma excessão
        List<Integer> arrayToList = Arrays.asList(numerosArray);//transformando uma array numa list
        arrayToList.set(0,12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
        System.out.println("---------------");

        //fazer a mudança sem alterações
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray)); //podemos passar uma outra coleção
        numerosList.add(15);
        System.out.println(numerosList);

       List<String> strings = Arrays.asList("1", "2", "3", "4", "5");//Arrays.asList(1,2,3,4,5);como criar uma arrayList com uma unica linha
       List.of("1,2");
    }
}
