package academy.dev.Concorrencia.test;

/*
 objeto imutavel, ex: os que levam o "final" porque não podem ser extendidos,
 alterar atributos sem permissão
 porem uma class imutavel você tem que remover toda e qualquer forma de acesso para trocar os atributos
 para fazer isso dar certo dessa forma, teriamos que criar um obj tbm sendo final e
 dando acesso somente a leitura, get. A única forma de trocar os valores do obj seria criando um novo obj

final class Anime{
    private final String name;

    public Anime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}*/
//CopyWrite é basicamente parecido, é uma lista "imutavel"

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyWriteTest01 {
    public static void main(String[] args) {
        // a ideia é voce trabalhar com uma lista imutavel mas a lista em si é mutavel
        // copiando e não modificando a original, sempre criando uma nova lista a cada coisa acrescentada
        // o uso do interator, ele mantem uma copia pro valor original

        List<Integer> listIntegers = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            listIntegers.add(i);
        }
        Runnable runnableInterator = ()->{
            Iterator<Integer> iterator = listIntegers.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable runnableRemove = ()->{
            for (int i = 0; i < 20; i++) {
                System.out.printf("%s removido %d%n", Thread.currentThread().getName(), i);
            }
        };

        new Thread(runnableInterator).start();
        new Thread(runnableInterator).start();
        new Thread(runnableRemove).start();
    }
}
