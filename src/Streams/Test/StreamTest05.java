package Streams.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        //vamos supor que queremos que retorne cada uma dessas letras em uma nova lista ou seja:
        //quero que essa nova lista cada letra tenha sua posição, ex: 0 - g, 1 - i
        // words.get(0).split("") = vai pegar a posiçao 0 e separar ""   - split= quebra

        List<String> words = List.of("Gami", "Gami", "Non", "Yees");
        String[] letras = words.get(2).split("");
        System.out.println(Arrays.toString(letras)); //todas as letras de uma palavra só

        /*
        com stream, porque acima só pega palavra a palavra e não todas:
        map - quebrar
        podemos ver abaixo que temos uma estrutura interna, que é uma colecção e precisamos extrair ela
        de dentro da lista, basicamente achatar esse ex.
        vai retornar uma lista com array de string
        transforma o collect em algo que podemos trabalhar com o que queremos desde o inicio, Retorna um Streams<String[]>
        */
        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        Stream<String> streamed = Arrays.stream(letras);//transformando em stream, para podermos pegar um array por ex
        List<String> letras2 = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)  //remover e pegar o array atraves, ficando assim só o Streams<String>
                .collect(Collectors.toList());//coletando
        System.out.println(letras2); //todas as letras das palatras
    }
}
