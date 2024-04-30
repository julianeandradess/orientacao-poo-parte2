package javacore2.Vio.Test.Colecoes.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        //Outra forma que temos de fazer busca em uma coleção/arrays
        //A diferença é que o Binary retorna a posição que deveriamos inserir esse elemento caso não exista
        //caso não encontre o indice passado, irá retornar algo seguindo tais regras:
        //(-(ponto de inserção) - 1)
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);

        //index: 0,1,2,3
        //value: 0,2,3,4
        Collections.sort(numeros); //antes de usar o Binary, precisamos ordenar-las
        System.out.println(Collections.binarySearch(numeros, 3)); //irá dar o indice de acordo com a chave
    }
}
