package Streams.Test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

//FlatMap é parecido com o map, a diferença é que utilizado quando temos propriedades aninhadas, uma dentro da outra
public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> arrayMulti = new ArrayList<>();

        List<String> grafica = List.of("Paula", "Maraisa", "Pamela", "Samanta", "Barbara");//lista separada
        List<String> devs = List.of("Renato", "Maycon","Leonardo", "Bento", "Liam");
        List<String> estudantes = List.of("Rosane", "Marisa","Leticia", "Bianca", "Leon");
        arrayMulti.add(grafica);
        arrayMulti.add(devs);
        arrayMulti.add(estudantes);

        //imprimir sem o stream, botando tudo numa lista só:

        System.out.println("------");
        //com stream
        //usando o map, vai gerar Stream<Stream<String>>, não é o que queremos
        // l -> l.stream() alt+enter, l = lista de string


        arrayMulti.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
