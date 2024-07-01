package academy.dev.Streams.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        //2 formas de gerar streams infinitos:
        //1 atraves do Stream.iterate(aceita o seed e UnaryOperator) e 2 Stream.genarate(aceita Supplier)

        Stream.iterate(1, n -> n + 2)
                .limit(20)
                .forEach(System.out::print);
        System.out.println("---");
        //fibonatti = são os valores numericos sempre somados ao anterior = 0 + 1, 1. 1+1= 2. 2+1=3. 3+2=5. 5+3=8
        //queremos que a entrega seja nesse modelo (0,1), (1,1), (1,2)...
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        System.out.println("----");
        //sem estar alinhado
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a [0])
                .forEach(System.out::println);

        //genarate não aceita binaryOperator
        //gerando numeros aleatorios de 1-100, com limite de 45 numeros
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 100))
                .limit(45)
                .forEach(System.out::println);
    }
}
