package Streams.Test;

import Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest03 {
    private static List<LightNovel> novelList3 = new ArrayList<>(List.of(
            new LightNovel("Xitake", 8.99),
            new LightNovel("Cogumelo",3.99 ),
            new LightNovel("Chockito", 5.99),
            new LightNovel("Kani", 2.99),
            new LightNovel("Tare",5.99),
            new LightNovel("Chimegi", 1.99),
            new LightNovel("Chimegi", 1.99),
            new LightNovel("Xolo",4.00)
    ));

    public static void main(String[] args) {
        //operações que podemos fazer, final, é o forEach, assim terá a lista de todos os itens
        //botar o metodo fora do stream faz diferença porque ele transforma seus dados do espaço para o tempo, porem
        //podemos fazer porque ai não desperdiçamos tempo já que é o mesmo resultado
        //filtrar um determinado valor
        // .count() alt+enter, para adicionar variavel local  ---- contar
        // se fechar um stream e quiser usar de novo dá ruim, precisa chamar novamente no inicio: novelList3.stream().distinct()
        //elemento distinto (unico), operação intermediaria, vai retornar outro stream
        //sempre que for usar o distinct, verifique o hashcode

        Stream<LightNovel> lightNovelStream = novelList3.stream();
        novelList3.forEach(System.out::println); //ln -> sout(ln) alt+enter
        long counted = lightNovelStream.filter(ln -> ln.getPrice() <= 4).count();

        long counted2 = novelList3.stream()
                .distinct().filter(ln -> ln.getPrice() <= 4)
                .count();
        System.out.println(counted);
        System.out.println(counted2);
    }
}
