package Streams.Test;

import Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    private static List<LightNovel> novelList6 = new ArrayList<>(List.of(
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
        System.out.println(novelList6.stream().count());
        System.out.println(novelList6.stream().collect(Collectors.counting()));
        System.out.println("--");

        //maximo/minimo em relação ao mais caro/barato sem e com Collectors
        novelList6.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        novelList6.stream().min(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        System.out.println("--");

        //se retornar o Optional, use o ifPresent
        novelList6.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);
        System.out.println("--");

        //soma
        System.out.println(novelList6.stream().mapToDouble(LightNovel::getPrice).sum());
        System.out.println(novelList6.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));

        System.out.println("--");
        novelList6.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
        System.out.println(novelList6.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        System.out.println("--");
        //summary com estatisticas
        DoubleSummaryStatistics summary = novelList6.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(summary);

        System.out.println("--");
        //digamos que queremos separar os nomes por virgulas sem colocá-las no sout
        //com o joining basta usar delimitador ", "
        String strings = novelList6.stream().map(LightNovel::getNome).collect(Collectors.joining(", "));
        System.out.println(strings);

    }
}
