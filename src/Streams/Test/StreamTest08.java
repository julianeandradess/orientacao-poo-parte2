package Streams.Test;

import Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamTest08 {
    private static List<LightNovel> novelList5 = new ArrayList<>(List.of(
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
        //some todos os preços acima de 3, retornando somente a soma dos preço
        // map irá extrair tudo que voce precisa para usar no reduce
        novelList5.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);
        System.out.println("-----------");

        //usando o Double, sem ser primitivo

        double sum = novelList5.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();
        System.out.println(sum);


    }
}
