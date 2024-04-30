package Streams.Test;

import Streams.Dominio.Category;
import Streams.Dominio.LightNovel;
import Streams.Dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest14 {
    private static List<LightNovel> novelList9 = new ArrayList<>(List.of(
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
        //digamos que queremos contar quantos lightnovel por categoria, agrupando por categoria e o mostrando o maior preço
        //agrupando e contando
        Map<Category, Long> categoryLongMap = novelList9.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(categoryLongMap);
        System.out.println("--");

        //categoria e maior preço, de primeira retorna um optional
        Map<Category, Optional<LightNovel>> collect1 = novelList9.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);
        System.out.println("--");

        //corrigindo o optional, coletando e então
        Map<Category, LightNovel> collect2 = novelList9.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),
                        Optional::get)));
        System.out.println(collect2);
    }
}
