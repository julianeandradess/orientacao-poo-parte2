package academy.dev.Lambdas.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

//Ao inves de usar uma classe static ou objeto, usamos uma classe comum, digamos assim.
//Reference to an instance method of an arbitrary object of a particular type
public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimaru"));
        List<Integer> integerList = new ArrayList<>(List.of(192,20,42,30));

        stringList.sort(String::compareTo);
        integerList.sort(Integer::compareTo);

        System.out.println(stringList);
        System.out.println(integerList);

        System.out.println("----------");
        //digamos que queremos fazer uma função e queremos transformar uma string em um Integer, em lambda
        //Function<String, Integer> numStringToInteger = s -> Integer.parseInt(s); completa
        Function<String, Integer> numStringToInteger = Integer::parseInt; //rapida
        Integer num = numStringToInteger.apply("10"); //pode ser colocado dentro do sout
        System.out.println(num);

        System.out.println("------");
        //verificar se tem um elemento dentro da lista
        //na predicate só teriamos uma opção, já o BiPredicate, temos dois argumentos
        //passaremos uma lista de string e verificaremos se o nome está dentro, sendo o outro argumento uma string tbm
        BiPredicate<List<String>, String> checkName = List::contains; //contains: fornece um utilitario para localizar qualquer sequencia de caracteres ou string
        System.out.println(checkName.test(stringList, "Rimuru")); // 1- a lista que quer procurar, 2- o que quer procurar

        BiPredicate<List<Integer>, Integer> checkNum = List::contains;
        System.out.println(checkNum.test(integerList, 192));


    }
}

