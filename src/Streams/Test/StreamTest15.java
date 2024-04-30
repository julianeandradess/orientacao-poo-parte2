package Streams.Test;

import Streams.Dominio.Category;
import Streams.Dominio.LightNovel;
import Streams.Dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {
    private static List<LightNovel> novelList10 = new ArrayList<>(List.of(
            new LightNovel("Xitake", 8.99, Category.FANTASY),
            new LightNovel("Cogumelo",3.99, Category.ROMANCE),
            new LightNovel("Chockito", 5.99, Category.DRAMA),
            new LightNovel("Kani", 2.99, Category.FANTASY),
            new LightNovel("Tare",5.99, Category.ROMANCE),
            new LightNovel("Chimegi", 1.99, Category.DRAMA),
            new LightNovel("Chimegi", 1.99, Category.FANTASY),
            new LightNovel("Xolo",4.00, Category.ROMANCE),
            new LightNovel("Rocco",6.99, Category.DRAMA)
    ));

    public static void main(String[] args) {
        //imagine que você quer agrupar e ter as estatisticas relacionadas a preço
        Map<Category, DoubleSummaryStatistics> categoryDoubleSummaryStatisticsMap = novelList10.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(categoryDoubleSummaryStatisticsMap);

        System.out.println("--");
        //sem os numeros
        Map<Category, List<Promotion>> categoryListMap = novelList10.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.mapping(StreamTest15::getPromotion, Collectors.toList())));
        System.out.println(categoryListMap);
        System.out.println("--");
        //sem duplicar o resultado abaixo, a implementação do set é um HashSet
        Map<Category, Set<Promotion>> categorySetMap = novelList10.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())));
        System.out.println(categorySetMap);
        System.out.println("--");

        //sem o hashSet, usando o linked
        Map<Category, Set<Promotion>> categorySetLinked = novelList10.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.mapping(StreamTest15::getPromotion, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(categorySetLinked);


    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
