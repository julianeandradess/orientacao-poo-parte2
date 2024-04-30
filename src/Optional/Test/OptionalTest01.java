package Optional.Test;


/*
optional é uma classe que foi introduzida na versão 8 do java, o intuito dessa classe é:
tentar evitar um nullpointerException, que é lançado quando se tenta utilizar o null tal como se fosse um obj
O principal objetivo é que o retorno de um metodo pode ser opcional, pode não vir, em vez retornar null,
retorna optional
Optional encapsula[], o of usado quer que você retorne um objeto e não um null, caso tentasse mudar, caso queira precisa
usar o ofNulllable(null)
caso voce tenha o nome e quer retornar ele, é como se fosse um if-else, se tiver vai mostrar o valor, senão:
nameOptional.orElse("EMPTY");
ifPresent é void, não tem retorno, não da pra chamar primeiro o sout e dps o metodo, precisa ser ao contrario.
 */

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("buuuuum");
        // Optional<String> o2 = Optional.of(null);
        Optional<String> o3 = Optional.ofNullable(null); //vai retonrar um optional vazio(Empty)
        Optional<String> o4 = Optional.empty(); //retornar um optional vazio
        System.out.println(o1);
        System.out.println(o3);
        System.out.println(o4);
        System.out.println("-------");

        //Optional<String> nameOptional = Optional.ofNullable(findName("Walla walla")); SENDO ASSIM COM O METODO DA ORACLE, VOCÊ NÃO PRECISA POR TUDO
        Optional<String> nameOptional = findName("Walla walla"); //Da certo naturalmente com o metodo

        //System.out.println(nameOptional);
        String emptys = nameOptional.orElse("EMPTY");
        System.out.println(emptys); //retorna o nome e não vazio
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase())); //pra ver o nome em caixa alta dentro dessa classe, claro

    }
    //OLHE A ANOTAÇÃO MAIS ABAIXO:
    /*private static String findName(String name){
        List<String> stringList = List.of("Walla walla", "Detroid");
        int i = stringList.indexOf(name);//verificar se o nome ta na lista
        if (i != 1){
            return stringList.get(i);
        }
        return null;
    }*/
    //O intuito da Oracle é ser assim, sendo o ideal, não que o outro esteja errado:
    //não é aconselhavel colocar o optional como parametro
    private static Optional<String> findName(String name) {
        List<String> stringList = List.of("Walla walla", "Detroid");
        int i = stringList.indexOf(name);//verificar se o nome ta na lista
        if (i != 1) {
            return Optional.of(stringList.get(i));
        }
        return Optional.empty(); //E caso não exista, voce retorna
    }
}
