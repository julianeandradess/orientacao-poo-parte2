package academy.dev.Streams.Test;


import academy.dev.Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    private static List<LightNovel> novelList4 = new ArrayList<>(List.of(
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
        //digamos que queremos encontrar algum produto com o valor > 8
        //anyMatch fará uma busca
        //allMatch = digamos que quer ter certeza que todos os produtos tem o valor maior que 0
        //noneMatch = se nenhum deles fosse maior que 0
        //só se usa o findAny quando não nos importamos com o resultado, com a ordem, retorna um Optional
        //findFrist = o primeiro elemento da lista que for maior que 3

        boolean anyMatch = novelList4.stream().anyMatch(ln -> ln.getPrice() > 8); //poderia colocar diretamente no sout
        System.out.println(anyMatch);

        System.out.println(novelList4.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(novelList4.stream().noneMatch(ln -> ln.getPrice() < 0));
        novelList4.stream()
                .filter(ln -> ln.getPrice() > 3)  //filtrar
                .findAny() //sem ordem
                .ifPresent(System.out::println);

        //chama o primeiro maior que 3 e não o ultimo
        novelList4
                .stream()
                .filter(ln -> ln.getPrice() > 3)
                .max(Comparator.comparing(LightNovel::getPrice).reversed() )
                .ifPresent(System.out::println);


        novelList4
                .stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice)) //chama o primeiro maior que 3 e não o ultimo
                .findFirst()
                .ifPresent(System.out::println);
    }


}

