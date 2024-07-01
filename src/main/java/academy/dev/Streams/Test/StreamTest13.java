package academy.dev.Streams.Test;

import academy.dev.Streams.Dominio.Category;
import academy.dev.Streams.Dominio.LightNovel;
import academy.dev.Streams.Dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamTest13 {
    private static List<LightNovel> novelList8 = new ArrayList<>(List.of(
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
        //a ideia é fazer um agrupamento onde se o preço for menor que < 6
        //lambda com ternario, se ln for menor que 6, agrupa em under_promotion senão, normal_price
        //retornando um map como planejado

        Map<Promotion, List<LightNovel>> promotionListMap = novelList8.stream()
                .collect(groupingBy(ln ->
                    ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE

                ));
        System.out.println(promotionListMap);

        //separar por promoção de acordo com a categoria, abaixo é parecido com o de cima(sem ser refeito com a IDE
        //conta com 2 collect, sendo o primeiro separando por categoria e o segundo pela logica de negoio
        //(LightNovel::getCategory, Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)
        Map<Category, Map<Promotion, List<LightNovel>>> categoryMap = novelList8.stream().collect(groupingBy(LightNovel::getCategory,
                groupingBy(StreamTest13::getPromotion)
        ));
        System.out.println(categoryMap);
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
