package academy.dev.Streams.Test;

import academy.dev.Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. Ordene todos os lighNovel do nome
// 2. Traga o primeiro os 3 primeiros titulos light novel que sejam menor que o valor 4
//não da pra chamar o sout com list.of
public class StreamTest01 {
        private static List<LightNovel> novelList = new ArrayList<>(List.of(
                new LightNovel("Xitake", 8.99),
                new LightNovel("Cogumelo",3.99 ),
                new LightNovel("Chockito", 5.99),
                new LightNovel("Kani", 2.99),
                new LightNovel("Tare",5.99),
                new LightNovel("Chimegi", 1.99),
                new LightNovel("Xolo",4.00)
        ));

    public static void main(String[] args) {
        novelList.sort(Comparator.comparing(LightNovel::getNome)); //sem o stream
        List<String> nomes = new ArrayList<>();
        for (LightNovel lightNovel : novelList) {
            if (lightNovel.getPrice() <= 4){
                nomes.add(lightNovel.getNome());
            }
            if (nomes.size() >= 3){
                break;
            }
        }

        System.out.println(novelList);
        System.out.println(nomes);

    }
}
