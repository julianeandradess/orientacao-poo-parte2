package Lambdas.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
Funcion: é uma interface funcional, tem uma pequena diferença, teremos o tipo <T, R>
o t é o que voce vai receber e o R é o que vai voltar.
(String s) é como está e o final é como queremos
chama uma função com um dado valor this e argumentos providos como uma array ou objeto parecido com uma
Method Reference é usar um metodo referencia, ex:
List<String> strings1 = map(strings, String::toUpperCase);
entra o tipo e o método.
 */

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Nato", "Natan");
        List<Integer> integers = map(strings, (String s) -> s.length()); //tamanho da lista, pelo nome
        List<String> strings1 = map(strings, s -> s.toUpperCase());

        System.out.println(integers);
        System.out.println(strings1);
    }

    //temos 2 tipos, vai retornar ao parametro do tipo T, outro para retorno, sendo uma lista do tipo R
    //o que queremos retornar é uma lista de R(retorno)
    //chamamos de map toda vez que temos que retornar/transformar alguma coisa
    //o que queremos receber no parametro é uma lista de T
    private static  <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> resultado = new ArrayList<>(); //retorno
        for (T e : list) {
            R r = function.apply(e);
            resultado.add(r);

        }
        return resultado;

    }

}
