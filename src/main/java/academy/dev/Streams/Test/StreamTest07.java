package academy.dev.Streams.Test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        //reduce é basicamente uma operação terminal dos streams que vai possibilitar de você ter um resultado unico
        //a partir de uma sequencia de elementos
        //somar todos os numeros


        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        integerList.stream().reduce((x,y) -> x + y)
                .ifPresent(System.out::println);
        System.out.println("1----------");

        //outra forma, não irá retornar um optional, vai retornar um valor final, inteiro.
        //se colocar o 0 em identity, passará a não retornar o optional

        Integer reduced = integerList.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduced);
        System.out.println("2----------");

        //usando metodo reference:
        //sum = int a, int b - return a + b (BinaryOperator)
        integerList.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println("3----------");

        Integer reduced2 = integerList.stream().reduce(0, Integer::sum);
        System.out.println(reduced2);
        System.out.println("4----------");

        //se quiser fazer multiplicação:
        //está multiplicando por 0, se for 0. Se for 1, irá normalmente
        integerList.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);
        System.out.println(integerList.stream().reduce(1, (x, y) -> x * y));

        //valor maximo entre uma lista de valores

        //forma feia, com operador ternario
        integerList.stream().reduce((x, y) -> x > y? x : y).ifPresent(System.out::println);

        //forma bonita:
        System.out.println(integerList.stream().reduce(0,Integer::max));






    }
}
