package academy.dev.Streams.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
Observações sobre Parallel:
Benchmark
unboxing | boxing (int, Integer)
(limit, first) - não são boas de usar, podemos usar o findAny para fins paralelelos
custo total da computação
se a quantidade de dados for pequena, não o use
tipos de coleções, arrayList é excelente, já a linkedList não, o Set tem uma melhor perfomance
quando temos o tamanho do stream, geralmente os que tem o tamanho estabelecidos são melhores
processamento merge
 */
public class StreamTest16 {
    public static void main(String[] args) {

        //Stream parallel é basicamente uma forma que o java fez para abstrair a complexidade
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 50_000_00;
        sumFor(num);
        sumStreamIterate(num);
        sumStreamParallelsIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num );
    }
    private static void sumFor(long num){
        System.out.println("Sum For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i=1; i<num ; i++){
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
    private static void sumStreamIterate(long num){
        System.out.println("Sum Stream Iterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
    //paralelo
    private static void sumStreamParallelsIterate(long num){
        System.out.println("Sum Stream Parallel Iterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
    private static void sumLongStreamIterate(long num){
        System.out.println("Sum Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
    private static void sumParallelLongStreamIterate(long num){
        System.out.println("Sum Parallel Long Stream Iterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
}
