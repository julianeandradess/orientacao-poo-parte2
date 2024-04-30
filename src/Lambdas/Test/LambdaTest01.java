package Lambdas.Test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> strings = List.of("Louise", "Nara", "Lana", "Quenia");
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);

        forEach(strings, (String s) -> System.out.println(s));
        forEach(nums, (Integer n) -> System.out.println(n)); //forEach(nums, n-> System.out.println(n));

    }
    //lambda por argumento: Consumer<T> consumer)
    //accept: escuta uma conexão e aceita se alguma for encontrada, bloqueando todo o resto
    //definimos o comportamento atraves da lambda, seja inteface, porem faremos de forma direta pois não precisa haver retorno

    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T e : list) {
            consumer.accept(e);
        }

    }
}

/*
Consumer: É uma interface funcional, parecida com predicate, a diferença é que o consumer executa uma operação
e não retorna nada, o tipo de retorno é void
void = não é pra retornar nada, só imprimir
 */
