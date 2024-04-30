package javacore2.Vio.Test.Colecoes.Test;

import javacore2.Vio.Test.Colecoes.Dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        //criar uma lista para guardar esses valores, pois geralmente trabalhamos com coleções

        Smartphone s1 = new Smartphone("1111","iphone");
        Smartphone s2 = new Smartphone("2222","Pixel");
        Smartphone s3 = new Smartphone("3333","Samsung");
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(0, s3);

        //smartphones.clear(); //caso queira limpar tudo que tem dentro da arrayList sem perder os objetos
        for (Smartphone smartphone: smartphones){
            System.out.println(smartphone);
        }

        //uso do equals, mesmos numeros, objetos diferentes. Verificação se está na lista
        // podemos alterar o index de um objeto, antecipando ele, no caso colocando como primeiro(0) smartphones.add(0, s3);
        // o uso do indexOf, te poupa de fazer um if
        Smartphone s4 = new Smartphone("2222","Pixel");

        System.out.println(smartphones.contains(s4)); //retorna true ou false, pra saber se tal objeto existe
        // Ambos são verificações parecidas, porque compara com o igual dele, o s2, faz a comparação pelo serialNumber
        System.out.println(s4.equals(s2)); //vai comparar o serialNumber, por isso vai dar true, se mudar, irá dar false
        int indexSmart4 = smartphones.indexOf(s4); //vai trazer o index do obj que voce tá passando e -1 caso não exista.
        System.out.println(indexSmart4);
        System.out.println(smartphones.get(indexSmart4));
        //vai pegar a posição que pedir do index, já que já verificou se existe no indedxOf
    }
}
