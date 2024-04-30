package Streams.Test;

import Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest02 {
    private static List<LightNovel> novelList2 = new ArrayList<>(List.of(
            new LightNovel("Xitake", 8.99),
            new LightNovel("Cogumelo",3.99 ),
            new LightNovel("Chockito", 5.99),
            new LightNovel("Kani", 2.99),
            new LightNovel("Tare",5.99),
            new LightNovel("Chimegi", 1.99),
            new LightNovel("Xolo",4.00)
    ));

    public static void main(String[] args) {
        //No stream temos 2 operações: intermediárias ou finais
        //ação intermediaria retorna o proprio stream, pode encadear ações, filtrar, limitar
        //map extrai aquilo
        //basicamente reescrevendo o test01

        List<String> nomes = novelList2.stream()  //iniciando
                .sorted(Comparator.comparing(LightNovel::getNome)) //intermediaria. Fazendo a comparação por titulo
                .filter(ln -> ln.getPrice() <= 4)  //intermediaria. Filtrando
                .limit(3)   //Limitando
                .map(ln -> ln.getNome())  //map(LightNovel::getNome) função, o retorno é diferente  Intermediaria
                .collect(Collectors.toList());//coletar para agrupar, retornando uma nova lista
        System.out.println(nomes);
    }

}
