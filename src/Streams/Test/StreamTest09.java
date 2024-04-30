package Streams.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

public class StreamTest09 {
    public static void main(String[] args) {
        //criando stream a partir deles próprios
        //IntStream = vai gerar uma lista de inteiros
        IntStream.rangeClosed(1, 50).filter(n -> n % 2 ==0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("----");

        //sem closed
        IntStream.range(1, 50).filter(n -> n % 2 ==0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("----");

        Stream.of("Elen", "Bianco", "Monica", "Nono")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("----");

        //com arrays
        int num[] = {1,2,3,4,5};
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);
        System.out.println("-----");

        //quando for criar um arquivo pelo o stream, é mais seguro usar try
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines.filter(l -> l.contains("Java")).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
