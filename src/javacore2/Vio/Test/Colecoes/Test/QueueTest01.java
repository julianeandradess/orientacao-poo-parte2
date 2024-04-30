package javacore2.Vio.Test.Colecoes.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        //tem por padrão a caracteristica o queue(fila), primeiro a entrar, primeiro a sair.
        //<String> a classe que definimos ali dentro, precisa obrigatoriamente ser um Comparable

        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");
        fila.add("D");

        while (!fila.isEmpty()){
            System.out.println(fila.poll()); //irá imprimir pra sempre, PEEK. POOL remove o elemento cabeça, organizando eles.
        }
    }
}
